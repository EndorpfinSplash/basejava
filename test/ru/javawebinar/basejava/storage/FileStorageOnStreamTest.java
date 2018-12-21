package ru.javawebinar.basejava.storage;

public class FileStorageOnStreamTest extends AbstractStorageTest {

    public FileStorageOnStreamTest() {
        super(new FileStorage(STORAGE_DIR, new IOStreamStrategyImpl()) {
        });
    }
}