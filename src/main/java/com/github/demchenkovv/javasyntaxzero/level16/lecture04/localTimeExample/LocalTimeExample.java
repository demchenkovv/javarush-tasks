package com.github.demchenkovv.javasyntaxzero.level16.lecture04.localTimeExample;

import java.time.LocalTime;

/**
 * Класс LocalTime создан для случаев, когда нужно работать только со временем без даты.
 * Например, вы пишете приложение-будильник. Время для вас важно, а дата — нет.
 * <p>
 * Класс LocalTime очень похож на класс LocalDate: его объекты тоже нельзя изменять после создания.
 */
public class LocalTimeExample {
    public static void main(String[] args) {

        // Получение текущего времени
        LocalTime time1 = LocalTime.now();
        System.out.println("Сейчас = " + time1);

        // Получение заданного времени
        LocalTime time2 = LocalTime.of(12, 15, 0, 100);
        System.out.println("Заданное время = " + time2);

        // Получение времени по номеру секунды (количество секунд, прошедшее с начала суток)
        LocalTime time3 = LocalTime.ofSecondOfDay(10000);
        System.out.println("Время по номеру секунды = " + time3);

        // Получение фрагментов времени
        LocalTime time4 = LocalTime.now(); // Текущее время
        System.out.println(time4.getHour()); // Возвращает часы
        System.out.println(time4.getMinute()); // Возвращает минуты
        System.out.println(time4.getSecond()); // Возвращает секунды
        System.out.println(time4.getNano()); // Возвращает наносекунды

        // Изменение времени в объекте класса LocalTime
        // Каждый метод изменения времени не меняет существующий объект LocalTime, а возвращает новый с нужными данными.
        LocalTime time5 = LocalTime.of(10, 40, 10);
        LocalTime time5plusHours = time5.plusHours(2);
        LocalTime time5minusMin = time5.minusMinutes(40);
        LocalTime time5plusSec = time5.plusSeconds(3600);

        System.out.println("Инициализированное время = " + time5);
        System.out.println("+ 2 часа = " + time5plusHours);
        System.out.println("- 40 минут = " + time5minusMin);
        System.out.println("+ 3600 секунд = " + time5plusSec);
    }
}
