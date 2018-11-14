package ru.javawebinar.basejava.model;

    import java.util.List;

public class Education {
    String institution;
    List<SubPeriod> subPeriods;

    public Education(String institution, List<SubPeriod> subPeriods) {
        this.institution = institution;
        this.subPeriods = subPeriods;
    }

    class SubPeriod {
        String startDate;
        String endDate;

        String description;
        public SubPeriod(String startDate, String endDate, String description) {
            this.startDate = startDate;
            this.endDate = endDate;
            this.description = description;
        }

    }
}
