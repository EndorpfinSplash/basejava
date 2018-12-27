package ru.javawebinar.basejava.storage;


import ru.javawebinar.basejava.storage.serialization.XmlStreamSerializerImpl;

import java.io.IOException;

public class ObjectXmlStorageOnStreamTest extends AbstractStorageTest {

    public ObjectXmlStorageOnStreamTest() throws IOException {
        super(new PathStorage(STORAGE_DIR.getAbsolutePath(), new XmlStreamSerializerImpl()));
    }
}