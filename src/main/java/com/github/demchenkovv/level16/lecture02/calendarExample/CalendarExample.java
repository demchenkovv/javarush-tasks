package com.github.demchenkovv.level16.lecture02.calendarExample;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class CalendarExample {
    public static void main(String[] args) {

        // Вывод объекта календарь на экран
        Calendar gregorianCalendar = new GregorianCalendar(2023, 0, 31); // Если просто вывести объект-календарь на экран, результат вас не сильно порадует.
        Date date = gregorianCalendar.getTime(); // Возвращает Date. Правильно будет отображать объект календарь с помощью класса SimpleDateFormat, но это в другой раз.
        System.out.println(gregorianCalendar.getTime());


        // Работа с фрагментами даты
        Calendar calendar = Calendar.getInstance();
        int era = calendar.get(Calendar.ERA); // эра (до нашей эры или после)
        int year = calendar.get(Calendar.YEAR); // год
        int month = calendar.get(Calendar.MONTH); // месяц
        int day = calendar.get(Calendar.DAY_OF_MONTH); // день месяца
        int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK); // день недели
        int hour = calendar.get(Calendar.HOUR); // часы
        int minute = calendar.get(Calendar.MINUTE); // минуты
        int second = calendar.get(Calendar.SECOND); // секунды


        // Для изменения фрагмента даты используется метод set:
        calendar.set(Calendar.MONTH, 1); // calendar.set(Calendar.MONTH, значение);
        // Где calendar — это переменная типа Calendar, а MONTH — это переменная-константа класса Calendar.
        // В метод set в качестве первого параметра вы передаете специальную константу класса Calendar,
        // а в качестве второго параметра — новое значение.
        // Примеры:
        Calendar calendar2 = new GregorianCalendar();
        calendar2.set(Calendar.YEAR, 2019);
        calendar2.set(Calendar.MONTH, 6);
        calendar2.set(Calendar.DAY_OF_MONTH, 4);
        calendar2.set(Calendar.HOUR_OF_DAY, 12);
        calendar2.set(Calendar.MINUTE, 15);
        calendar2.set(Calendar.SECOND, 0);
        System.out.println(calendar2.getTime());


        // Константы класса Calendar
        Calendar calendar3 = new GregorianCalendar(2019, Calendar.JANUARY, 31);
        if (calendar3.get(Calendar.DAY_OF_WEEK) == Calendar.FRIDAY) {
            System.out.println("Это пятница");
        }


        // Изменение даты в объекте Calendar
        // У класса Calendar есть метод, который позволяет проводить с датой более умные операции.
        // Например, добавить к дате год, месяц или несколько дней. Или отнять. Называется этот метод add().
        // В метод add в качестве первого параметра вы передаете специальную константу класса Calendar,
        // и в качестве второго параметра — значение, которое нужно добавить.
        // calendar.add(Calendar.MONTH, значение);
        Calendar calendar4 = new GregorianCalendar(2019, Calendar.FEBRUARY, 27);
        calendar4.add(Calendar.MONTH, 2); // прибавить 2 месяца
        System.out.println(calendar4.getTime());
        calendar4.add(Calendar.DAY_OF_WEEK, -10); // отнять 10 дней
        System.out.println(calendar4.getTime());


        // Прокручивание фрагментов даты
        // roll() - любые изменения с его помощью затрагивают один параметр, остальные остаются неизменными.
        Calendar calendar5 = new GregorianCalendar(2019, Calendar.FEBRUARY, 27);
        calendar5.roll(Calendar.MONTH, -2); // Месяц мы поменяли, а год и число остались неизменными.
        System.out.println(calendar5.getTime());
    }
}
