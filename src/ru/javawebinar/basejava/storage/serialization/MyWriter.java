package ru.javawebinar.basejava.storage.serialization;

import java.io.IOException;

@FunctionalInterface
public interface MyWriter<E> {
    void write(E e) throws IOException;
}
