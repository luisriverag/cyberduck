package ch.cyberduck.core.spectra;

/*
 * Copyright (c) 2002-2019 iterate GmbH. All rights reserved.
 * https://cyberduck.io/
 *
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 */

import ch.cyberduck.core.AttributedList;
import ch.cyberduck.core.Cache;
import ch.cyberduck.core.DefaultIOExceptionMappingService;
import ch.cyberduck.core.ListProgressListener;
import ch.cyberduck.core.ListService;
import ch.cyberduck.core.Path;
import ch.cyberduck.core.PathAttributes;
import ch.cyberduck.core.PathContainerService;
import ch.cyberduck.core.PathNormalizer;
import ch.cyberduck.core.exception.BackgroundException;
import ch.cyberduck.core.exception.NotfoundException;
import ch.cyberduck.core.preferences.Preferences;
import ch.cyberduck.core.preferences.PreferencesFactory;
import ch.cyberduck.core.s3.S3AbstractListService;
import ch.cyberduck.core.s3.S3PathContainerService;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

import com.spectralogic.ds3client.Ds3Client;
import com.spectralogic.ds3client.commands.GetBucketRequest;
import com.spectralogic.ds3client.commands.GetBucketResponse;
import com.spectralogic.ds3client.models.Contents;
import com.spectralogic.ds3client.models.common.CommonPrefixes;
import com.spectralogic.ds3client.networking.FailedRequestException;

public class SpectraObjectListService extends S3AbstractListService {
    private static final Logger log = Logger.getLogger(SpectraObjectListService.class);

    private final Preferences preferences
        = PreferencesFactory.get();

    private final PathContainerService containerService
        = new S3PathContainerService();

    private final SpectraSession session;

    public SpectraObjectListService(final SpectraSession session) {
        this.session = session;
    }

    @Override
    public AttributedList<Path> list(final Path directory, final ListProgressListener listener) throws BackgroundException {
        return this.list(directory, listener, preferences.getInteger("s3.listing.chunksize"));
    }

    @NotNull
    protected AttributedList<Path> list(final Path directory, final ListProgressListener listener, final int chunksize) throws BackgroundException {
        try {
            final String prefix = this.createPrefix(directory);
            final AttributedList<Path> objects = new AttributedList<Path>();
            final Ds3Client client = new SpectraClientBuilder().wrap(session.getClient(), session.getHost());
            final Path bucket = containerService.getContainer(directory);
            long revision = 0L;
            String marker = null;
            String lastKey = null;
            boolean hasDirectoryPlaceholder = containerService.isContainer(directory);
            do {
                final GetBucketResponse response = client.getBucket(new GetBucketRequest(bucket.getName())
                    .withVersions(true)
                    .withDelimiter(String.valueOf(Path.DELIMITER))
                    .withMarker(marker)
                    .withPrefix(prefix)
                    .withMaxKeys(chunksize));
                for(final Contents object : response.getListBucketResult().getObjects()) {
                    final String key = PathNormalizer.normalize(object.getKey());
                    if(String.valueOf(Path.DELIMITER).equals(key)) {
                        log.warn(String.format("Skipping prefix %s", key));
                        continue;
                    }
                    if(new Path(bucket, key, EnumSet.of(Path.Type.directory)).equals(directory)) {
                        hasDirectoryPlaceholder = true;
                        // Placeholder object, skip
                        continue;
                    }
                    objects.add(new Path(directory, PathNormalizer.name(key), object.getKey().endsWith(String.valueOf(Path.DELIMITER))
                        ? EnumSet.of(Path.Type.directory) : EnumSet.of(Path.Type.file), this.toAttributes(object)));
                }
                for(final Contents object : response.getListBucketResult().getVersionedObjects()) {
                    final String key = PathNormalizer.normalize(object.getKey());
                    if(String.valueOf(Path.DELIMITER).equals(key)) {
                        log.warn(String.format("Skipping prefix %s", key));
                        continue;
                    }
                    if(new Path(bucket, key, EnumSet.of(Path.Type.directory)).equals(directory)) {
                        hasDirectoryPlaceholder = true;
                        // Placeholder object, skip
                        continue;
                    }
                    if(!StringUtils.equals(lastKey, key)) {
                        // Reset revision for next file
                        revision = 0L;
                    }
                    final PathAttributes attributes = this.toAttributes(object);
                    attributes.setRevision(++revision);
                    if(attributes.isDuplicate()) {
                        if(attributes.getRevision() == 1) {
                            // Allow to undelete if latest version is delete marker
                            final Map<String, String> custom = new HashMap<>(attributes.getCustom());
                            custom.put(SpectraVersioningFeature.KEY_REVERTABLE, Boolean.TRUE.toString());
                            attributes.setCustom(custom);
                        }
                    }
                    objects.add(new Path(directory, PathNormalizer.name(key), object.getKey().endsWith(String.valueOf(Path.DELIMITER))
                        ? EnumSet.of(Path.Type.directory) : EnumSet.of(Path.Type.file), attributes));
                    lastKey = key;
                }
                for(CommonPrefixes common : response.getListBucketResult().getCommonPrefixes()) {
                    if(String.valueOf(Path.DELIMITER).equals(common.getPrefix())) {
                        log.warn(String.format("Skipping prefix %s", common.getPrefix()));
                        continue;
                    }
                    final String key = PathNormalizer.normalize(common.getPrefix());
                    if(new Path(bucket, key, EnumSet.of(Path.Type.directory)).equals(directory)) {
                        continue;
                    }
                    objects.add(new Path(directory, PathNormalizer.name(key), EnumSet.of(Path.Type.directory, Path.Type.placeholder), new PathAttributes()));
                }
                marker = response.getListBucketResult().getMarker();
                listener.chunk(directory, objects);
            }
            while(marker != null);
            if(!hasDirectoryPlaceholder && objects.isEmpty()) {
                throw new NotfoundException(directory.getAbsolute());
            }
            return objects;
        }
        catch(FailedRequestException e) {
            throw new SpectraExceptionMappingService().map("Listing directory {0} failed", e, directory);
        }
        catch(IOException e) {
            throw new DefaultIOExceptionMappingService().map("Listing directory {0} failed", e, directory);
        }
    }

    @NotNull
    private PathAttributes toAttributes(final Contents object) {
        final PathAttributes attr = new PathAttributes();
        attr.setETag(object.getETag());
        attr.setModificationDate(object.getLastModified().getTime());
        attr.setOwner(object.getOwner().getDisplayName());
        attr.setSize(object.getSize());
        attr.setStorageClass(object.getStorageClass());
        attr.setVersionId(object.getVersionId().toString());
        final Boolean latest = object.getIsLatest();
        attr.setDuplicate(object.getSize() == 0L || !latest);
        return attr;
    }

    @Override
    public ListService withCache(final Cache<Path> cache) {
        return null;
    }
}