package com.github.demchenkovv.javasyntaxzero.level16.lecture07.dateTimeFormatterExample;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

/**
 * В Date Time API был добавлен специальный класс <a href=https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/time/format/DateTimeFormatter.html>DateTimeFormatter</a>.
 * Его цель — по максимуму облегчить преобразование даты и времени именно в тот формат, который нужен программисту.
 * И можно сказать, что создателям Java это удалось.
 */
public class DateTimeFormatterExample {
    public static void main(String[] args) {

        // нужно создать объект класса DateTimeFormatter и передать в него шаблон,
        // по которому будут отображаться дата и время:
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM-dd-yy");
        String text = dtf.format(LocalDateTime.now());
        System.out.println(text);


        // Парсинг даты
        DateTimeFormatter dtfDate = DateTimeFormatter.ofPattern("MMMM-dd-yyyy", Locale.ENGLISH);
        LocalDate date = LocalDate.parse("February-23-2019", dtfDate);
        System.out.println("Parsing date: " + date);


        // Парсинг времени
        DateTimeFormatter dtfTime = DateTimeFormatter.ofPattern("HH:mm:ss");
        LocalTime time = LocalTime.parse("23:59:59", dtfTime);
        System.out.println("Parsing time: " + time);


    }
}
