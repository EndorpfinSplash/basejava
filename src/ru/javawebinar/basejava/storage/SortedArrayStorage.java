package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.model.Resume;

import java.util.Arrays;

public class SortedArrayStorage extends AbstractArrayStorage {

    @Override
    public void saveElement(Resume resume, int index) {
        int indexForSave = index * (-1) - 1;
        System.arraycopy(storage,indexForSave,storage,indexForSave+1,size-indexForSave);
        storage[indexForSave] = resume;
    }

    @Override
    protected void removeElement(int index) {
        System.arraycopy(storage,index+1,storage,index,size-index-1);
    }

    @Override
    protected int getIndex(String uuid) {
        Resume searchKey = new Resume();
        searchKey.setUuid(uuid);
        return Arrays.binarySearch(storage, 0, size, searchKey);
    }
}
