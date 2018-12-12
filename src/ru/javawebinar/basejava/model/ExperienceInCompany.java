package ru.javawebinar.basejava.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import static ru.javawebinar.basejava.util.DateUtil.NOW;
import static ru.javawebinar.basejava.util.DateUtil.of;

public class ExperienceInCompany  implements Serializable {
    private static final long serialVersionUID =1L;

    private Link company;
    private List<Position> positionList;
    static final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("MM/YYYY");


    public ExperienceInCompany() {
    }

    public ExperienceInCompany(Link company, List<Position> positionList) {
        this.company = company;
        this.positionList = positionList;
    }

    public ExperienceInCompany(Link company, Position... positions) {
        this(company, Arrays.asList(positions));
    }

    public ExperienceInCompany(String name, String url, Position... positions) {
        this(new Link(name, url), Arrays.asList(positions));
    }

    public Link getCompany() {
        return company;
    }

    public List<Position> getPositionList() {
        return positionList;
    }

    @Override
    public String toString() {

        String listOfExperianceInCompany = "";
        for (Position position : positionList) {
            listOfExperianceInCompany = listOfExperianceInCompany + position.toString() + '\n';
        }

        return company +
                "\n=======================================================\n" +
                positionList;
    }

    public static class Position implements Serializable {
        private final LocalDate startDate;
        private final LocalDate endDate;
        private String title;
        private String description;


        public Position(int startYear, Month startMonth, int endYear, Month endMonth, String title, String description) {
            this(of(startYear, startMonth), of(endYear, endMonth), title, description);
        }

        public Position(int startYear, Month startMonth, String title, String description) {
            this(of(startYear, startMonth), NOW, title, description);
        }

        public Position(LocalDate startDate, LocalDate endDate, String title, String description) {
            Objects.requireNonNull(startDate, "Start date must not be null");
            Objects.requireNonNull(endDate, "end date must not be null");
            Objects.requireNonNull(title, "title date must not be null");
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
            Position position = (Position) o;
            return Objects.equals(startDate, position.startDate) &&
                    Objects.equals(endDate, position.endDate) &&
                    Objects.equals(title, position.title) &&
                    Objects.equals(description, position.description) ;
        }

        @Override
        public int hashCode() {

            return Objects.hash(startDate, endDate, title, description);
        }
    }
}
