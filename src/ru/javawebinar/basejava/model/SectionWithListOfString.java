package ru.javawebinar.basejava.model;

import java.util.List;

public class SectionWithListOfString extends AbstractSection {
    private List<String> sectionList;

    public SectionWithListOfString(List<String> sectionList) {
        this.sectionList = sectionList;
    }

    public List<String> getList() {
        return sectionList;
    }

    public void setList(List<String> list) {
        this.sectionList = list;
    }

    @Override
    public String toString() {
        String text = "";
        for (String s : sectionList) {
            text = text + s + "\n";
        }
        return text;
    }
}
