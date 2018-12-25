package ru.javawebinar.basejava.model;

import java.util.List;
import java.util.Objects;

public class SectionExperience extends AbstractSection {
    private static final long serialVersionUID = 1L;
    private final List<ExperienceInCompany> experienceInCompanies;

    public SectionExperience(List<ExperienceInCompany> experienceInCompanies) {
        Objects.requireNonNull(experienceInCompanies, "organizations must not be null");
        this.experienceInCompanies = experienceInCompanies;
    }

    public List<ExperienceInCompany> getExperienceInCompanies() {
        return experienceInCompanies;
    }

    @Override
    public String toString() {
        String experiancesInCompanies = "";
        for (ExperienceInCompany experienceInCompany : experienceInCompanies) {
            experiancesInCompanies = experiancesInCompanies + experienceInCompany.toString() + '\n'+'\n';
        }

        return experiancesInCompanies;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SectionExperience that = (SectionExperience) o;
        return Objects.equals(experienceInCompanies, that.experienceInCompanies);
    }

    @Override
    public int hashCode() {
        return Objects.hash(experienceInCompanies);
    }
}
