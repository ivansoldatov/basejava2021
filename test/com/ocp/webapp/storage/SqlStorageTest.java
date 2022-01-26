package com.ocp.webapp.storage;

import com.ocp.webapp.Config;

class SqlStorageTest extends AbstractStorageTest {

    public SqlStorageTest() {
        super(Config.get().getStorage());
    }
}