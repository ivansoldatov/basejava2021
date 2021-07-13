package com.ocp.webapp.storage;

import com.ocp.webapp.model.Resume;

import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage implements Storage {

    private static final int STORAGE_LIMIT = 10000;
    private Resume[] storage = new Resume[STORAGE_LIMIT];
    private int size = 0;

    public void clear() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
        System.out.println("Storage clear");
    }

    public void save(Resume resume) {
        int index = getIndex(resume.getUuid());
        if (size >= STORAGE_LIMIT) {
            System.out.println("Storage overflow");
        } else if (checkNotExist(index)) {
            storage[size] = resume;
            size++;
            System.out.println(resume.getUuid() + " save");
        }
    }

    public void update(Resume resume) {
        int index = getIndex(resume.getUuid());
        if (checkExist(index)) {
            storage[index] = resume;
            System.out.println(resume + " updated");
        }
    }

    public Resume get(String uuid) {
        int index = getIndex(uuid);
        if (checkExist(index)) {
            return storage[index];
        } else return null;
    }

    public void delete(String uuid) {
        int index = getIndex(uuid);
        if (checkExist(index)) {
            System.arraycopy(storage, index + 1, storage, index, size - 1 - index);
            storage[size - 1] = null;
            size--;
            System.out.println(uuid + " delete");
        }
    }

    public Resume[] getAll() {
        return Arrays.copyOfRange(storage, 0, size);
    }

    public int size() {
        return size;
    }

    private int getIndex(String uuid) {
        for (int i = 0; i < size; i++) {
            if (storage[i].getUuid().equals(uuid)) {
                return i;
            }
        }
        return -1;
    }

    private boolean checkExist(int index) {
        if (index >= 0) {
            return true;
        } else {
            System.out.println("Resume already exist");
            return false;
        }
    }

    private boolean checkNotExist(int index) {
        if (index < 0) {
            return true;
        } else {
            System.out.println("Resume not exist");
            return false;
        }
    }

}
