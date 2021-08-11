package com.ocp.webapp.storage;

import com.ocp.webapp.exception.StorageException;
import com.ocp.webapp.model.Resume;

import java.util.Arrays;

public abstract class AbstractArrayStorage extends AbstractStorage {

    protected static final int STORAGE_LIMIT = 10000;

    protected Resume[] storage = new Resume[STORAGE_LIMIT];
    protected int size = 0;

    public void clear() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
    }

    public int size() {
        return size;
    }

    public Resume[] getAll() {
        return Arrays.copyOfRange(storage, 0, size);
    }

    @Override
    protected void doSave(int index, Resume resume) {
        if (size >= STORAGE_LIMIT) {
            throw new StorageException("Storage overflow", resume.getUuid());
        } else {
            insertElement(resume, index);
            size++;
        }
    }

    @Override
    protected Resume doGet(int index) {
        return storage[index];
    }

    @Override
    protected void doUpdate(int index, Resume resume) {
        storage[index] = resume;
    }

    @Override
    protected void doDelete(int index) {
        fillDeletedElement(index);
        storage[size - 1] = null;
        size--;
    }

    protected abstract int getIndex(String uuid);

    protected abstract void insertElement(Resume resume, int index);

    protected abstract void fillDeletedElement(int index);

}