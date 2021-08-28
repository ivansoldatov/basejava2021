package com.ocp.webapp.storage;

import com.ocp.webapp.model.Resume;

import java.util.*;

public class MapUuidStorage extends AbstractStorage<String> {

    Map<String, Resume> storage = new HashMap<>();

    @Override
    protected String getSearchKey(String uuid) {
        return uuid;
    }

    @Override
    protected boolean isExist(String uuid) {
        return storage.containsKey(uuid);
    }

    @Override
    protected void doSave(String uuid, Resume r) {
        storage.put(uuid, r);
    }

    @Override
    protected void doUpdate(String uuid, Resume r) {
        doSave(uuid, r);

    }

    @Override
    protected void doDelete(String uuid) {
        storage.remove(uuid);

    }

    @Override
    protected Resume doGet(String uuid) {
        return storage.get(uuid);
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
