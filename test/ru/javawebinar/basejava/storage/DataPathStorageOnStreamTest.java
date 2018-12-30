package ru.javawebinar.basejava.storage;


import ru.javawebinar.basejava.storage.serialization.DataStreamStrategyImpl;

public class DataPathStorageOnStreamTest extends AbstractStorageTest {

    public DataPathStorageOnStreamTest()  {
        super(new PathStorage(STORAGE_DIR.getAbsolutePath(), new DataStreamStrategyImpl()));
    }
}