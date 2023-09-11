package com.github.demchenkovv.level16.lecture02.task1;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;

/*
День недели рождения твоего
*/

public class Solution {

    static Calendar birthDate = new GregorianCalendar(2023, Calendar.SEPTEMBER, 11);

    public static void main(String[] args) {
        System.out.println(getDayOfWeek(birthDate));

        // еще вариант: через SimpleDateFormat
        System.out.println(getDayOfWeekWithSimpleDateFormat(birthDate));

        // еще вариант (через встроенный метод getDisplayName)
        System.out.println(birthDate.getDisplayName(
                Calendar.DAY_OF_WEEK,
                Calendar.LONG,
                Locale.getDefault()));
    }

    static String getDayOfWeek(Calendar calendar) {
        //напишите тут ваш код
        int dayOfWeek = birthDate.get(Calendar.DAY_OF_WEEK);
        return switch (dayOfWeek) {
            case 1 -> "воскресенье";
            case 2 -> "понедельник";
            case 3 -> "вторник";
            case 4 -> "среда";
            case 5 -> "четверг";
            case 6 -> "пятница";
            case 7 -> "суббота";
            default -> throw new IllegalStateException("Unexpected value: " + dayOfWeek);
        };
    }

    private static String getDayOfWeekWithSimpleDateFormat(Calendar calendar) {
        SimpleDateFormat formatter = new SimpleDateFormat("EEEE", new Locale("ru"));
        String dayOfWeek = formatter.format(calendar.getTime());
        return dayOfWeek;
    }
}

/*
Проинициализируй переменную birthDate объектом GregorianCalendar с датой своего рождения.
Реализуй метод getDayOfWeek(Calendar calendar), чтобы он возвращал русское название дня недели аргумента calendar.
Помни, что в григорианском календаре неделя начинается с воскресенья.

Требования:
•	Переменная birthDate должна быть проинициализирована при объявлении.
•	Метод getDayOfWeek(Calendar calendar) должен возвращать день недели аргумента calendar.
 */