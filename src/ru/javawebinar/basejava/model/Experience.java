package ru.javawebinar.basejava.model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class Experience extends AbstractSection {
    private final LocalDate startDate;
    private final LocalDate endDate;
    private String title;
    private String description;

    final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("MM/YYYY");

    public Experience(LocalDate startDate, LocalDate endDate, String title, String description) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.title = title;
        this.description = description;
    }

    @Override
    public String toString() {
        return dateTimeFormatter.format(startDate) + " - " + dateTimeFormatter.format(endDate) +
                "        " +
                title +
                "\n" +
                description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Experience that = (Experience) o;
        return Objects.equals(startDate, that.startDate) &&
                Objects.equals(endDate, that.endDate) &&
                Objects.equals(title, that.title) &&
                Objects.equals(description, that.description) &&
                Objects.equals(dateTimeFormatter, that.dateTimeFormatter);
    }

    @Override
    public int hashCode() {
        return Objects.hash(startDate, endDate, title, description, dateTimeFormatter);
    }
}