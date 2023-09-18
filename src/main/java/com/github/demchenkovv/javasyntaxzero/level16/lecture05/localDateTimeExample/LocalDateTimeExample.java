package com.github.demchenkovv.javasyntaxzero.level16.lecture05.localDateTimeExample;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;

/**
 * Класс LocalDateTime объединяет в себе возможности классов LocalDate и LocalTime: он хранит и дату, и время.
 * <p>
 * Его объекты тоже неизменяемые, и его методы также аналогичны методам классов LocalDate и LocalTime.
 * <p>
 * При выводе на экран дата и время разделяются буквой T.
 * <p>
 * У класса LocalDateTime есть методы получения фрагмента даты и/или времени. Они абсолютно аналогичны методам классов LocalDate и LocalTime.
 */
public class LocalDateTimeExample {
    public static void main(String[] args) {

        // Получение текущего момента: дата и время
        LocalDateTime time = LocalDateTime.now();
        System.out.println("now() = " + time); // При выводе на экран дата и время разделяются буквой T.

        // Получение определенного момента: дата и время
        // ... = LocalDateTime.of(год, месяц, день, часы, минуты, секунды);

        // Можно задать дату явно или через объекты LocalDate и LocalTime:
        LocalDate localDate = LocalDate.now();
        LocalTime localTime = LocalTime.now();
        LocalDateTime current = LocalDateTime.of(localDate, localTime);
        System.out.println("LocalDateTime.of(localDate, localTime) = " + current);

        LocalDateTime date = LocalDateTime.of(2019, Month.MAY, 15, 12, 15, 00);
        System.out.println("LocalDateTime.of = " + date);
    }
}
