package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.model.Resume;

import java.util.HashMap;
import java.util.Map;

public class MapStorage extends AbstractStorage {

    private Map<String, Resume> storageMap = new HashMap<>();

    @Override
    protected boolean isExist(Object searchKey) {
        return storageMap.containsKey(searchKey);
    }

    @Override
    protected void updateElement(Object searchKey, Resume resume) {
        storageMap.put((String) searchKey, resume);
    }

    @Override
    protected void saveElement(Resume resume) {
        storageMap.put(resume.getUuid(), resume);
    }


    @Override
    protected Resume getFromStorage(Object uuid) {
        return storageMap.get(uuid);
    }


    @Override
    protected void removeElement(Object uuid) {
        storageMap.remove(uuid);
    }

    @Override
    public int size() {
        return storageMap.size();
    }

    @Override
    public Resume[] getAll() {
        return storageMap.values().toArray(new Resume[size()]);
    }

    @Override
    public void clear() {
        storageMap.clear();
    }

    @Override
    protected Object getSearchKey(String uuid) {
        return uuid;
    }
}
