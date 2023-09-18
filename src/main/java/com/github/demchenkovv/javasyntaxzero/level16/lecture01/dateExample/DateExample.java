package com.github.demchenkovv.javasyntaxzero.level16.lecture01.dateExample;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateExample {
    public static void main(String[] args) {
        Date date = new Date(105, 5, 4, 12, 15, 0);
        System.out.println(date.getYear());
        System.out.println(date.getMonth());
        System.out.println(date.getDate());
        System.out.println(date.getDay());

        // Сравнение дат
        Date date1 = new Date(2023, 11, 31);
        Date date2 = new Date(2000, 0, 15);
        System.out.println(date1.getTime() > date2.getTime());

        if (date1.before(date2)) { // Читается это так: если date1 перед date2, то...
        }
        if (date2.after(date1)) { // Читается это так: если date2 после date1, то...
        }

        // Класс DateFormat
        Date current = new Date(105, 5, 4, 12, 15, 0);
        SimpleDateFormat formatter = new SimpleDateFormat("MMM-dd-YYYY");
        String message = formatter.format(current);
        System.out.println(message);

        // Метод Date.parse
        // Получить дату из текстовой строки. Или как говорят программисты, парсить строку.
        // Для этого есть специальный метод — parse(). Выглядит процесс парсинга так:
        String s = "Jul 06 12:15:00 2019";
        Date parseDate = new Date();
        parseDate.setTime(Date.parse(s));
    }
}
