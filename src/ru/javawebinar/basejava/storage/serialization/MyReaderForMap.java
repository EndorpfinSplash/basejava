package ru.javawebinar.basejava.storage.serialization;

import java.io.IOException;
import java.util.Map;

@FunctionalInterface
public interface MyReaderForMap<K, V> {
   void read(Map<K,V> map) throws IOException;
}
