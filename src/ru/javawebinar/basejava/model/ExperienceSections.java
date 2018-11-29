package ru.javawebinar.basejava.model;

import java.util.List;
import java.util.Map;
import java.util.Objects;

public class ExperienceSections extends AbstractSection {

    private final Map<Link,List<Experience>> experienceList;

    public ExperienceSections(Map<Link,List<Experience>> experienceList) {
        Objects.requireNonNull(experienceList, "organizations must not be null");
        this.experienceList = experienceList;
    }

    public Map<Link,List<Experience>>  getExperienceList() {
        return experienceList;
    }


    @Override
    public String toString() {

        String sectionForOutput = "";
        for (Map.Entry<Link,List<Experience>> pair : experienceList.entrySet()) {
            String experiences = "";
            for (Experience ex : pair.getValue()) {
                experiences = experiences + ex ;
            }

            sectionForOutput = sectionForOutput + pair.getKey().getName() + "\n" +
                        "" + experiences +
                        "\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n";
        }
        return sectionForOutput;
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
