package ch.cyberduck.core.spectra;

/*
 * Copyright (c) 2002-2016 iterate GmbH. All rights reserved.
 * https://cyberduck.io/
 *
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 */

import ch.cyberduck.core.Path;
import ch.cyberduck.core.PathContainerService;
import ch.cyberduck.core.exception.BackgroundException;
import ch.cyberduck.core.features.Write;
import ch.cyberduck.core.s3.S3AccessControlListFeature;
import ch.cyberduck.core.s3.S3DirectoryFeature;
import ch.cyberduck.core.s3.S3PathContainerService;
import ch.cyberduck.core.transfer.TransferStatus;

import org.apache.commons.io.input.NullInputStream;
import org.jets3t.service.model.StorageObject;

public class SpectraDirectoryFeature extends S3DirectoryFeature {

    private final PathContainerService containerService;
    private final Write<StorageObject> writer;

    public SpectraDirectoryFeature(final SpectraSession session, final Write<StorageObject> writer) {
        super(session, writer, new S3AccessControlListFeature(session));
        this.containerService = new S3PathContainerService(session.getHost());
        this.writer = writer;
    }

    @Override
    public Path mkdir(final Path folder, final TransferStatus status) throws BackgroundException {
        if(containerService.isContainer(folder)) {
            return super.mkdir(folder, status);
        }
        else {
            status.setChecksum(writer.checksum(folder, status).compute(new NullInputStream(0L), status));
            return super.mkdir(folder, status);
        }
    }
}
