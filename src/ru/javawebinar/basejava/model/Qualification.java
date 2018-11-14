package ru.javawebinar.basejava.model;

public class Qualification extends AbstractSection {

    private String qualification;

    public Qualification(String qualification) {
        this.qualification = qualification;
    }

    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }
}
