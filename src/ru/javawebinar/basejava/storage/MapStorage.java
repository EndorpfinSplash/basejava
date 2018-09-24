package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.model.Resume;

public class MapStorage extends MapUuidStorage {
    @Override
    protected boolean isExist(Object resume) {
        String searchKey = ((Resume) resume).getUuid();
        return super.isExist(searchKey);
    }

    @Override
    protected void updateElement(Object oldResume, Resume newResume) {
        String searchKey = ((Resume) oldResume).getUuid();
        super.updateElement(searchKey, newResume);
    }

    @Override
    protected void saveElement(Resume resume, Object newResume) {
        super.saveElement(resume, ((Resume) newResume).getUuid());
    }

    @Override
    protected Resume getElement(Object resume) {
        return super.getElement(((Resume) resume).getUuid());
    }

    @Override
    protected void removeElement(Object resume) {
        super.removeElement(((Resume) resume).getUuid());
    }

}
