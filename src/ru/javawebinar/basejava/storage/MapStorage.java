package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.model.Resume;

import java.util.HashMap;
import java.util.Map;

public class MapStorage extends AbstractStorage {

    private Map<String, Resume> storageMap = new HashMap<>();

    @Override
    protected boolean isExist(String uuid) {
        return storageMap.containsKey(uuid);
    }

    @Override
    protected void updateExistedElement(String uuid, Resume resume) {
        storageMap.put(uuid, resume);
    }

    @Override
    protected void saveElement(Resume resume) {
        storageMap.put(resume.getUuid(), resume);
    }


    @Override
    protected Resume getFromStorage(String uuid) {
        return storageMap.get(uuid);
    }


    @Override
    protected void removeElement(String uuid) {
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
    protected void floodNull() {
        storageMap.clear();
    }
}
