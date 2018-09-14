package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.model.Resume;

import java.util.LinkedList;
import java.util.List;

public class ListStorage extends AbstractStorage {
    private List<Resume> storage = new LinkedList<>();


    @Override
    protected void floodNull() {
        storage.clear();
    }

    @Override
    protected boolean isExist(String uuid) {
        return storage.contains(new Resume(uuid));
    }

    @Override
    protected void updateExistedElement(String uuid, Resume resume) {
        storage.set(storage.indexOf(resume), resume);
    }

    @Override
    public int size() {
        return storage.size();
    }

    @Override
    protected void saveElement(Resume resume) {
        storage.add(resume);
    }

    @Override
    protected Resume getFromStorage(String uuid) {
        return storage.get(getIndex(uuid));
    }

    @Override
    protected void removeElement(String uuid) {
        storage.remove(getIndex(uuid));
    }

    @Override
    public Resume[] getAll() {
        Resume[] resumes = new Resume[size()];
        for (int i = 0; i < storage.size(); i++) {
            resumes[i] = storage.get(i);
        }
        return resumes;
    }

    private int getIndex(String uuid){
        return storage.indexOf(new Resume(uuid));
    }

}
