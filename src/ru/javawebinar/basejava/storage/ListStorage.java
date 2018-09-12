package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.model.Resume;

import java.util.LinkedList;
import java.util.List;

public class ListStorage extends AbstractStorage
{
    private List<Resume> storage = new LinkedList<>();


    @Override
    protected void floodNull() {
        storage.clear();
    }

    @Override
    protected boolean isExist(Resume resume) {
        return storage.contains(resume);
    }

    @Override
    protected void updateExistedElement(Resume resume) {
        storage.set(storage.indexOf(resume), resume);
    }

    @Override
    public void save(Resume r) {
        storage.add(r);
    }

    @Override
    protected void saveElement(Resume resume) {
        storage.add(resume);
    }

    @Override
    protected int getStorageLength() {
        return storage.size();
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

}
