package com.ocp.webapp.storage;

import com.ocp.webapp.exception.StorageException;
import com.ocp.webapp.model.Resume;
import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public abstract class AbstractFileStorage extends AbstractStorage<File> {

    private final File directory;

    protected AbstractFileStorage(@NotNull File directory) {
        Objects.requireNonNull(directory, "Directory must be not null");
        if (!directory.isDirectory()) {
            throw new IllegalArgumentException(directory.getAbsolutePath() + " is not directory");
        }
        if (!directory.canRead() || !directory.canWrite()) {
            throw new IllegalArgumentException(directory.getAbsolutePath() + " is not readable/writable");
        }
        this.directory = directory;
    }

    protected abstract void doWrite(File file, Resume resume);

    protected abstract Resume doRead(File file);

    @Override
    protected File getSearchKey(String uuid) {
        return new File(directory, uuid);
    }

    @Override
    protected boolean isExist(File file) {
        return file.exists();
    }

    @Override
    protected void doSave(File file, Resume resume) {
        try {
            file.createNewFile();
            doWrite(file, resume);
        } catch (IOException e) {
            throw new StorageException("IO error", file.getName());
        }
    }


    @Override
    protected void doUpdate(File file, Resume resume) {
        doDelete(file);
        doSave(file, resume);
    }

    @Override
    protected void doDelete(File file) {
        if (!file.delete()) {
            throw new StorageException("file delete error", file.getName());
        }

    }

    @Override
    protected Resume doGet(File file) {
        return doRead(file);
    }


    @Override
    protected List<Resume> doCopyAll() {
        List<Resume> list = new ArrayList<>();
        for (File f : directory.listFiles()) {
            list.add(doGet(f));
        }
        return list;
    }

    @Override
    public void clear() {
        File[] files = directory.listFiles();
        if (files == null) {
            throw new StorageException("Directory error", directory.getName());
        } else {
            for (File f : files) {
                doDelete(f);
            }
        }

    }

    @Override
    public int size() {
        return directory.list().length;
    }
}
