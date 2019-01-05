package ru.javawebinar.basejava.storage.serialization;

import java.io.IOException;

@FunctionalInterface
public interface MyWriter {
    void write() throws IOException;
}
