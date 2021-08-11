package com.ocp.webapp.storage;

import com.ocp.webapp.exception.StorageException;
import com.ocp.webapp.model.Resume;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;

class AbstractArrayStorageTest extends AbstractStorageTest {

    protected AbstractArrayStorageTest(Storage storage) {
        super(storage);
    }

    @Test
    public void getOverflow() {
        storage.clear();
        try {
            for (int i = 0; i < AbstractArrayStorage.STORAGE_LIMIT; i++) {
                storage.save(new Resume("Name " + i));
            }
        } catch (Exception e) {
            fail("Test failed!");
        }
        assertThrows(StorageException.class, () -> storage.save(new Resume("Last Hero")));
    }

}