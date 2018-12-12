package ru.javawebinar.basejava.storage;

import org.junit.Assert;
import org.junit.Test;
import ru.javawebinar.basejava.exceptions.StorageException;
import ru.javawebinar.basejava.model.Resume;

import java.io.File;

public abstract class AbstractArrayStorageTest extends AbstractStorageTest {

    protected static final File STORAGE_DIR = new File(".\\storage");

    protected AbstractArrayStorageTest(Storage storage) {
        super(storage);
    }

    @Test(expected = StorageException.class)
    public void saveOverLimit() {
        try {
            for (int i = 3; i < AbstractArrayStorage.STORAGE_LIMIT; i++) {
                this.storage.save(new Resume(Integer.toString(i)));
            }
        } catch (StorageException e) {
            Assert.fail();
        }
        storage.save(new Resume("overlimitUUID"));
    }
}