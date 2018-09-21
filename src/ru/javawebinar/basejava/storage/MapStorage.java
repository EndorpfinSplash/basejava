package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.model.Resume;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapStorage extends AbstractStorage {

    protected Map<String, Resume> storageMap = new HashMap<>();

    @Override
    protected boolean isExist(Object searchKey) {
        searchKey = checkSearchKeyType(searchKey);
        return storageMap.containsKey(searchKey);
    }

    @Override
    protected void updateElement(Object searchKey, Resume resume) {
        searchKey = checkSearchKeyType(searchKey);
        storageMap.put((String) searchKey, resume);
    }

    @Override
    protected void saveElement(Resume resume) {
        storageMap.put(resume.getUuid(), resume);
    }


    @Override
    protected Resume getFromStorage(Object searchKey) {
        searchKey = checkSearchKeyType(searchKey);
        return storageMap.get(searchKey);
    }


    @Override
    protected void removeElement(Object searchKey) {
        searchKey = checkSearchKeyType(searchKey);
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
        for (Map.Entry<String, Resume> r : storageMap.entrySet()) {
            resumeList.add(r.getValue());
        }
        resumeList.sort(Resume::compareTo);
        return resumeList;
    }

    @Override
    public void clear() {
        storageMap.clear();
    }


    protected Object getSearchKey(String searchKey) {
        return searchKey;
    }


    private Object checkSearchKeyType(Object searchKey) {
        if (searchKey instanceof Resume) {
            return ((Resume) searchKey).getUuid();
        }
        return searchKey;
    }
}
