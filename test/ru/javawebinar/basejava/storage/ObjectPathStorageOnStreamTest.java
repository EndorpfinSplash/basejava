package ru.javawebinar.basejava.storage;


import ru.javawebinar.basejava.storage.serialization.IOStreamStrategyImpl;

import java.io.IOException;

public class ObjectPathStorageOnStreamTest extends AbstractStorageTest {

    public ObjectPathStorageOnStreamTest() throws IOException {
        super(new PathStorage(STORAGE_DIR.getAbsolutePath(), new IOStreamStrategyImpl()));
    }
}