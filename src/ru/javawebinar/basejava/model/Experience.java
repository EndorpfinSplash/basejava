package ru.javawebinar.basejava.model;

public class Experience extends AbstractSection {
    Link company;
    String startDate;
    String endDate;
    String title;
    String description;

    public Experience(String companyName, String url, String startDate, String endDate, String title, String description) {
        this.company = new Link(companyName, url);
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