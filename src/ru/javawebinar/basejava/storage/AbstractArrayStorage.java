package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.exceptions.StorageException;
import ru.javawebinar.basejava.model.Resume;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public abstract class AbstractArrayStorage extends AbstractStorage {
    static final int STORAGE_LIMIT = 10000;
    int size = 0;

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
    protected boolean isExist(Object searchedKey) {
        return (int) searchedKey > -1;
    }

    @Override
    protected Resume getFromStorage(Object searchKey) {
        return storage[(int) searchKey];
    }

    @Override
    protected void updateElement(Object searchedKey, Resume resume) {
        storage[(int) searchedKey] = resume;
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
/*
    public Resume[] getAll() {
        return Arrays.copyOf(storage, size);
    }
*/
    @Override
    public List<Resume> getAllSorted() {
        List<Resume> resumeList = new ArrayList<>(Arrays.asList(Arrays.copyOf(storage, size)));
        resumeList.sort(Resume::compareTo);
        return resumeList;
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
