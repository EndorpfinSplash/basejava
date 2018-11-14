package ru.javawebinar.basejava.model;

import java.util.List;

public class ExperienceSections extends AbstractSection {
    private List<Experience> experienceList;

    public List<Experience> getExperienceList() {
        return experienceList;
    }

    public void setExperienceList(List<Experience> experienceList) {
        this.experienceList = experienceList;
    }
}
