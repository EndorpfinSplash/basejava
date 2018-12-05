package ru.javawebinar.basejava.model;

import java.util.List;
import java.util.Objects;

public class ExperienceSection extends AbstractSection {

    private final List<ExperienceInCompany> experienceInCompanies;

    public ExperienceSection(List<ExperienceInCompany> experienceInCompanies) {
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
            experiancesInCompanies = experiancesInCompanies + experienceInCompany.toString();
        }

        return experiancesInCompanies;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ExperienceSection that = (ExperienceSection) o;
        return Objects.equals(experienceInCompanies, that.experienceInCompanies);
    }

    @Override
    public int hashCode() {
        return Objects.hash(experienceInCompanies);
    }
}
