package ru.javawebinar.basejava.storage;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import ru.javawebinar.basejava.ResumeTestData;
import ru.javawebinar.basejava.exceptions.ExistStorageException;
import ru.javawebinar.basejava.exceptions.NotExistStorageException;
import ru.javawebinar.basejava.model.Resume;

import java.io.File;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public abstract class AbstractStorageTest {

    protected static final File STORAGE_DIR = new File(".\\storage");
    protected Storage storage;

    private static final String UUID_1 = "uuid1";
    private static final Resume R1 = ResumeTestData.createResume(UUID_1, "A");
    private static final String UUID_2 = "uuid2";
    private static final Resume R2 = ResumeTestData.createResume(UUID_2, "B");
    private static final String UUID_3 = "uuid3";
    private static final Resume R3 = ResumeTestData.createResume(UUID_3, "Григорий Кислин");
    //new Resume(UUID_3, "C");

    protected AbstractStorageTest(Storage storage) {
        this.storage = storage;
    }

    @Before
    public void setUp() throws Exception {
        storage.clear();
        storage.save(R1);
        storage.save(R2);
        storage.save(R3);
    }

    @Test
    public void clear() {
        storage.clear();
        assertEquals(0, storage.size());
    }

    @Test
    public void update() {
        R2.setFullName("Amigo");
        storage.update(R2);
        Assert.assertEquals(R2, storage.get(UUID_2));
    }

    @Test(expected = NotExistStorageException.class)
    public void updateNotExisted() {
        Resume resume = new Resume("Toast");
        storage.update(resume);
    }

    @Test
    public void getAllSorted() {
        List<Resume> resumeList = storage.getAllSorted();
        assertEquals(3, resumeList.size());
        assertEquals(Arrays.asList(R1, R2, R3), resumeList);
    }

    @Test
    public void size() {
        assertEquals(3, storage.size());
    }

    @Test
    public void get() {
        assertEquals(R1, storage.get(UUID_1));
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
        Resume testResume = new Resume("TestResume");
        storage.save(testResume);
        assertEquals(testResume, storage.get(testResume.getUuid()));
        assertEquals(4, storage.size());
    }

    @Test(expected = ExistStorageException.class)
    public void saveExisted() {
        storage.save(R3);
    }
}