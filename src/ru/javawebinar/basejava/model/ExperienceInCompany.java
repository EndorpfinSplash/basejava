package ru.javawebinar.basejava.model;

import java.util.List;

public class ExperienceInCompany {
    private  Link company;
    private List<Experience> experienceList;

    public ExperienceInCompany() {
    }

    public ExperienceInCompany(Link company, List<Experience> experienceList) {
        this.company = company;
        this.experienceList = experienceList;
    }

    public Link getCompany() {
        return company;
    }

    public List<Experience> getExperienceList() {
        return experienceList;
    }

    @Override
    public String toString() {

        String listOfExperianceInCompany = "";
        for (Experience experience : experienceList) {
            listOfExperianceInCompany = listOfExperianceInCompany + experience.toString() + '\n';
        }

        return company +
                "\n=======================================================\n" +
                experienceList;
    }
}
