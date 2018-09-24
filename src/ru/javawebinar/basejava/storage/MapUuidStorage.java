package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.model.Resume;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapUuidStorage extends AbstractStorage {

    protected Map<String, Resume> storageMap = new HashMap<>();

    @Override
    protected boolean isExist(Object searchKey) {
        return storageMap.containsKey(searchKey);
    }

    @Override
    protected void updateElement(Object searchKey, Resume resume) {
        storageMap.put((String) searchKey, resume);
    }

    @Override
    protected void saveElement(Resume resume, Object searchKey) {
        storageMap.put((String) searchKey, resume);
    }


    @Override
    protected Resume getElement(Object searchKey) {
        return storageMap.get(searchKey);
    }


    @Override
    protected void removeElement(Object searchKey) {
        storageMap.remove(searchKey);
    }

    @Override
    public int size() {
        return storageMap.size();
    }

    @Override
    public List<Resume> getAllFromStorage() {

        return new ArrayList<>(storageMap.values());
    }

    @Override
    public void clear() {
        storageMap.clear();
    }


    protected Object getSearchKey(String searchKey) {
        return searchKey;
    }

}
