package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.exceptions.StorageException;
import ru.javawebinar.basejava.model.Resume;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public abstract class AbstractPathStorage extends AbstractStorage<Path> {
    private Path directory;

    protected AbstractPathStorage(String dir) {
        directory = Paths.get(dir);
        Objects.requireNonNull(directory, "directory must not be null");
        if (!Files.isDirectory(directory) || !Files.isWritable(directory)) {
            throw new IllegalArgumentException(dir + " is not directory");
        }
    }

    @Override
    protected List<Resume> getAllFromStorage() {
        List<Resume> resumeList = new ArrayList<>();
        Path[] files = directory.listPaths();
        if (files != null) {
            for (Path file : files) {
                try {
                    resumeList.add(doRead(new BufferedInputStream(new PathInputStream(file))));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return resumeList;
    }

    @Override
    protected boolean isExist(Path file) {
        return file.exists();
    }

    @Override
    protected void saveElement(Resume resume, Path file) {
        try {
            file.createNewPath();
        } catch (IOException e) {
            throw new StorageException("IO error", file.getName(), e);
        }
        doUpdate(file, resume);
    }

    protected abstract void doWrite(Resume resume, OutputStream os) throws IOException;

    @Override
    protected void doUpdate(Path file, Resume resume) {
        try {
            doWrite(resume, new BufferedOutputStream(new PathOutputStream(file)));
        } catch (IOException e) {
            throw new StorageException("IO error before updating", file.getName(), e);
        }
    }

    @Override
    protected void removeElement(Path file) {
        if (!file.delete()) {
            throw new StorageException("Path delete error", file.getName());
        }
    }

    @Override
    protected Path getSearchKey(String file) {
        return new Path(directory, file);
    }

    protected abstract Resume doRead(InputStream is) throws IOException;

    @Override
    protected Resume doGet(Path file) {
        try {
            return doRead(new BufferedInputStream(new PathInputStream(file)));
        } catch (IOException e) {
            throw new StorageException("Path read error", file.getName(), e);
        }
    }

    @Override
    public void clear() {
        try {
            Files.list(directory).forEach(this::removeElement);
        } catch (IOException e) {
            throw new StorageException("Path delete error", null);
        }
    }

    @Override
    public int size() {
        return Objects.requireNonNull(directory.listPaths()).length;
    }
}
