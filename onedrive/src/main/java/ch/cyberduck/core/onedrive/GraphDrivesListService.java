package ch.cyberduck.core.onedrive;

/*
 * Copyright (c) 2002-2017 iterate GmbH. All rights reserved.
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

import ch.cyberduck.core.Cache;
import ch.cyberduck.core.ListService;
import ch.cyberduck.core.Path;

import org.apache.log4j.Logger;
import org.nuxeo.onedrive.client.OneDriveDrive;
import org.nuxeo.onedrive.client.OneDriveDrivesIterator;

import java.util.Iterator;

/**
 * List the available drives for a user (OneDrive) or SharePoint site (document libraries).
 */
public class GraphDrivesListService extends AbstractDriveListService {
    private static final Logger log = Logger.getLogger(GraphDrivesListService.class);

    private final GraphSession session;

    public GraphDrivesListService(final GraphSession session) {
        this.session = session;
    }

    @Override
    protected Iterator<OneDriveDrive.Metadata> getIterator(final Path directory) {
        // In most cases, OneDrive and OneDrive for Business users will only have a single
        // drive available, the default drive. When using OneDrive API with a SharePoint team site,
        // this API returns the collection of document libraries created in the site.
        return new OneDriveDrivesIterator(session.getClient());
    }
}
