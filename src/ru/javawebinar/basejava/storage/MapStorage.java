package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.model.Resume;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapStorage extends AbstractStorage {

    protected Map<String, Resume> storageMap = new HashMap<>();

    @Override
    protected List<Resume> getAllFromStorage() {
        return new ArrayList<>(storageMap.values());
    }

    @Override
    protected boolean isExist(Object resume) {
        return resume != null;
    }

    @Override
    protected void updateElement(Object oldResume, Resume newResume) {
        storageMap.put(((Resume) oldResume).getUuid(), newResume);
    }

    @Override
    protected void saveElement(Resume r, Object resume) {
            storageMap.put(r.getUuid(), r);
    }

    @Override
    protected Resume getElement(Object resume) {
        return storageMap.get(((Resume) resume).getUuid());
    }

    @Override
    protected void removeElement(Object resume) {
        storageMap.remove(((Resume) resume).getUuid());
    }

    @Override
    protected Object getSearchKey(String uuid) {
        return storageMap.get(uuid);
    }

    @Override
    public void clear() {
        storageMap.clear();
    }

    @Override
    public int size() {
        return storageMap.size();
    }
}
