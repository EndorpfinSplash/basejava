package ru.javawebinar.basejava.storage.serialization;

import java.io.IOException;

@FunctionalInterface
public interface MyWriter<T> {
    void write(T t) throws IOException;
}
