package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.exceptions.ExistStorageException;
import ru.javawebinar.basejava.exceptions.NotExistStorageException;
import ru.javawebinar.basejava.model.Resume;

public abstract class AbstractStorage implements Storage {

    @Override
    abstract public void clear();

    @Override
    public void update(Resume resume) {

        Object searchKey = getSearchKey(resume.getUuid());

        if (isExist(searchKey)) {
            updateElement(searchKey, resume);
        } else {
            throw new NotExistStorageException(resume.getUuid());
        }
    }


    @Override
    public Resume get(String uuid) {
        if (!isExist(uuid)) {
            throw new NotExistStorageException(uuid);
        }
        return getFromStorage(getSearchKey(uuid));
    }

    protected abstract Object getSearchKey(String uuid);

    protected abstract Resume getFromStorage(Object searchKey);


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

    protected abstract boolean isExist(Object searchedKey);

    protected abstract void saveElement(Resume resume);

    protected abstract void updateElement(Object searchedKey, Resume resume);

    protected abstract void removeElement(String uuid);
}
