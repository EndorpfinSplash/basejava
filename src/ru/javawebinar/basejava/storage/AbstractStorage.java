package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.exceptions.NotExistStorageException;
import ru.javawebinar.basejava.model.Resume;

public abstract class AbstractStorage implements Storage {
    static final int STORAGE_LIMIT = 10000;
    int size = 0;

    @Override
    public void clear() {
        floodNull();
        size = 0;
    }

    protected abstract void floodNull();

    @Override
    public void update(Resume resume){
        if (isExist(resume)) {
            updateExistedElement(resume);
        } else {
            throw new NotExistStorageException(resume.getUuid());
        }

    }

    protected abstract boolean isExist(Resume resume);

    protected abstract void updateExistedElement(Resume resume);

    @Override
    public int size() {
        return size;
    }

}
