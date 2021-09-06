package com.ocp.webapp;

import org.w3c.dom.ls.LSOutput;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

import static java.time.format.DateTimeFormatter.ofPattern;

public class MainDate {
    public static void main(String[] args) {
        Date date = new Date();
        System.out.println(date);
        System.out.println(System.currentTimeMillis() - date.getTime());
        Calendar cal = Calendar.getInstance();


        LocalDate ld = LocalDate.now();
        LocalTime lt = LocalTime.now();
        LocalDateTime ldt = LocalDateTime.now();
        System.out.println(ld);
        System.out.println(lt);
        System.out.println(ldt);

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/YY");
        System.out.println(sdf.format(date));


        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/YY");
        System.out.println(dtf.format(ldt));

        LocalDate localDate = LocalDate.of(2021,1,23);
        System.out.println(localDate);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/YYYY");
        System.out.println(formatter.format(localDate));
    }

}
