package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.model.Resume;

import java.util.Arrays;

public class SortedArrayStorage extends AbstractArrayStorage {

    @Override
    public void saveElement(Resume resume) {
        int indexForSave = 0;

        String uuid = resume.getUuid();
        for (int i = 0; i < size; i++) {
            if (uuid.compareTo(storage[i].getUuid()) < 0) {
                indexForSave = i;
                break;
            } else {
                storage[size++] = resume;
                return;
            }
        }

        size++;
        for (int i = size; i > indexForSave; i--) {
            storage[i] = storage[i - 1];
        }
        storage[indexForSave] = resume;
    }

    @Override
    protected void removeElement(int position) {
        for (int i = position; i < size - 1; i++) {
            storage[i] = storage[i + 1];
        }
        storage[size - 1] = null;
    }

    @Override
    protected int getIndex(String uuid) {
        Resume searchKey = new Resume();
        searchKey.setUuid(uuid);
        return Arrays.binarySearch(storage, 0, size, searchKey);
    }
}
