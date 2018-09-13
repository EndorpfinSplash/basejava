package ru.javawebinar.basejava.storage;

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
    protected Resume getFromStorage(String uuid) {
        return storage[getIndex(uuid)];
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


    @Override
    protected void removeElement(String uuid) {
        removeElement(getIndex(uuid));
        storage[size - 1] = null;
    }

    protected abstract void removeElement(int index);


    protected abstract void saveElement(Resume resume, int index);

    protected abstract int getIndex(String uuid);


    @Override
    protected void saveElement(Resume resume) {
        saveElement(resume, getIndex(resume.getUuid()));
    }
}
