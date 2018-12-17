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

public class PathStorage extends AbstractStorage<Path> {
    private Path directory;
    private SavingStrategy strategy;

    protected PathStorage(File dir, SavingStrategy strategy) {
        this.strategy = strategy;
        directory = dir.toPath();
        Objects.requireNonNull(directory, "directory must not be null");
        if (!Files.isDirectory(directory) || !Files.isWritable(directory)) {
            throw new IllegalArgumentException(dir + " is not directory");
        }
    }

    @Override
    protected List<Resume> getAllFromStorage() {
        List<Resume> resumeList = new ArrayList<>();
        Path[] files = new Path[0];
        try {
            files = (Path[]) Files.list(directory).toArray();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (files != null) {
            for (Path file : files) {
                try {
                    resumeList.add(strategy.doRead(new BufferedInputStream(new FileInputStream(file.toFile()))));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return resumeList;
    }

    @Override
    protected boolean isExist(Path file) {
        return file.toFile().exists();
    }

    @Override
    protected void saveElement(Resume resume, Path file) {
        try {
            file.toFile().createNewFile();
        } catch (IOException e) {
            throw new StorageException("IO error", file.toString(), e);
        }
        doUpdate(file, resume);
    }

    @Override
    protected void doUpdate(Path file, Resume resume) {
        try {
            strategy.doWrite(resume, new BufferedOutputStream(new FileOutputStream(file.toFile())));
        } catch (IOException e) {
            throw new StorageException("IO error before updating", file.getFileName().toString(), e);
        }
    }

    @Override
    protected void removeElement(Path file) {
        if (!file.toFile().delete()) {
            throw new StorageException("Path delete error", file.toString());
        }
    }

    @Override
    protected Path getSearchKey(String file) {
        return Paths.get(file);
    }


    @Override
    protected Resume doGet(Path file) {
        try {
            return strategy.doRead(new BufferedInputStream(new FileInputStream(file.toFile())));
        } catch (IOException e) {
            throw new StorageException("Path read error", file.toString(), e);
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
        return directory.getNameCount();
    }
}
