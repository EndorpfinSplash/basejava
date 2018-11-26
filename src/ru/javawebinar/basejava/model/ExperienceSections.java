package ru.javawebinar.basejava.model;

import java.util.List;
import java.util.Objects;

public class ExperienceSections extends AbstractSection {
    private final List<Experience> experienceList;

    public ExperienceSections(List<Experience> experienceList) {
        Objects.requireNonNull(experienceList, "organizations must not be null");
        this.experienceList = experienceList;
    }

    public List<Experience> getExperienceList() {
        return experienceList;
    }


    @Override
    public String toString() {

        String list = "";
        for (Experience exp : experienceList) {
                list = list + exp + "\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~" ;
        }
        return list;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ExperienceSections that = (ExperienceSections) o;
        return Objects.equals(experienceList, that.experienceList);
    }

    @Override
    public int hashCode() {

        return Objects.hash(experienceList);
    }
}
