package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.model.Resume;

import java.util.LinkedList;
import java.util.List;

public class ListStorage extends AbstractStorage
{
    private List<Resume> storage = new LinkedList<>();

    @Override
    public void clear() {
        storage.clear();

    }

    @Override
    public void update(Resume r) {
        storage.set(storage.indexOf(r), r);
    }

    @Override
    public void save(Resume r) {
        storage.add(r);
    }

    @Override
    public Resume get(String uuid) {
        return storage.get(storage.indexOf(new Resume(uuid)));
    }

    @Override
    public void delete(String uuid) {
        storage.remove(new Resume(uuid));
    }

    @Override
    public Resume[] getAll() {
        Resume[] resumes = new Resume[size];
        for (int i = 0; i < size; i++) {
            resumes[i] = storage.get(i);
        }
        return resumes;
    }

    @Override
    public int size() {
        return size;
    }
}
