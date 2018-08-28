package ru.javawebinar.basejava.exceptions;

public class ExistStorageException extends StorageException {
    public ExistStorageException(String uuid) {
        super("Resume " + uuid + " already exist.",uuid);
    }
}
