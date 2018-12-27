package ru.javawebinar.basejava.storage.serialization;

import ru.javawebinar.basejava.model.Resume;
import ru.javawebinar.basejava.util.GsonParser;

import java.io.*;
import java.nio.charset.StandardCharsets;


public class GsonStreamSerializerImpl implements SerializationStrategy {


    @Override
    public void doWrite(Resume resume, OutputStream os) throws IOException {
        try (Writer w = new OutputStreamWriter(os, StandardCharsets.UTF_8)) {
            GsonParser.write(resume, w);
        }
    }

    @Override
    public  Resume doRead(InputStream is) throws IOException {
        try (Reader r = new InputStreamReader(is, StandardCharsets.UTF_8)) {
            return GsonParser.read(r, Resume.class);
        }
    }
}
