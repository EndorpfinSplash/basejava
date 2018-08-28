package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.exceptions.ExistStorageException;
import ru.javawebinar.basejava.exceptions.NotExistStorageException;
import ru.javawebinar.basejava.exceptions.StorageException;
import ru.javawebinar.basejava.model.Resume;

import java.util.Arrays;

public abstract class AbstractArrayStorage implements Storage {
    protected static final int STORAGE_LIMIT = 10000;

    protected Resume[] storage = new Resume[STORAGE_LIMIT];
    protected int size = 0;

    public Resume[] getStorage() {
        return storage;
    }

    public void clear() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
    }

    public void update(Resume resume) {
        int index = getIndex(resume.getUuid());
        if (index < 0) {
            throw new NotExistStorageException(resume.getUuid());
        }
        storage[index] = resume;
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    public Resume[] getAll() {
        return Arrays.copyOf(storage, size);
    }

    public int size() {
        return size;
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
}
