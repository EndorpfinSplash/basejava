package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.exceptions.ExistStorageException;
import ru.javawebinar.basejava.exceptions.NotExistStorageException;
import ru.javawebinar.basejava.exceptions.StorageException;
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


    @Override
    public Resume get(String uuid) {
        if (!isExist(new Resume(uuid))) {
            throw new NotExistStorageException(uuid);
        }
        return getFromStorage(uuid);
    }

    protected abstract Resume getFromStorage(String uuid);


    public void save(Resume resume) {
        if (isExist(resume)) {
            throw new ExistStorageException(resume.getUuid());
        }

        if (size >= getStorageLength()) {
            throw new StorageException("Storage limit overflow", resume.getUuid());
        }

        saveElement(resume);
        size++;
    }

    protected abstract void saveElement(Resume resume);

    protected abstract int getStorageLength();


    @Override
    public void delete(String uuid) {

        if (!isExist(new Resume(uuid))) {
            throw new NotExistStorageException(uuid);

        } else {
            removeElement(uuid);
            size--;
        }
    }

    protected abstract void removeElement(String uuid);
}
