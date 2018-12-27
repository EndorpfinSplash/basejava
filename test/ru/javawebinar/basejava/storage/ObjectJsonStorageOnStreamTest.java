package ru.javawebinar.basejava.storage;


import ru.javawebinar.basejava.storage.serialization.GsonStreamSerializerImpl;

import java.io.IOException;

public class ObjectJsonStorageOnStreamTest extends AbstractStorageTest {

    public ObjectJsonStorageOnStreamTest() throws IOException {
        super(new PathStorage(STORAGE_DIR.getAbsolutePath(), new GsonStreamSerializerImpl()));
    }
}