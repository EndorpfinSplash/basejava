package ru.javawebinar.basejava.model;

import java.util.Objects;

public class SectionText extends AbstractSection {
    private static final long serialVersionUID = 1L;
    private String content;

    public SectionText(String content) {
        Objects.requireNonNull(content, "content must not be null");
        this.content = content;
    }

    public SectionText() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SectionText that = (SectionText) o;
        return Objects.equals(content, that.content);
    }

    @Override
    public int hashCode() {

        return Objects.hash(content);
    }

    @Override
    public String toString() {
        return content;
    }
}
