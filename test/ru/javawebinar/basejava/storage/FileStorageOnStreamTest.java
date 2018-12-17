package ru.javawebinar.basejava.storage;

public class FileStorageOnStreamTest extends AbstractStorageTest {

    public FileStorageOnStreamTest() {
        super(new AbstractFileStorage2(STORAGE_DIR, new IOStreamStrategyImpl()) {
        });
    }
}