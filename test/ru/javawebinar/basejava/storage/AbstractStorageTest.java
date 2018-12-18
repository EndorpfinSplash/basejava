package ru.javawebinar.basejava.storage;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import ru.javawebinar.basejava.ResumeTestData;
import ru.javawebinar.basejava.exceptions.ExistStorageException;
import ru.javawebinar.basejava.exceptions.NotExistStorageException;
import ru.javawebinar.basejava.model.Resume;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertEquals;

public abstract class AbstractStorageTest {

//    protected static final File STORAGE_DIR = new File(".\\storage");
    protected static final File STORAGE_DIR = new File("C:\\Users\\andrey.zinovich\\IdeaProjects\\basejava\\storage\\");

    protected Storage storage;

    private static final String UUID_1 = "uuid1";

    private static final Resume RESUME_1 = new Resume(UUID_1, "B");
    private static final String UUID_2 = "uuid2";
    private static final Resume RESUME_2 = new Resume(UUID_2, "A");
    private static final String UUID_3 = "uuid3";
    private static final Resume RESUME_3 = ResumeTestData.createResume();
            //new Resume(UUID_3, "C");

    protected AbstractStorageTest(Storage storage) {
        this.storage = storage;
    }

    @Before
    public void setUp() throws Exception {
        storage.clear();
        storage.save(RESUME_1);
        storage.save(RESUME_2);
        storage.save(RESUME_3);
    }

    @Test
    public void clear() {
        storage.clear();
        assertEquals(0, storage.size());
    }

    @Test
    public void update() {
        RESUME_2.setFullName("Amigo");
        storage.update(RESUME_2);
        Assert.assertTrue(RESUME_2.equals( storage.get(UUID_2)));
    }

    @Test(expected = NotExistStorageException.class)
    public void updateNotExisted() {
        Resume resume = new Resume("Toast");
        storage.update(resume);
    }

    @Test
    public void getAllSorted() {
        final List<Resume> test_resume_list = new ArrayList<>(Arrays.asList(RESUME_2, RESUME_3,RESUME_1));
        List<Resume> resumeList = storage.getAllSorted();
        Assert.assertThat(resumeList, is(test_resume_list));
    }

    @Test
    public void size() {
        assertEquals(3, storage.size());
    }

    @Test
    public void get() {
        assertEquals(RESUME_1, storage.get(UUID_1));
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
        storage.save(RESUME_3);
    }
}