package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.model.Resume;

import java.util.LinkedList;
import java.util.List;

public class ListStorage extends AbstractStorage {
    private List<Resume> storage = new LinkedList<>();


    @Override
    public void clear() {
        storage.clear();
    }

    protected boolean isExist(Object searchedKey) {
        return searchedKey != null;
    }

    @Override
    protected void updateElement(Object searchKey, Resume resume) {
        storage.set((Integer) searchKey, resume);
    }

    @Override
    public int size() {
        return storage.size();
    }

    @Override
    protected void saveElement(Resume resume, Object searchKey) {
        storage.add(resume);
    }

    @Override
    protected Resume getElement(Object searchKey) {
        return storage.get((int) searchKey);
    }

    @Override
    protected void removeElement(Object searchKey) {
        storage.remove((int) searchKey);
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
