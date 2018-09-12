package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.exceptions.ExistStorageException;
import ru.javawebinar.basejava.exceptions.NotExistStorageException;
import ru.javawebinar.basejava.exceptions.StorageException;
import ru.javawebinar.basejava.model.Resume;

import java.util.Arrays;

public abstract class AbstractArrayStorage extends AbstractStorage {

    protected Resume[] storage = new Resume[STORAGE_LIMIT];

    public void floodNull() {
        Arrays.fill(storage, 0, size, null);
    }

    @Override
    protected boolean isExist(Resume resume) {
        return getIndex(resume.getUuid()) > -1;
    }

    @Override
    protected void updateExistedElement(Resume resume) {
        storage[getIndex(resume.getUuid())] = resume;
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    public Resume[] getAll() {
        return Arrays.copyOf(storage, size);
    }


    public Resume get(String uuid) {
        int index = getIndex(uuid);
        if (index < 0) {
            throw new NotExistStorageException(uuid);
        }
        return storage[index];
    }

    public void delete(String uuid) {
        int index = getIndex(uuid);

        if (index < 0) {
            throw new NotExistStorageException(uuid);

        } else {
            removeElement(index);
            storage[size - 1] = null;
            size--;
        }
    }

    protected abstract void removeElement(int index);


    public void save(Resume resume) {
        int index = getIndex(resume.getUuid());
        if (index > -1) {
            throw new ExistStorageException(resume.getUuid());
        }

        if (size >= storage.length) {
            throw new StorageException("Storage limit overflow", resume.getUuid());
        }

        saveElement(resume, index);
        size++;
    }

    protected abstract void saveElement(Resume resume, int index);

    protected abstract int getIndex(String uuid);

    @Override
    protected int getStorageLength() {
        return storage.length;
    }

    @Override
    protected void saveElement(Resume resume) {
        saveElement(resume,  getIndex(resume.getUuid()));
    }
}
