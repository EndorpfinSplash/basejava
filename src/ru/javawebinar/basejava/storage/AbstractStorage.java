package ru.javawebinar.basejava.storage;

public abstract class AbstractStorage implements Storage {
    static final int STORAGE_LIMIT = 10000;
    int size = 0;
}
