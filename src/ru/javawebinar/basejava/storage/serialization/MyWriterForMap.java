package ru.javawebinar.basejava.storage.serialization;

import java.io.IOException;
import java.util.Map;

@FunctionalInterface
public interface MyWriterForMap<K,V> {
    void write(Map.Entry<K,V> entry) throws IOException;
}
