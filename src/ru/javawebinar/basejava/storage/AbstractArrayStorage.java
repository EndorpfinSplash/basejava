package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.model.Resume;

import java.util.Arrays;

public abstract class AbstractArrayStorage implements Storage {
    protected static final int STORAGE_LIMIT = 10000;

    protected Resume[] storage = new Resume[STORAGE_LIMIT];
    protected int size = 0;

    public void clear() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
    }

    public void update(Resume resume) {
        int position = getIndex(resume.getUuid());
        if (position == -1) {
            System.out.println("Resume " + resume.getUuid() + " already exist");
            return;
        }
        storage[position] = resume;
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
        if (index == -1) {
            System.out.println("Resume " + uuid + " not exist");
            return null;
        }
        return storage[index];
    }

    protected abstract int getIndex(String uuid);

    public void delete(String uuid) {
        int position = getIndex(uuid);

        if (position == -1) {
            System.out.println("Resume " + uuid + " not exist");
        } else {
            removeElement(position);
            size--;
        }
    }

    protected abstract void removeElement(int position);


    public void save(Resume resume) {
        if (getIndex(resume.getUuid()) > -1) {
            System.out.println("Resume already exist");
            return;
        }

        if (size >= storage.length) {
            System.out.println("Storage of resume is full");
            return;
        }

        saveElement(resume);
    }

    protected abstract void saveElement(Resume resume);
}
