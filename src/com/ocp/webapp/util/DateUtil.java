package com.ocp.webapp.util;

import org.jetbrains.annotations.NotNull;

import java.time.LocalDate;
import java.time.Month;

public class DateUtil {
    public static @NotNull LocalDate of(int year, Month month) {
        return LocalDate.of(year, month, 1);
    }
}
