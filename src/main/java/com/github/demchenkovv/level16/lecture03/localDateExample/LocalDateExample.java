package com.github.demchenkovv.level16.lecture03.localDateExample;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.ZoneId;
import java.time.chrono.IsoEra;

/**
 * Объекты этого класса не изменяются после создания (класс LocalDate immutable).
 * Зато это добавило классу простоты и надежности.
 * <p>
 * Класс LocalDate содержит несколько методов, которые позволяют работать с датой.
 * Эти методы реализованы по аналогии с методами класса String: каждый из этих методов
 * не меняет существующий объект LocalDate, а возвращает новый с нужными данными.
 */
public class LocalDateExample {
    public static void main(String[] args) {

        // Получение текущей даты
        LocalDate today = LocalDate.now();
        System.out.println("Сегодня = " + today);


        // Получение даты в определенном часовом поясе
        // https://howtodoinjava.com/java/date-time/supported-zone-ids-offsets/
        ZoneId timezone = ZoneId.of("Asia/Shanghai");
        LocalDate todayShanghai = LocalDate.now(timezone);
        System.out.println("Сейчас в Шанхае = " + todayShanghai);


        // Можно задать месяц и по старинке — с помощью чисел
        LocalDate todayOf = LocalDate.of(2019, 2, 22);
        System.out.println("Сегодня = " + today);


        // Получение даты по номеру дня
        LocalDate date = LocalDate.ofYearDay(2007, 365);
        System.out.println("Сегодня = " + date);


        // Получение даты Unix
        // ofEpochDay() - возвращает дату, отсчитанную от 1 января 1970 года
        LocalDate epochDay = LocalDate.ofEpochDay(100);
        System.out.println("Получение даты Unix = " + epochDay);


        // Получение фрагментов даты.
        // Изменять объекты класса LocalDate нельзя, а вот получать отдельные фрагменты даты еще как можно.
        LocalDate dateFragment = LocalDate.now();
        int getYear = dateFragment.getYear(); // Возвращает год из конкретной даты
        Month getMonth = dateFragment.getMonth(); // Возвращает месяц даты — одну из специальных констант JANUARY, FEBRUARY, ...;
        int getMonthValue = dateFragment.getMonthValue(); // Возвращает номер месяца из даты. Январь == 1.
        int getDayOfMonth = dateFragment.getDayOfMonth(); // Возвращает номер дня в месяце
        int getDayOfYear = dateFragment.getDayOfYear(); // Возвращает номер дня с начала года
        DayOfWeek getDayOfWeek = dateFragment.getDayOfWeek(); // Возвращает день недели: одну из специальных констант MONDAY, TUESDAY, ...;
        IsoEra getEra = dateFragment.getEra(); // Возвращает эру: константа BC (Before Current Era) и CE(Current Era)
        System.out.println("Получение фрагментов даты: ");


        // Изменение даты в объекте LocalDate
        // Класс LocalDate содержит несколько методов, которые позволяют работать с датой.
        // Эти методы реализованы по аналогии с методами класса String: каждый из этих методов
        // не меняет существующий объект LocalDate, а возвращает новый с нужными данными.
        LocalDate current = LocalDate.of(2019, 1, 1);
        LocalDate plusDays = current.plusDays(15); // Добавляет определенное количество дней к дате
        LocalDate plusWeeks = current.plusWeeks(10); // Добавляет недели к дате
        LocalDate plusMonths = current.plusMonths(3); // Добавляет месяцы к дате
        LocalDate plusYears = current.plusYears(2); // Добавляет годы к дате
        LocalDate minusDays = current.minusDays(10); // Отнимает дни от даты
        LocalDate minusWeeks = current.minusWeeks(1); // Отнимает недели от даты
        LocalDate minusMonths = current.minusMonths(6); // Отнимает месяцы от даты
        LocalDate minusYears = current.minusYears(10); // Отнимает годы от даты
        System.out.println("Изменение даты в объекте LocalDate: ");
    }
}
