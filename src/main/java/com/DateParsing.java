package com;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class DateParsing {
    private static final String DATE_TIME_PATTERN = "MMMM d, yyyy HH:mm:ss";
    private static final String DATE_FORMATTER_PATTERN = "d MMMM, yyyy";

    public static void main(String[] args) {
        String dateTimeAsString = "June 5, 2020 12:10:56";
        LocalDateTime localDateTime = parseToLocalDateTime(dateTimeAsString);
        System.out.printf("'%s' parse to '%s'\n", dateTimeAsString, localDateTime);

        String dateAsString = "5 June, 2020";
        LocalDate localDate = parseToLocalDate(dateAsString);
        System.out.printf("'%s' parse to '%s'\n", dateAsString, localDate);
    }

    public static LocalDateTime parseToLocalDateTime(String dateTimeAsString) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(DATE_TIME_PATTERN, Locale.US);
        return LocalDateTime.parse(dateTimeAsString, dateTimeFormatter);
    }

    public static LocalDate parseToLocalDate(String dateAsString) {
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern(DATE_FORMATTER_PATTERN, Locale.US);
        return LocalDate.parse(dateAsString, dateFormatter);
    }
}

