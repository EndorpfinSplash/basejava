package ru.javawebinar.basejava.model;

import java.util.List;

public class ExperienceSections extends AbstractSection {
    private List<Experience> experienceList;

    public ExperienceSections(List<Experience> experienceList) {
        this.experienceList = experienceList;
    }

    public List<Experience> getExperienceList() {
        return experienceList;
    }


    public void setExperienceList(List<Experience> experienceList) {
        this.experienceList = experienceList;
    }

    @Override
    public String toString() {

        String list = "";
        for (Experience exp : experienceList) {
                list = list + exp + "\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~" ;
        }
        return list;
    }
}
