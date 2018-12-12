package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.model.Resume;

import java.util.ArrayList;
import java.util.List;

public class ListStorage extends AbstractStorage<Integer> {
    private List<Resume> storage = new ArrayList<>();


    @Override
    public void clear() {
        storage.clear();
    }

    protected boolean isExist(Integer searchedKey) {
        return searchedKey != null;
    }

    @Override
    protected void doUpdate(Integer searchKey, Resume resume) {
        storage.set( searchKey, resume);
    }

    @Override
    public int size() {
        return storage.size();
    }

    @Override
    protected void saveElement(Resume resume, Integer searchKey) {
        storage.add(resume);
    }

    @Override
    protected Resume doGet(Integer searchKey) {
        return storage.get(searchKey);
    }

    @Override
    protected void removeElement(Integer searchKey) {
        storage.remove(searchKey.intValue());
    }

    @Override
    public List<Resume> getAllFromStorage() {
        return storage;
    }

    @Override
    protected Integer getSearchKey(String uuid) {

        for (int i = 0; i < storage.size(); i++) {
            if (uuid.equals(storage.get(i).getUuid())) {
                return i;
            }
        }
        return null;
    }

}
