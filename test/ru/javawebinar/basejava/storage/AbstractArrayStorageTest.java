package ru.javawebinar.basejava.storage;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import ru.javawebinar.basejava.exceptions.ExistStorageException;
import ru.javawebinar.basejava.exceptions.NotExistStorageException;
import ru.javawebinar.basejava.exceptions.StorageException;
import ru.javawebinar.basejava.model.Resume;

public abstract class AbstractArrayStorageTest {

    protected Storage storage;

    protected AbstractArrayStorageTest(Storage storage) {
        this.storage = storage;
    }

    private static final String UUID_1 = "uuid1";
    private static final String UUID_2 = "uuid2";
    private static final String UUID_3 = "uuid3";
    private static final Resume[] TEST_RESUMES_ARRAY = new Resume[]{new Resume(UUID_1), new Resume(UUID_2), new Resume(UUID_3)};

    @Before
    public void setUp() throws Exception {
        storage.clear();
        storage.save(new Resume(UUID_1));
        storage.save(new Resume(UUID_2));
        storage.save(new Resume(UUID_3));
    }

    @Test
    public void clear() {
        storage.clear();
        Assert.assertEquals(0, storage.size());
    }

    @Test
    public void update() {
        Resume resume = new Resume(UUID_2);
        storage.update(resume);
        Assert.assertEquals(resume, storage.getStorage()[1]);
    }

    @Test(expected = NotExistStorageException.class)
    public void updateNotExisted() {
        Resume resume = new Resume("Toast");
        storage.update(resume);
    }

    @Test
    public void getAll() {
        Resume[] resume = this.storage.getAll();
        Assert.assertEquals(resume, TEST_RESUMES_ARRAY);
    }

    @Test
    public void size() {
        Assert.assertEquals(3, storage.size());
    }

    @Test
    public void get() {
        Resume resume = storage.get(UUID_1);
        Assert.assertEquals(resume, this.storage.getStorage()[0]);
    }

    @Test(expected = NotExistStorageException.class)
    public void getNotExist() {
        storage.get("Toast");
    }

    @Test(expected = NotExistStorageException.class)
    public void delete() {
        storage.delete(UUID_3);
        storage.get(UUID_3);
    }

    @Test(expected = NotExistStorageException.class)
    public void deleteNonExisted() {
        storage.delete("Toast");
    }

    @Test
    public void save() {
        final String testResumeUuid = "uuid4";
        Resume testResume = new Resume(testResumeUuid);
        storage.save(testResume);
        Assert.assertEquals(testResume, storage.get(testResumeUuid));
    }

    @Test(expected = StorageException.class)
    public void saveOverLimit() {
        for (int i = 3; i <= storage.size(); i++) {
            storage.save(new Resume(Integer.toString(i)));
        }
        storage.save(new Resume());
    }

    @Test(expected = ExistStorageException.class)
    public void saveExisted() {
        storage.save(new Resume(UUID_3));
    }

}