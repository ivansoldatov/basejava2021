package com.ocp.webapp.storage;

import com.ocp.webapp.exception.StorageException;
import com.ocp.webapp.model.Resume;
import org.jetbrains.annotations.NotNull;

import java.io.*;

public class ObjectStreamStorage extends AbstractFileStorage {

    public ObjectStreamStorage(@NotNull File directory) {
        super(directory);
    }

    @Override
    protected void doWrite(OutputStream os, Resume resume) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(os)) {
            oos.writeObject(resume);
        }
    }

    @Override
    protected Resume doRead(InputStream is) throws IOException {
        try (ObjectInputStream ois = new ObjectInputStream(is)) {
            return (Resume) ois.readObject();
        } catch (ClassNotFoundException e) {
            throw new StorageException("Error read resume", null, e);
        }

    }
}
