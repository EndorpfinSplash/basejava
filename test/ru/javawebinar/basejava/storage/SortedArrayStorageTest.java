package ru.javawebinar.basejava.storage;

import org.junit.Assert;
import org.junit.Test;
import ru.javawebinar.basejava.model.Resume;

public class SortedArrayStorageTest extends AbstractArrayStorageTest {

    public SortedArrayStorageTest() {
        super(new SortedArrayStorage());
    }

    @Test
    public void saveDisordered() {
        Resume resume4 = new Resume("uuid4");
        Resume resume5 = new Resume("uuid5");
        storage.save(resume5);
        storage.save(resume4);
        Assert.assertEquals(resume4, storage.getStorage()[3]);
    }
}