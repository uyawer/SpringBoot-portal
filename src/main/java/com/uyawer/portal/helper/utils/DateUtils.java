/*!
 * Copyright © 2022 uyawer. All rights Reserved.
 */

package com.uyawer.portal.helper.utils;

import org.apache.commons.lang3.StringUtils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class DateUtils {

    public static LocalDate getLocalDateNow() {
        // return LocalDate.of(2021, 9, 21);
        return LocalDate.now();
    }

    public static LocalTime getLocalTimeNow() {
        // return LocalTime.of(18, 00, 00);
        return LocalTime.now();
    }

    public static LocalDateTime getLocalDateTimeNow() {
        return LocalDateTime.of(getLocalDateNow(), getLocalTimeNow());
    }

    public static LocalDateTime getTodayStartTime() {
        return getDayStartTime(getLocalDateTimeNow());
    }

    public static LocalDateTime getDayStartTime(LocalDateTime t) {
        return LocalDateTime.of(t.toLocalDate(), LocalTime.MIN);
    }

    public static LocalDateTime getTodayEndTime() {
        return getDayEndTime(getLocalDateTimeNow());
    }

    public static LocalDateTime getTomorrowStartTime() {
        return LocalDateTime.of(getLocalDateNow().plusDays(1L), LocalTime.MIN);
    }

    public static LocalDateTime getNextDayStartTime(LocalDateTime t) {
        return LocalDateTime.of(t.toLocalDate().plusDays(1L), LocalTime.MIN);
    }

    public static LocalDateTime getDayEndTime(LocalDateTime t) {
        return LocalDateTime.of(t.toLocalDate(), LocalTime.MAX);
    }

    public static String format(LocalDateTime time, String format) {
        return time.format(DateTimeFormatter.ofPattern(format));
    }

    public static Integer calcAge(LocalDate birthday) {
        if (birthday == null) {
            return null;
        }
        return Period.between(birthday, getLocalDateNow()).getYears();
    }

    public static LocalDate toLocalDate(String value) {
        if (StringUtils.isEmpty(value)) {
            return null;
        }

        try {
            return LocalDate.parse(value);
        } catch (Exception e) {
            return null;
        }
    }
}
