package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.exceptions.ExistStorageException;
import ru.javawebinar.basejava.exceptions.NotExistStorageException;
import ru.javawebinar.basejava.model.Resume;

import java.util.Comparator;
import java.util.List;


public abstract class AbstractStorage<SK> implements Storage {

    protected static final Comparator<Resume> RESUME_COMPARATOR = Comparator.comparing(Resume::getFullName).thenComparing(Resume::getUuid);

    @Override
    public void update(Resume resume) {
        SK searchKey = getExistedSearchKey(resume.getUuid());
        updateElement(searchKey, resume);
    }

    @Override
    public Resume get(String uuid) {
        SK searchKey = getExistedSearchKey(uuid);
        return getElement(searchKey);
    }

    @Override
    public void save(Resume resume) {
        SK searchKey = getNotExistedSearchKey(resume.getUuid());
        saveElement(resume, searchKey);
    }

    @Override
    public void delete(String uuid) {
        SK searchKey = getExistedSearchKey(uuid);
        removeElement(searchKey);
    }

    public List<Resume> getAllSorted() {
        List<Resume> resumeList = getAllFromStorage();
        resumeList.sort(RESUME_COMPARATOR);
        return resumeList;
    }

    private SK getExistedSearchKey(String uuid) {
        SK searchKey = getSearchKey(uuid);
        if (!isExist(searchKey)) {
            throw new NotExistStorageException(uuid);
        }
        return searchKey;
    }

    private SK getNotExistedSearchKey(String uuid) {
        SK searchKey = getSearchKey(uuid);
        if (isExist(searchKey)) {
            throw new ExistStorageException(uuid);
        }
        return searchKey;
    }

    protected abstract List<Resume> getAllFromStorage();

    protected abstract boolean isExist(SK searchedKey);

    protected abstract void saveElement(Resume resume, SK searchKey);

    protected abstract void updateElement(SK searchedKey, Resume resume);

    protected abstract void removeElement(SK uuid);

    protected abstract SK getSearchKey(String uuid);

    protected abstract Resume getElement(SK searchKey);

}
