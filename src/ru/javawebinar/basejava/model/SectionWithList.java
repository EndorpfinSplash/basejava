package ru.javawebinar.basejava.model;

import java.util.List;

public class SectionWithList extends Section{
    List<String> sectionList;

    public List<String> getList() {
        return sectionList;
    }

    public void setList(List<String> list) {
        this.sectionList = list;
    }

    @Override
    public String toString() {
        String text="";
        for (String s:sectionList) {
         text = text + s;
        }
        return text;
    }
}
