package com.ocp.webapp.storage;

import com.ocp.webapp.exception.ExistStorageException;
import com.ocp.webapp.exception.NotExistStorageException;
import com.ocp.webapp.model.Resume;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.logging.Logger;

public abstract class AbstractStorage<SK> implements Storage {

    protected final static Comparator<Resume> FULL_NAME_UUID_COMPARATOR = Comparator.comparing(Resume::getFullName).thenComparing(Resume::getUuid);

    private static final Logger LOGGER = Logger.getLogger(AbstractStorage.class.getName());

    protected abstract SK getSearchKey(String uuid);

    protected abstract boolean isExist(SK searchKey);

    protected abstract void doSave(SK searchKey, Resume resume);

    protected abstract void doUpdate(SK searchKey, Resume resume);

    protected abstract void doDelete(SK searchKey);

    protected abstract Resume doGet(SK searchKey);

    protected abstract List<Resume> doCopyAll();

    @Override
    public void save(Resume resume) {
        LOGGER.info("Save: " + resume);
        SK searchKey = getNotExistStorageException(resume.getUuid());
        doSave(searchKey, resume);
    }

    @Override
    public void update(Resume resume) {
        LOGGER.info("Update: " + resume);
        SK searchKey = getExistStorageException(resume.getUuid());
        doUpdate(searchKey, resume);

    }

    @Override
    public Resume get(String uuid) {
        LOGGER.info("Get: " + uuid);
        SK searchKey = getExistStorageException(uuid);
        return doGet(searchKey);
    }

    @Override
    public void delete(String uuid) {
        LOGGER.info("Delete: " + uuid);
        SK searchKey = getExistStorageException(uuid);
        doDelete(searchKey);
    }

    @Override
    public List<Resume> getAllSorted() {
        LOGGER.info("GetAllSorted");
        List<Resume> list = doCopyAll();
        Collections.sort(list);
        return list;
    }

    private SK getExistStorageException(String uuid) {
        SK searchKey = getSearchKey(uuid);
        if (!isExist(searchKey)) {
            LOGGER.warning("Resume " + uuid + " not exist");
            throw new NotExistStorageException(uuid);
        }
        return searchKey;
    }

    private SK getNotExistStorageException(String uuid) {
        SK searchKey = getSearchKey(uuid);
        if (isExist(searchKey)) {
            LOGGER.warning("Resume " + uuid + " already exist");
            throw new ExistStorageException(uuid);
        }
        return searchKey;
    }

}
