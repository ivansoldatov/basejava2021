package com.ocp.webapp.storage;

import com.ocp.webapp.exception.ExistStorageException;
import com.ocp.webapp.exception.NotExistStorageException;
import com.ocp.webapp.model.Resume;

public abstract class AbstractStorage implements Storage {

    @Override
    public void save(Resume resume) {
        int index = getIndex(resume.getUuid());
        if (index >= 0) {
            throw new ExistStorageException(resume.getUuid());
        } else {
            doSave(index, resume);
        }
    }

    @Override
    public void update(Resume resume) {
        int index = getIndex(resume.getUuid());
        if (index < 0) {
            throw new NotExistStorageException(resume.getUuid());
        } else {
            doUpdate(index, resume);
        }
    }

    @Override
    public Resume get(String uuid) {
        int index = getIndex(uuid);
        if (index < 0) {
            throw new NotExistStorageException(uuid);
        }
        return doGet(index);
    }

    @Override
    public void delete(String uuid) {
        int index = getIndex(uuid);
        if (index < 0) {
            throw new NotExistStorageException(uuid);
        } else {
            doDelete(index);
        }
    }

    protected abstract int getIndex(String uuid);

    protected abstract void doSave(int index, Resume resume);

    protected abstract void doUpdate(int index, Resume resume);

    protected abstract void doDelete(int index);

    protected abstract Resume doGet(int index);


}
