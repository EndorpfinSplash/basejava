package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.model.Resume;

import java.util.HashMap;
import java.util.Map;

public class MapStorage extends AbstractStorage {

    private Map<String, Resume> storageMap = new HashMap<>();

    @Override
    protected boolean isExist(Resume resume) {
        return storageMap.containsValue(resume);
    }

    @Override
    protected void updateExistedElement(Resume resume) {
        storageMap.put(resume.getUuid(), resume);
    }

    @Override
    public void save(Resume r) {

    }

    @Override
    protected void saveElement(Resume resume) {
        storageMap.put(resume.getUuid(), resume);
    }

    @Override
    protected int getStorageLength() {
        return storageMap.size();
    }

    @Override
    public Resume get(String uuid) {
        return null;
    }

    @Override
    public void delete(String uuid) {

    }

    @Override
    protected void removeElement(String uuid) {
        storageMap.remove(uuid);
    }

    @Override
    public Resume[] getAll() {
        return storageMap.values().toArray(new Resume[size]);
    }

    @Override
    protected void floodNull() {
        storageMap.clear();
    }
}
