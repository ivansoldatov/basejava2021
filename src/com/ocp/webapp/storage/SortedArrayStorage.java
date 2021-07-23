package com.ocp.webapp.storage;

import com.ocp.webapp.model.Resume;

import java.util.Arrays;

public class SortedArrayStorage extends AbstractArrayStorage {


    @Override
    public void save(Resume resume) {
        int index = getIndex(resume.getUuid());
        if (size >= STORAGE_LIMIT) {
            System.out.println("Storage overflow");
        } else if (checkNotExist(index)) {
            index = -index - 1;
            System.arraycopy(storage, index, storage, index + 1, size - index);
            storage[index] = resume;
            size++;
            System.out.println(resume.getUuid() + " save");
        }
    }


    @Override
    public void delete(String uuid) {
        int index = getIndex(uuid);
        if (checkExist(index)) {
            System.arraycopy(storage, index + 1, storage, index, size - 1 - index);
            storage[size - 1] = null;
            size--;
            System.out.println(uuid + " delete");
        }
    }


    @Override
    protected int getIndex(String uuid) {
        Resume searchKey = new Resume();
        searchKey.setUuid(uuid);
        return Arrays.binarySearch(storage, 0, size, searchKey);
    }
}
