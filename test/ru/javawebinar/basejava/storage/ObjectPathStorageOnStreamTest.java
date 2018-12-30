package ru.javawebinar.basejava.storage;


import ru.javawebinar.basejava.storage.serialization.IOStreamStrategyImpl;

public class ObjectPathStorageOnStreamTest extends AbstractStorageTest {

    public ObjectPathStorageOnStreamTest() {
        super(new PathStorage(STORAGE_DIR.getAbsolutePath(), new IOStreamStrategyImpl()));
    }
}