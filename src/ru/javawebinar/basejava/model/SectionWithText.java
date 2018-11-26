package ru.javawebinar.basejava.model;

import java.util.Objects;

public class SectionWithText extends AbstractSection {
    private final String content;

    public SectionWithText(String content) {
        Objects.requireNonNull(content, "content must not be null");
        this.content = content;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SectionWithText that = (SectionWithText) o;
        return Objects.equals(content, that.content);
    }

    @Override
    public int hashCode() {

        return Objects.hash(content);
    }

    @Override
    public String toString() {
        return  content ;
    }
}
