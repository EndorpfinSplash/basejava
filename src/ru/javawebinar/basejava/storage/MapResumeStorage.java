package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.model.Resume;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapResumeStorage extends AbstractStorage<Resume> {

    protected Map<String, Resume> storageMap = new HashMap<>();

    @Override
    protected List<Resume> getAllFromStorage() {
        return new ArrayList<>(storageMap.values());
    }

    @Override
    protected boolean isExist(Resume resume) {
        return resume != null;
    }

    @Override
    protected void doUpdate(Resume oldResume, Resume newResume) {
        storageMap.put(oldResume.getUuid(), newResume);
    }

    @Override
    protected void saveElement(Resume r, Resume resume) {
            storageMap.put(r.getUuid(), r);
    }

    @Override
    protected Resume doGet(Resume resume) {
        return storageMap.get(resume.getUuid());
    }

    @Override
    protected void removeElement(Resume resume) {
        storageMap.remove(resume.getUuid());
    }

    @Override
    protected Resume getSearchKey(String uuid) {
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
