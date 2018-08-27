package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.model.Resume;

import java.util.Arrays;

public class SortedArrayStorage extends AbstractArrayStorage {

    @Override
    public void saveElement(Resume resume, int index) {
        int indexForSave = index * (-1) - 1;

        for (int i = size; i > indexForSave; i--) {
            storage[i] = storage[i - 1];
        }
        storage[indexForSave] = resume;
    }

    @Override
    protected void removeElement(int index) {
        for (int i = index; i < size - 1; i++) {
            storage[i] = storage[i + 1];
        }
    }

    @Override
    protected int getIndex(String uuid) {
        Resume searchKey = new Resume();
        searchKey.setUuid(uuid);
        return Arrays.binarySearch(storage, 0, size, searchKey);
    }
}
