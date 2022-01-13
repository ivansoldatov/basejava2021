package com.ocp.webapp.storage;

import com.ocp.webapp.storage.serialization.DataStreamSerializer;

class DataPathStorageTest extends AbstractStorageTest {

    public DataPathStorageTest() {
        super(new PathStorage(STORAGE_DIR, new DataStreamSerializer()));
    }
}