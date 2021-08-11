package com.ocp.webapp.storage;

import com.ocp.webapp.model.Resume;

import java.util.ArrayList;
import java.util.List;

public class ListStorage extends AbstractStorage {

    List<Resume> storage = new ArrayList<>();

    @Override
    public void clear() {
        storage.clear();
    }

    @Override
    public Resume[] getAll() {
        return storage.toArray(Resume[]::new);
    }

    @Override
    public int size() {
        return storage.size();
    }

    @Override
    protected int getIndex(String uuid) {
        Resume newResume = new Resume(uuid);
//        return storage.indexOf(newResume);

        for (Resume r : storage) {
            if (newResume.equals(r)) {
                return storage.indexOf(r);
            }
        }
        return -1;
    }

    @Override
    protected void doSave(int index, Resume resume) {
        storage.add(resume);
    }

    @Override
    protected void doUpdate(int index, Resume resume) {
        storage.set(index, resume);
    }

    @Override
    protected void doDelete(int index) {
        storage.remove(index);
    }

    @Override
    protected Resume doGet(int index) {
        return storage.get(index);
    }
}
