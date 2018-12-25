package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.model.Resume;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapUuidStorage extends AbstractStorage<String> {

    protected Map<String, Resume> storageMap = new HashMap<>();

    @Override
    protected boolean isExist(String searchKey) {
        return storageMap.containsKey(searchKey);
    }

    @Override
    protected void doUpdate(String searchKey, Resume resume) {
        storageMap.put( searchKey, resume);
    }

    @Override
    protected void doSave(Resume resume, String searchKey) {
        storageMap.put(searchKey, resume);
    }

    @Override
    protected Resume doGet(String searchKey) {
        return storageMap.get(searchKey);
    }

    @Override
    protected void doDelete(String searchKey) {
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

    protected String getSearchKey(String searchKey) {
        return searchKey;
    }

}
