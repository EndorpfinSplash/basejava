package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.storage.serialization.IOStreamStrategyImpl;

public class ObjectFileStorageOnStreamTest extends AbstractStorageTest {

    public ObjectFileStorageOnStreamTest() {
        super(new FileStorage(STORAGE_DIR, new IOStreamStrategyImpl()));
    }
}