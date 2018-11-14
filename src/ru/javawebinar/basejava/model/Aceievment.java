package ru.javawebinar.basejava.model;

public class Aceievment extends AbstractSection {
    private String achievement;

    public Aceievment(String achievement) {
        this.achievement = achievement;
    }

    public String getAchievement() {
        return achievement;
    }

    public void setAchievement(String achievement) {
        this.achievement = achievement;
    }
}
