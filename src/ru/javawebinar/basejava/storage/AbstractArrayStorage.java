package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.exceptions.StorageException;
import ru.javawebinar.basejava.model.Resume;

import java.util.Arrays;

public abstract class AbstractArrayStorage extends AbstractStorage {
    static final int STORAGE_LIMIT = 10000;
    int size = 0;

    protected Resume[] storage = new Resume[STORAGE_LIMIT];

    public void clear() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    protected boolean isExist(Object searchedKey) {
        return (int) searchedKey > -1;
    }

    protected Resume getFromStorage(Object searchKey) {
        return storage[(int) searchKey];
    }

    protected void updateElement(Object searchedKey, Resume resume) {
        storage[(int) searchedKey] = resume;
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    public Resume[] getAll() {
        return Arrays.copyOf(storage, size);
    }


    @Override
    protected void removeElement(Object searchKey) {
        removeElement((int) searchKey);
        storage[size - 1] = null;
        size--;
    }

    @Override
    protected void saveElement(Resume resume) {
        if (size >= AbstractArrayStorage.STORAGE_LIMIT) {
            throw new StorageException("Storage limit overflow", resume.getUuid());
        }
        saveElement(resume, (Integer) getSearchKey(resume.getUuid()));
        size++;
    }

    protected abstract void removeElement(int index);

    protected abstract void saveElement(Resume resume, int index);

}
