package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.exceptions.StorageException;
import ru.javawebinar.basejava.model.Resume;

import java.util.Arrays;

public abstract class AbstractArrayStorage extends AbstractStorage {
    static final int STORAGE_LIMIT = 10000;
    int size = 0;

    protected Resume[] storage = new Resume[STORAGE_LIMIT];

    public void floodNull() {
        Arrays.fill(storage, 0, size, null);
        size =0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    protected boolean isExist(String uuid) {
        return getIndex(uuid) > -1;
    }

    @Override
    protected Resume getFromStorage(String uuid) {
        return storage[getIndex(uuid)];
    }

    @Override
    protected void updateExistedElement(String uuid, Resume resume) {
        storage[getIndex(uuid)] = resume;
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    public Resume[] getAll() {
        return Arrays.copyOf(storage, size);
    }


    @Override
    protected void removeElement(String uuid) {
        removeElement(getIndex(uuid));
        storage[size - 1] = null;
        size--;
    }

    @Override
    protected void saveElement(Resume resume) {
        if (size >= AbstractArrayStorage.STORAGE_LIMIT) {
            throw new StorageException("Storage limit overflow", resume.getUuid());
        }
        saveElement(resume, getIndex(resume.getUuid()));
        size++;
    }

    protected abstract void removeElement(int index);

    protected abstract void saveElement(Resume resume, int index);

    protected abstract int getIndex(String uuid);
}
