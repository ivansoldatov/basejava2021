package com.ocp.webapp.storage;

import com.ocp.webapp.storage.serialization.XmlStreamSerializer;

class XmlPathStorageTest extends AbstractStorageTest {

    public XmlPathStorageTest() {
        super(new PathStorage(STORAGE_DIR, new XmlStreamSerializer()));
    }
}