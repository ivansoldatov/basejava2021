package com.ocp.webapp.storage;

import com.ocp.webapp.Config;
import com.ocp.webapp.ResumeTestData;
import com.ocp.webapp.exception.ExistStorageException;
import com.ocp.webapp.exception.NotExistStorageException;
import com.ocp.webapp.model.Resume;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;

import static org.junit.jupiter.api.Assertions.*;

class AbstractStorageTest {

//        protected static final File STORAGE_DIR = new File("./storage");
    protected static final File STORAGE_DIR = Config.get().getStorageDir();

    protected Storage storage;

    protected AbstractStorageTest(Storage storage) {
        this.storage = storage;
    }

    private static final Logger LOGGER = Logger.getLogger(AbstractStorage.class.getName());

    private static final String UUID_1 = "uuid1";
    private static final String UUID_2 = "uuid2";
    private static final String UUID_3 = "uuid3";
    private static final String UUID_4 = "uuid4";
    private static final String FULL_NAME_1 = "Alex";
    private static final String FULL_NAME_2 = "Bill";
    private static final String FULL_NAME_3 = "Alex";
    private static final String FULL_NAME_4 = "Tom";

//    private static final Resume RESUME_1 = new Resume(UUID_1, FULL_NAME_1);
//    private static final Resume RESUME_2 = new Resume(UUID_2, FULL_NAME_2);
//    private static final Resume RESUME_3 = new Resume(UUID_3, FULL_NAME_3);
//    private static final Resume RESUME_4 = new Resume(UUID_4, FULL_NAME_4);

    private static final Resume RESUME_1 = ResumeTestData.getResumeContacts(UUID_1, FULL_NAME_1);
    //    private static final Resume RESUME_2 = ResumeTestData.getResumeContacts(UUID_2, FULL_NAME_2);
    private static final Resume RESUME_2 = ResumeTestData.getResumeFull(UUID_2, FULL_NAME_2);
    private static final Resume RESUME_3 = new Resume(UUID_3, FULL_NAME_3);
    private static final Resume RESUME_4 = new Resume(UUID_4, FULL_NAME_4);

    @BeforeEach
    void setUp() {
        LOGGER.info("--------TEST: Before each setup start--------");
        storage.clear();
        storage.save(RESUME_1);
        storage.save(RESUME_2);
        storage.save(RESUME_3);
        LOGGER.info("--------TEST: Before each setup end--------");
    }

    @Test
    void clear() {
        LOGGER.info("********TEST: Clear start********");
        storage.clear();
        assertSize(0);
        LOGGER.info("********TEST: Clear end********");
    }

    @Test
    void save() {
        LOGGER.info("********TEST: Save start********");
        storage.save(RESUME_4);
        assertSize(4);
        assertGet(RESUME_4);
        LOGGER.info("********TEST: Save end********");
    }

    @Test
    void delete() {
        LOGGER.info("********TEST: Delete start********");
        storage.delete(UUID_2);
        assertSize(2);
        assertThrows(NotExistStorageException.class, () -> storage.get(UUID_2));
        LOGGER.info("********TEST: Delete end********");
    }

    @Test
    void update() {
        LOGGER.info("********TEST: Update start********");
        Resume newResume = new Resume(UUID_1, "new Resume");
        storage.update(newResume);
        assertEquals(newResume, storage.get(UUID_1));
        LOGGER.info("********TEST: Update end********");
    }

    @Test
    void size() {
        LOGGER.info("********TEST: Size start********");
        assertSize(3);
        LOGGER.info("********TEST: Size end********");
    }

    @Test
    void get() {
        LOGGER.info("********TEST: Get start********");
        assertGet(RESUME_1);
        assertGet(RESUME_2);
        assertGet(RESUME_3);
        LOGGER.info("********TEST: Get end********");
    }

    @Test
    void getAllSorted() {
        LOGGER.info("********TEST: Get all sorted start********");
        List<Resume> expectedList = Arrays.asList(RESUME_1, RESUME_3, RESUME_2);
        List<Resume> actualList = storage.getAllSorted();
        assertEquals(3, actualList.size());
        assertIterableEquals(expectedList, actualList);
        LOGGER.info("********TEST: Get all sorted end********");
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

    private void assertGet(Resume resume) {
        assertEquals(resume, storage.get(resume.getUuid()));
    }

    private void assertSize(int size) {
        assertEquals(size, storage.size());
    }
}