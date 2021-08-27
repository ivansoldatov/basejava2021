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
    protected boolean isExist(Object uuid) {
        return storage.containsKey((String) uuid);
    }

    @Override
    protected void doSave(Object uuid, Resume r) {
        storage.put((String) uuid, r);
    }

    @Override
    protected void doUpdate(Object uuid, Resume r) {
        doSave(uuid, r);

    }

    @Override
    protected void doDelete(Object uuid) {
        storage.remove((String) uuid);

    }

    @Override
    protected Resume doGet(Object uuid) {
        return storage.get((String) uuid);
    }

    @Override
    public void clear() {
        storage.clear();
    }

    @Override
    public List<Resume> doCopyAll() {
        return new ArrayList<>(storage.values());
    }

    @Override
    public int size() {
        return storage.size();
    }

}
