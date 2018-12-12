package ru.javawebinar.basejava.storage;

import static ru.javawebinar.basejava.storage.AbstractArrayStorageTest.STORAGE_DIR;

public class ObjectStreamStorageTest extends AbstractStorageTest {

    public ObjectStreamStorageTest() {
        super(new ObjectStreamStorage(STORAGE_DIR));
    }
}