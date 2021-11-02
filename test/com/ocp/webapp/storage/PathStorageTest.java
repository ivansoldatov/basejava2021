package com.ocp.webapp.storage;

import com.ocp.webapp.storage.serialization.ObjectStreamSerializer;

class PathStorageTest extends AbstractStorageTest {

    public PathStorageTest() {
        super(new PathStorage(STORAGE_DIR, new ObjectStreamSerializer()));
    }
}