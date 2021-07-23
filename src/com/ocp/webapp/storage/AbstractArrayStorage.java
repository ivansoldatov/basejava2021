package com.ocp.webapp.storage;

import com.ocp.webapp.model.Resume;

import java.util.Arrays;

public abstract class AbstractArrayStorage implements Storage {

    protected static final int STORAGE_LIMIT = 100000;
    protected Resume[] storage = new Resume[STORAGE_LIMIT];
    protected int size = 0;

    public void update(Resume resume) {
        int index = getIndex(resume.getUuid());
        if (checkExist(index)) {
            storage[index] = resume;
            System.out.println(resume + " updated");
        }
    }

    public int size() {
        return size;
    }

    public Resume get(String uuid) {
        int index = getIndex(uuid);
        if (checkExist(index)) {
            return storage[index];
        } else return null;
    }

    public void clear() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
        System.out.println("Storage clear");
    }

    public Resume[] getAll() {
        return Arrays.copyOfRange(storage, 0, size);
    }

    protected boolean checkExist(int index) {
        if (index >= 0) {
            return true;
        } else {
            System.out.println("Resume not exist");
            return false;
        }
    }

    protected boolean checkNotExist(int index) {
        if (index < 0) {
            return true;
        } else {
            System.out.println("Resume already exist");
            return false;
        }
    }

    protected abstract int getIndex(String uuid);

}