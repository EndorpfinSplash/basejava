package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.exceptions.ExistStorageException;
import ru.javawebinar.basejava.exceptions.NotExistStorageException;
import ru.javawebinar.basejava.model.Resume;

import java.util.Comparator;
import java.util.List;
import java.util.logging.Logger;


public abstract class AbstractStorage<SK> implements Storage {

    protected static final Comparator<Resume> RESUME_COMPARATOR = Comparator.comparing(Resume::getFullName).thenComparing(Resume::getUuid);

    private static final Logger LOG = Logger.getLogger(AbstractStorage.class.getName());

    protected abstract List<Resume> getAllFromStorage();

    protected abstract boolean isExist(SK searchedKey);

    protected abstract void saveElement(Resume resume, SK searchKey);

    protected abstract void doUpdate(SK searchedKey, Resume resume);

    protected abstract void removeElement(SK uuid);

    protected abstract SK getSearchKey(String uuid);

    protected abstract Resume doGet(SK searchKey);

    @Override
    public void update(Resume resume) {
        LOG.info("Update" + resume);
        SK searchKey = getExistedSearchKey(resume.getUuid());
        doUpdate(searchKey, resume);
    }

    @Override
    public Resume get(String uuid) {
        LOG.info("Get " + uuid);
        SK searchKey = getExistedSearchKey(uuid);
        return doGet(searchKey);
    }

    @Override
    public void save(Resume resume) {
        LOG.info("save " + resume);
        SK searchKey = getNotExistedSearchKey(resume.getUuid());
        saveElement(resume, searchKey);
    }

    @Override
    public void delete(String uuid) {
        LOG.info("delete " + uuid);
        SK searchKey = getExistedSearchKey(uuid);
        removeElement(searchKey);
    }

    public List<Resume> getAllSorted() {
        LOG.info("getAllSorted" );
        List<Resume> resumeList = getAllFromStorage();
        resumeList.sort(RESUME_COMPARATOR);
        return resumeList;
    }

    private SK getExistedSearchKey(String uuid) {

        SK searchKey = getSearchKey(uuid);
        if (!isExist(searchKey)) {
            LOG.warning("Resume " + uuid + " non exist");
            throw new NotExistStorageException(uuid);
        }
        return searchKey;
    }

    private SK getNotExistedSearchKey(String uuid) {
        SK searchKey = getSearchKey(uuid);
        if (isExist(searchKey)) {
            LOG.warning("Resume " + uuid + " already exist");
            throw new ExistStorageException(uuid);
        }
        return searchKey;
    }

}
