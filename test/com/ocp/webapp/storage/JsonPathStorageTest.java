package com.ocp.webapp.storage;

import com.ocp.webapp.storage.serialization.JsonStreamSerializer;
import com.ocp.webapp.storage.serialization.XmlStreamSerializer;

class JsonPathStorageTest extends AbstractStorageTest {

    public JsonPathStorageTest() {
        super(new PathStorage(STORAGE_DIR, new JsonStreamSerializer()));
    }
}