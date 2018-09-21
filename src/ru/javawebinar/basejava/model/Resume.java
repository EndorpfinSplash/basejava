package ru.javawebinar.basejava.model;

import java.util.Comparator;
import java.util.UUID;

/**
 * Initial resume class
 */
public class Resume implements Comparable<Resume> {

    // Unique identifier
    private final String uuid;
    private String fullName;

    public String getFullName() {
        return fullName;
    }


    public Resume() {
        this(UUID.randomUUID().toString());
    }

    public Resume(String uuid) {
        this.uuid = uuid;
    }

    public Resume(String uuid, String fullName) {
        this.uuid = uuid;
        this.fullName = fullName;
    }


    @Override
    public String toString() {
        return /*"Full name: " + fullName +*/ " UUID: " + uuid + "\n";
    }

    public String getUuid() {
        return uuid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Resume resume = (Resume) o;

        return uuid.equals(resume.uuid) && fullName.equals(resume.getFullName());
    }

    @Override
    public int hashCode() {
        return uuid.hashCode();
    }

    @Override
    public int compareTo(Resume o) {
        return Comparator.comparing(Resume::getFullName)
                .thenComparing(Resume::getUuid)
                .compare(this, o);
    }
}
