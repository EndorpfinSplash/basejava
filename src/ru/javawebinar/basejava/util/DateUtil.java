package ru.javawebinar.basejava.util;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.Month;

public class DateUtil implements Serializable {
    public static final LocalDate NOW = LocalDate.of(3000, 1, 1);

    public static LocalDate of(int year, Month month) {
        return LocalDate.of(year, month, 1);
    }

    public static LocalDate of() {
        return LocalDate.now();
    }
}
