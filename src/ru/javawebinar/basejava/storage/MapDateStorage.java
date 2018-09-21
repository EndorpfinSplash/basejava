package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.model.Resume;


public class MapDateStorage extends MapStorage {

    @Override
    protected void saveElement(Resume resume) {
        super.storageMap.put(System.currentTimeMillis(), resume);
    }

}
