package com.github.demchenkovv.javasyntaxzero.level13.lecture05.task5;/*
Месяцы в сезоне
*/

public enum Month {
    JANUARY,
    FEBRUARY,
    MARCH,
    APRIL,
    MAY,
    JUNE,
    JULY,
    AUGUST,
    SEPTEMBER,
    OCTOBER,
    NOVEMBER,
    DECEMBER;

    //напишите тут ваш код
    public static Month[] getWinterMonths() {
        // 00 -- 01 -- 11
        Month[] winterMonths = new Month[3];
        winterMonths[0] = Month.values()[11];
        for (int i = 1; i < 3; i++) {
            winterMonths[i] = Month.values()[i - 1];
        }
        return winterMonths;
    }

    public static Month[] getSpringMonths() {
        Month[] springMonths = new Month[3];
        Month[] allMonthsOfYear = Month.values();
        for (int i = 2, j = 0; i < 5; i++, j++) {
            springMonths[j] = allMonthsOfYear[i];
        }
        return springMonths;
    }

    public static Month[] getSummerMonths() {
        Month[] summerMonths = new Month[3];
        Month[] allMonthsOfYear = Month.values();
        for (int i = 5, j = 0; i < 8; i++, j++) {
            summerMonths[j] = allMonthsOfYear[i];
        }
        return summerMonths;
    }

    public static Month[] getAutumnMonths() {
        Month[] summerMonths = new Month[3];
        Month[] allMonthsOfYear = Month.values();
        for (int i = 8, j = 0; i < 11; i++, j++) {
            summerMonths[j] = allMonthsOfYear[i];
        }
        return summerMonths;
    }
}

/*
В enum com.github.demchenkovv.javasyntaxzero.task5.lecture05.level13.Month добавь 4 метода: getWinterMonths(), getSpringMonths(), getSummerMonths(), getAutumnMonths()
которые будут возвращать массив с тремя месяцами.

Требования:
•	Публичный статический метод getWinterMonths() должен возвращать массив с зимними месяцами.
•	Публичный статический метод getSpringMonths() должен возвращать массив с весенними месяцами.
•	Публичный статический метод getSummerMonths() должен возвращать массив с летними месяцами.
•	Публичный статический метод getAutumnMonths() должен возвращать массив с осенними месяцами.
 */