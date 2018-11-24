package ru.javawebinar.basejava.model;

public class Experience extends AbstractSection {
    String company;
    String startDate;
    String endDate;
    String title;
    String description;

    public Experience(String company, String startDate, String endDate, String title, String description) {
        this.company = company;
        this.startDate = startDate;
        this.endDate = endDate;
        this.title = title;
        this.description = description;
    }

    @Override
    public String toString() {
        return  "\n" +
                company +
                "\n" +
                 startDate + " - "  + endDate +
                "        " +
                title +
                "\n" +
                description ;
    }
}