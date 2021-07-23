package com.ocp.webapp.storage;

import com.ocp.webapp.model.Resume;

public class ArrayStorage extends AbstractArrayStorage {

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



    public void delete(String uuid) {
        int index = getIndex(uuid);
        if (checkExist(index)) {
            storage[index] = storage[size - 1];
            storage[size - 1] = null;
            size--;
            System.out.println(uuid + " delete");
        }
    }

    protected int getIndex(String uuid) {
        for (int i = 0; i < size; i++) {
            if (storage[i].getUuid().equals(uuid)) {
                return i;
            }
        }
        return -1;
    }

}