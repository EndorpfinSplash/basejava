package ru.javawebinar.basejava.model;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class SectionWithListOfString extends AbstractSection {
    private static final long serialVersionUID = 1L;
    private final List<String> sectionList;

    public SectionWithListOfString(List<String> sectionList) {
        Objects.requireNonNull(sectionList, "list must not be null");
        this.sectionList = sectionList;
    }

    public SectionWithListOfString(String ... sectionList) {
        this(Arrays.asList(sectionList));
    }

    public List<String> getSectionList() {
        return sectionList;
    }

    @Override
    public String toString() {
        String text = "";
        for (String s : sectionList) {
            text = text + s + "\n";
        }
        return text;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SectionWithListOfString that = (SectionWithListOfString) o;
        return Objects.equals(sectionList, that.sectionList);
    }

    @Override
    public int hashCode() {

        return Objects.hash(sectionList);
    }
}
