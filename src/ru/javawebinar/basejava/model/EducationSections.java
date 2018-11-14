package ru.javawebinar.basejava.model;

import java.util.List;

public class EducationSections extends AbstractSection {
    private List<Education> educationList;

    public List<Education> getEducationList() {
        return educationList;
    }

    public void setEducationList(List<Education> educationList) {
        this.educationList = educationList;
    }

}
