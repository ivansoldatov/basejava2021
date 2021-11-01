package com.ocp.webapp.storage;

import com.ocp.webapp.exception.StorageException;
import com.ocp.webapp.model.Resume;
import org.jetbrains.annotations.NotNull;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

public abstract class AbstractPathStorage extends AbstractStorage<Path> {

    private final Path directory;

    protected AbstractPathStorage(@NotNull String dir) {
        directory = Paths.get(dir);
        Objects.requireNonNull(directory, "directory must not be null");
        if (!Files.isDirectory(directory) || !Files.isWritable(directory)) {
            throw new IllegalArgumentException(dir + "is not directory or is not writable");
        }
    }

    protected abstract void doWrite(OutputStream os, Resume resume) throws IOException;

    protected abstract Resume doRead(InputStream is) throws IOException;

    @Override
    protected Path getSearchKey(String uuid) {
        return Path.of(directory.toString(), uuid);
    }

    @Override
    protected boolean isExist(Path path) {
        return Files.exists(path);
    }

    @Override
    protected void doSave(Path path, Resume resume) {
        try {
            Files.createFile(path);
        } catch (IOException e) {
            throw new StorageException("Couldn't create Path " + path.getParent(), path.getFileName().toString(), e);
        }
        doUpdate(path, resume);
    }


    @Override
    protected void doUpdate(Path path, Resume resume) {
        try {
            doWrite(new BufferedOutputStream(Files.newOutputStream(path)), resume);
        } catch (IOException e) {
            throw new StorageException("Path write error", resume.getUuid(), e);
        }

    }

    @Override
    protected void doDelete(Path path) {
        try {
            Files.delete(path);
        } catch (IOException e) {
            throw new StorageException("File delete error", path.getFileName().toString());
        }

    }

    @Override
    protected Resume doGet(Path path) {
        try {
            return doRead(new BufferedInputStream(Files.newInputStream(path)));
        } catch (IOException e) {
            throw new StorageException("Path read error", path.getFileName().toString(), e);
        }
    }

    @Override
    protected List<Resume> doCopyAll() {
        List<Resume> list = new ArrayList<>();
        try {
            Files.list(directory).forEach(r -> list.add(doGet(r)));
        } catch (IOException e) {
            throw new StorageException("Dirrectory read error", null);
        }
        return list;
    }

    @Override
    public void clear() {
        try {
            Files.list(directory).forEach(this::doDelete);
        } catch (IOException e) {
            throw new StorageException("Dirrectory read error", null);
        }
    }

    @Override
    public int size() {
        try {
            return (int) Files.list(directory).count();
        } catch (IOException e) {
            throw new StorageException("Dirrectory read error", null);
        }
    }
}
