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
        return (int) searchedKey > -1;
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
    protected void saveElement(Resume resume) {
        storage.add(resume);
    }

    @Override
    protected Resume getFromStorage(Object searchKey) {
        return storage.get((Integer) searchKey);
    }

    @Override
    protected void removeElement(String uuid) {
        storage.remove(getIndex(uuid));
    }

    @Override
    public Resume[] getAll() {
        return storage.toArray(new Resume[size()]);
    }

    private int getIndex(String uuid) {
        return storage.indexOf(new Resume(uuid));
    }

    @Override
    protected Object getSearchKey(String uuid) {

        for (Resume r : storage) {
            if (uuid.equals(r.getUuid())) {
                return storage.indexOf(r);
            }
        }
        return null;
    }

}
