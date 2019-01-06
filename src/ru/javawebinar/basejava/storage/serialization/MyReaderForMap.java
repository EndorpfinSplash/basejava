package ru.javawebinar.basejava.storage.serialization;

import java.io.IOException;

@FunctionalInterface
public interface MyReaderForMap {
   void read() throws IOException;
}
