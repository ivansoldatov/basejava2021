package com.ocp.webapp.storage;

import com.ocp.webapp.exception.ExistStorageException;
import com.ocp.webapp.exception.NotExistStorageException;
import com.ocp.webapp.exception.StorageException;
import com.ocp.webapp.model.Resume;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class AbstractArrayStorageTest {

    private Storage storage;

    public AbstractArrayStorageTest(Storage storage) {
        this.storage = storage;
    }

    private static final String UUID_1 = "uuid1";
    private static final String UUID_2 = "uuid2";
    private static final String UUID_3 = "uuid3";
    private static final String UUID_4 = "uuid4";

    private static final Resume RESUME_1 = new Resume(UUID_1);
    private static final Resume RESUME_2 = new Resume(UUID_2);
    private static final Resume RESUME_3 = new Resume(UUID_3);
    private static final Resume RESUME_4 = new Resume(UUID_4);

    @BeforeEach
    void setUp() {
        storage.clear();
        storage.save(RESUME_1);
        storage.save(RESUME_3);
        storage.save(RESUME_2);
    }

    @Test
    void clear() {
        storage.clear();
        assertSize(0);
    }

    @Test
    void save() {
        storage.save(RESUME_4);
        assertSize(4);
        assertGet(RESUME_4);
    }

    @Test
    void delete() {
        storage.delete(UUID_2);
        assertSize(2);
        assertThrows(NotExistStorageException.class, () -> storage.get(UUID_2));
    }

    @Test
    void update() {
        Resume newResume = new Resume(UUID_1);
        storage.update(newResume);
        assertEquals(newResume, storage.get(UUID_1));
    }

    @Test
    void size() {
        assertSize(3);
    }

    @Test
    void get() {
        assertGet(RESUME_1);
        assertGet(RESUME_2);
        assertGet(RESUME_3);
    }

    @Test
    void getAll() {
        Resume[] expectedResume = new Resume[]{RESUME_1, RESUME_2, RESUME_3};
        Resume[] actualResume = storage.getAll();
        Arrays.sort(actualResume);
        assertSize(3);
        assertArrayEquals(expectedResume, actualResume);
    }

    @Test
    public void saveExist() {
        assertThrows(ExistStorageException.class, () -> storage.save(RESUME_1));
    }

    @Test
    public void deleteNotExist() {
        assertThrows(NotExistStorageException.class, () -> storage.delete("dummy"));
    }

    @Test
    public void updateNotExist() {
        assertThrows(NotExistStorageException.class, () -> storage.update(RESUME_4));
    }

    @Test
    public void getNotExist() {
        assertThrows(NotExistStorageException.class, () -> storage.get("dummy"));
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

    private void assertGet(Resume resume) {
        assertEquals(resume, storage.get(resume.getUuid()));
    }

    private void assertSize(int size) {
        assertEquals(size, storage.size());
    }
}