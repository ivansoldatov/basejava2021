package com.ocp.webapp.storage;

import java.io.File;

import static org.junit.jupiter.api.Assertions.*;

class ObjectStreamStorageTest extends AbstractStorageTest {

    public ObjectStreamStorageTest() {
        super(new ObjectStreamStorage(new File(STORAGE_DIR)));
    }
}