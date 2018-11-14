package ru.javawebinar.basejava.model;

import java.util.Date;

public class Experience extends AbstractSection {
    String company;
    Date startDate;
    Date endDate;
    String title;
    String description;

    public Experience(String company, Date startDate, Date endDate, String title, String description) {
        this.company = company;
        this.startDate = startDate;
        this.endDate = endDate;
        this.title = title;
        this.description = description;
    }
}
