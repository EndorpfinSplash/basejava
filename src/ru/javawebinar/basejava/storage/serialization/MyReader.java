package ru.javawebinar.basejava.storage.serialization;

import java.io.IOException;

@FunctionalInterface
public interface MyReader <E> {
    E read() throws IOException;
}
