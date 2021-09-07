package com.ocp.webapp.util;

import org.jetbrains.annotations.NotNull;

import java.time.LocalDate;
import java.time.Month;

public class DateUtil {
    public static final LocalDate NOW = LocalDate.of(3000, 1, 1);

    public static @NotNull LocalDate of(int year, Month month) {
        return LocalDate.of(year, month, 1);
    }
}
