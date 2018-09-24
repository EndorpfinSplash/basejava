package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.model.Resume;

import java.util.Arrays;
import java.util.Comparator;

public class SortedArrayStorage extends AbstractArrayStorage {

    private static final Comparator<Resume> RESUME_COMPARATOR = Comparator.comparing(Resume::getUuid);

    @Override
    public void saveElementIntoArray(Resume resume, int index) {
        int indexForSave = index * (-1) - 1;
        System.arraycopy(storage, indexForSave, storage, indexForSave + 1, size - indexForSave);
        storage[indexForSave] = resume;
    }

    @Override
    protected void removeElement(int index) {
        int numMoved = size - index - 1;
        if (numMoved > 0) {
            System.arraycopy(storage, index + 1, storage, index, numMoved);
        }
    }

    @Override
    protected Integer getSearchKey(String uuid) {
        return Arrays.binarySearch(storage, 0, size, new Resume(uuid), RESUME_COMPARATOR);
    }
}
