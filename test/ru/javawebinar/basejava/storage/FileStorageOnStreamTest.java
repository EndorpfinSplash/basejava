package ru.javawebinar.basejava.storage;

import ru.javawebinar.basejava.storage.serialization.IOStreamStrategyImpl;

public class FileStorageOnStreamTest extends AbstractStorageTest {

    public FileStorageOnStreamTest() {
        super(new FileStorage(STORAGE_DIR, new IOStreamStrategyImpl()));
    }
}