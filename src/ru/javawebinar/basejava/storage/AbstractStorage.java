package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.exceptions.ExistStorageException;
import ru.javawebinar.basejava.exceptions.NotExistStorageException;
import ru.javawebinar.basejava.model.Resume;

public abstract class AbstractStorage implements Storage {

    @Override
    public void clear() {
        floodNull();
    }

    protected abstract void floodNull();


    @Override
    public void update(Resume resume) {
        if (isExist(resume.getUuid())) {
            updateExistedElement(resume.getUuid(), resume);
        } else {
            throw new NotExistStorageException(resume.getUuid());
        }

    }


    @Override
    public Resume get(String uuid) {
        if (!isExist(uuid)) {
            throw new NotExistStorageException(uuid);
        }
        return getFromStorage(uuid);
    }

    protected abstract Resume getFromStorage(String uuid);


    public void save(Resume resume) {
        if (isExist(resume.getUuid())) {
            throw new ExistStorageException(resume.getUuid());
        }
        saveElement(resume);
    }


    @Override
    public void delete(String uuid) {

        if (!isExist(uuid)) {
            throw new NotExistStorageException(uuid);

        } else {
            removeElement(uuid);
        }
    }

    protected abstract void saveElement(Resume resume);

    protected abstract boolean isExist(String uuid);

    protected abstract void updateExistedElement(String uuid, Resume resume);

    protected abstract void removeElement(String uuid);
}
