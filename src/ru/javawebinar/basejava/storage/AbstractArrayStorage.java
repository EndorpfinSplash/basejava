package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.exceptions.StorageException;
import ru.javawebinar.basejava.model.Resume;

import java.util.Arrays;
import java.util.List;


public abstract class AbstractArrayStorage extends AbstractStorage<Integer> {
    public static final int STORAGE_LIMIT = 10000;
    protected int size = 0;

    protected Resume[] storage = new Resume[STORAGE_LIMIT];

    @Override
    public void clear() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    protected boolean isExist(Integer searchedKey) {
        return searchedKey > -1;
    }

    @Override
    protected Resume doGet(Integer searchKey) {
        return storage[searchKey];
    }

    @Override
    protected void doUpdate(Integer searchedKey, Resume resume) {
        storage[searchedKey] = resume;
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */

    @Override
    public List<Resume> getAllFromStorage() {
        return Arrays.asList(Arrays.copyOf(storage, size));
    }

    @Override
    protected void doDelete(Integer searchKey) {
        removeElement(searchKey.intValue());
        storage[size - 1] = null;
        size--;
    }

    @Override
    protected void doSave(Resume resume, Integer searchKey) {
        if (size >= AbstractArrayStorage.STORAGE_LIMIT) {
            throw new StorageException("Storage limit overflow", resume.getUuid());
        }
        saveElementIntoArray(resume, searchKey);
        size++;
    }

    protected abstract void removeElement(int index);

    protected abstract void saveElementIntoArray(Resume resume, int index);

}
