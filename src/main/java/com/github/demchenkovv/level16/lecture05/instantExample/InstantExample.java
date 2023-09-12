package com.github.demchenkovv.level16.lecture05.instantExample;

import java.time.Instant;

/**
 * Класс Instant
 * <p>
 * В Date Time API добавили класс Instant для работы со временем, нацеленным на процессы внутри компьютеров.
 * Вместо часов, минут и секунд, он оперирует секундами, миллисекундами и наносекундами.
 * <p>
 * Этот класс хранит в себе два поля:
 * количество секунд, прошедшее с 1 января 1970 года и количество наносекунд.
 * <p>
 * Можно даже сказать, что класс Instant — это упрощенная версия класса Date: оставили только то, что нужно программистам.
 */
public class InstantExample {
    public static void main(String[] args) {

        // Получить объект Instant можно точно так же, как объект LocalTime:
        Instant instant = Instant.now();

        // Также можно создать новый объект с помощью разновидностей метода of(),
        // если передать в него время, прошедшее с 1 января 1970 года:
        // ofEpochMilli(long milliseconds) // Нужно передать количество миллисекунд
        // ofEpochSecond(long seconds) // Нужно передать количество секунд
        // ofEpochSecond(long seconds, long nanos) // Нужно передать секунды и наносекунды

        // Методы объектов Instant
        // long getEpochSecond() Количество секунд, прошедшее с 1 января 1970 года
        // int getNano() Наносекунды
        // long toEpochMilli() Количество миллисекунд, прошедшее с 1 января 1970 года

        // Также есть методы, которые способны создавать новые объекты Instant на основе уже существующего:
        // Instant plusSeconds (long) Добавляет секунды к текущему моменту времени
        // Instant plusMillis (long) Добавляет миллисекунды
        // Instant plusNanos (long) Добавляет наносекунды
        // Instant minusSeconds (long) Вычитает секунды
        // Instant minusMillis (long) Вычитает миллисекунды
        // Instant minusNanos (long) Вычитает наносекунды

        // Примеры:
        Instant timestamp = Instant.now();
        System.out.println(timestamp);

        long n = timestamp.toEpochMilli();
        Instant time = Instant.ofEpochMilli(n);
        System.out.println(time);
    }
}
