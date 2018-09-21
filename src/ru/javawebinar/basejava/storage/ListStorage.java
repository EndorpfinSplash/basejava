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
        return searchedKey != null && (int) searchedKey > -1;
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
        return storage.get((int) searchKey);
    }

    @Override
    protected void removeElement(Object searchKey) {
        storage.remove((int) searchKey);
    }

/*    @Override
    public Resume[] getAll() {
        return storage.toArray(new Resume[size()]);
    }*/

    @Override
    public List<Resume> getAllSorted() {
        storage.sort(Resume::compareTo);
        return storage;
    }

    @Override
    protected Object getSearchKey(String uuid) {

        for (int i = 0; i < storage.size(); i++) {
            if (uuid.equals(storage.get(i).getUuid())) {
                return i;
            }
        }
        return null;
    }

}
