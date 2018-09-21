package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.model.Resume;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapStorage extends AbstractStorage {

    protected Map<Object, Resume> storageMap = new HashMap<>();

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
    protected Resume getFromStorage(Object searchKey) {
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

/*    @Override
    public Resume[] getAll() {
        return storageMap.values().toArray(new Resume[size()]);
    }*/

    @Override
    public List<Resume> getAllSorted() {
        List<Resume> resumeList = new ArrayList<>();
        for (Map.Entry<Object,Resume> r : storageMap.entrySet()) {
            resumeList.add(r.getValue());
        }
        resumeList.sort(Resume::compareTo);
        return resumeList;
    }

    @Override
    public void clear() {
        storageMap.clear();
    }

    @Override
    protected String getSearchKey(String uuid) {
        return uuid;
    }

}
