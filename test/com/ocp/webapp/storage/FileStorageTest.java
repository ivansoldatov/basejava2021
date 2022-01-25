package com.ocp.webapp.storage;

import com.ocp.webapp.storage.serialization.ObjectStreamSerializer;

class FileStorageTest extends AbstractStorageTest {
    public FileStorageTest() {
        super(new FileStorage(STORAGE_DIR, new ObjectStreamSerializer()));
    }
}