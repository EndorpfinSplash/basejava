package ru.javawebinar.basejava.model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Experience extends AbstractSection {
    private Link company;
    private final LocalDate startDate;
    private final LocalDate endDate;
    private String title;
    private String description;

    final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("MM/YYYY");

    public Experience(String companyName, String url, LocalDate startDate, LocalDate endDate, String title, String description) {
        this.company = new Link(companyName, url);
        this.startDate = startDate;
        this.endDate = endDate;
        this.title = title;
        this.description = description;
    }

    public Link getCompany() {
        return company;
    }

    @Override
    public String toString() {
        return dateTimeFormatter.format(startDate) + " - " + dateTimeFormatter.format(endDate) +
                "        " +
                title +
                "\n" +
                description;
    }
}