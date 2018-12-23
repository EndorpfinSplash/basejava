package ru.javawebinar.basejava.storage;


import ru.javawebinar.basejava.storage.serialization.IOStreamStrategyImpl;

import java.io.IOException;

public class PathStorageOnStreamTest extends AbstractStorageTest {

    public PathStorageOnStreamTest() throws IOException {
        super(new PathStorage(STORAGE_DIR.getAbsolutePath(), new IOStreamStrategyImpl()));
    }
}