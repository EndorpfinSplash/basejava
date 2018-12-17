package ru.javawebinar.basejava.storage;


public class PathStorageOnStreamTest extends AbstractStorageTest {

    public PathStorageOnStreamTest() {
        super(new PathStorage(STORAGE_DIR, new IOStreamStrategyImpl()) {
        });
    }
}