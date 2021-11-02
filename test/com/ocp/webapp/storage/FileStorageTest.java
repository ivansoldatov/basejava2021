package com.ocp.webapp.storage;

import com.ocp.webapp.storage.serialization.ObjectStreamSerializer;

import java.io.File;

class FileStorageTest extends AbstractStorageTest {
    public FileStorageTest() {
        super(new FileStorage(new File(STORAGE_DIR), new ObjectStreamSerializer()));
    }
}