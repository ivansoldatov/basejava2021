package com.ocp.webapp.storage;

import com.ocp.webapp.exception.StorageException;
import com.ocp.webapp.model.Resume;

import java.util.Arrays;
import java.util.List;

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

    public List<Resume> getAllSorted() {
        Resume[] resumes = Arrays.copyOfRange(storage, 0, size);
        List<Resume> listResume = Arrays.asList(resumes);
        listResume.sort(FULL_NAME_UUID_COMPARATOR);
        return listResume;
    }

    @Override
    protected void doSave(Object searchKey, Resume resume) {
        if (size >= STORAGE_LIMIT) {
            throw new StorageException("Storage overflow", resume.getUuid());
        } else {
            insertElement(resume, (Integer) searchKey);
            size++;
        }
    }

    @Override
    protected Resume doGet(Object searchKey) {
        return storage[(int) searchKey];
    }

    @Override
    protected void doUpdate(Object searchKey, Resume resume) {
        storage[(int) searchKey] = resume;
    }

    @Override
    protected void doDelete(Object searchKey) {
        fillDeletedElement((int) searchKey);
        storage[size - 1] = null;
        size--;
    }

    @Override
    protected Object getSearchKey(String uuid) {
        return getIndex(uuid);
    }

    @Override
    protected boolean isExist(Object searchKey) {
        return ((Integer) searchKey >= 0);
    }

    protected abstract void insertElement(Resume resume, int index);

    protected abstract int getIndex(String uuid);

    protected abstract void fillDeletedElement(int index);

}