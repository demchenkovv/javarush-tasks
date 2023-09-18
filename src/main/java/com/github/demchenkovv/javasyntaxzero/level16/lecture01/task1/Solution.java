package com.github.demchenkovv.javasyntaxzero.level16.lecture01.task1;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/*
Лишь бы не в понедельник :)
*/

public class Solution {

    static Date birthDate = new Date(123, Calendar.SEPTEMBER, 11);

    public static void main(String[] args) {
        System.out.println(getDayOfWeek(birthDate)); // С использованием switch
        System.out.println(getDayOfWeekWithDateFormat(birthDate)); // С использованием SimpleDateFormat
    }

    static String getDayOfWeek(Date date) {
        int value = date.getDay();
        return switch (value) {
            case 0 -> "Воскресенье";
            case 1 -> "Понедельник";
            case 2 -> "Вторник";
            case 3 -> "Среда";
            case 4 -> "Четверг";
            case 5 -> "Пятница";
            case 6 -> "Суббота";
            default -> throw new IllegalStateException("Unexpected value: " + value);
        };
    }

    static String getDayOfWeekWithDateFormat(Date date) {
        SimpleDateFormat formatter = new SimpleDateFormat("EEEE", new Locale("ru"));
        String formatDate = formatter.format(date);
        String withCapitalLetter = formatDate.substring(0, 1).toUpperCase() + formatDate.substring(1);
        return withCapitalLetter;
    }
}

/*
Проинициализируй переменную birthDate объектом Date с датой своего рождения.
Реализуй метод getDayOfWeek(Date date), чтобы он возвращал русское название дня недели аргумента date.

Требования:
•	Переменная birthDate должна быть проинициализирована при объявлении.
•	Метод getDayOfWeek(Date date) должен возвращать русское название дня недели.
 */