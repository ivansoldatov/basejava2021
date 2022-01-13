package com.ocp.webapp.storage;

import com.ocp.webapp.storage.serialization.JsonStreamSerializer;

class JsonPathStorageTest extends AbstractStorageTest {

    public JsonPathStorageTest() {
        super(new PathStorage(STORAGE_DIR, new JsonStreamSerializer()));
    }
}