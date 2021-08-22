package com.ocp.webapp.storage;

import com.ocp.webapp.model.Resume;

import java.util.*;

public class MapUuidStorage extends AbstractStorage {

    Map<String, Resume> storage = new HashMap<>();

    @Override
    protected Object getSearchKey(String uuid) {
        return uuid;
    }

    @Override
    protected boolean isExist(Object searchKey) {
        return storage.containsKey((String) searchKey);
    }

    @Override
    protected void doSave(Object searchKey, Resume resume) {
        storage.put(resume.getUuid(), resume);
    }

    @Override
    protected void doUpdate(Object searchKey, Resume resume) {
        doSave(resume.getUuid(), resume);

    }

    @Override
    protected void doDelete(Object searchKey) {
        storage.remove((String) searchKey);

    }

    @Override
    protected Resume doGet(Object searchKey) {
        return storage.get((String) searchKey);
    }

    @Override
    public void clear() {
        storage.clear();
    }

    @Override
    public List<Resume> getAllSorted() {
        List<Resume> listResume = new ArrayList<>(storage.values());
        listResume.sort(FULL_NAME_UUID_COMPARATOR);
        return listResume;
    }

    @Override
    public int size() {
        return storage.size();
    }


}
