package com.github.demchenkovv.level16.lecture06.zonedDateTimeExample;

import java.time.*;
import java.util.Set;
import java.util.TreeSet;

/**
 * <a href=https://javarush.com/quests/lectures/questsyntaxpro.level16.lecture06>Часовые пояса</a>
 * <p> Есть еще один очень интересный класс в Date Time API — класс ZonedDateTime.
 * <p>ZonedDateTime — аналог java.util.Calendar. Это самый мощный класс с полной информацией
 * о временном контексте, включает временную зону, поэтому все операции со сдвигами этот класс проводит правильно.
 * Основное его назначение — удобно работать с датами в разных часовых поясах.
 * <p> Всего в настоящий момент официально известно 599 временных зон.
 */
public class ZonedDateTimeExample {
    public static void main(String[] args) {

        // ZoneId.getAvailableZoneIds() - возвращает множество всех известных на текущий момент временных зон
        Set<String> setZoneId = new TreeSet<>(ZoneId.getAvailableZoneIds());
        for (String s : setZoneId)
            System.out.println(s);


        // Чтобы получить объект ZoneId по его имени, нужно воспользоваться статическим методом of();
        ZoneId zone = ZoneId.of("Africa/Cairo");


        // При создании объекта ZonedDateTime нужно вызвать у него статический метод now()
        // и передать в него объект ZoneId
        ZoneId zone1 = ZoneId.of("Africa/Cairo");
        ZonedDateTime time1 = ZonedDateTime.now(zone);
        System.out.println(time1);


        // Если в метод now() не передать объект ZoneId, а так можно, временная зона будет определена автоматически
        ZonedDateTime time2 = ZonedDateTime.now();
        System.out.println(time2);


        // Преобразование глобальной даты в локальную
        ZoneId zoneIdCairo = ZoneId.of("Africa/Cairo");
        ZonedDateTime zoneCairo = ZonedDateTime.now(zoneIdCairo);

        LocalDate localDate = zoneCairo.toLocalDate();
        LocalTime localTime = zoneCairo.toLocalTime();
        LocalDateTime localDateTime = zoneCairo.toLocalDateTime();


        // withZoneSameInstant(ZoneId) - возвращает новый объект с тем же моментом времени (instant),
        // но в другом часовом поясе. Таким образом можно узнать время в другом месте в настоящее время.
        ZonedDateTime znd = ZonedDateTime.now(); // текущее время и дата
        System.out.println("Original date and time: " + znd);

        ZoneId newZone = ZoneId.of("Europe/Paris"); // новый объект с другим часовым поясом
        ZonedDateTime newZdt = znd.withZoneSameInstant(newZone); // новый объект ZonedDateTime с тем же моментом времени, но в часовом поясе Europe/Paris
        System.out.println("New date and time in Paris timezone: " + newZdt);


        // withZoneSameLocal(ZoneId) - используется для преобразования локальной даты и времени
        // (без учета перехода на летнее время). Этот метод изменяет часовой пояс объекта ZonedDateTime
        // без изменения момента времени.
        ZoneId zoneDefault = ZoneId.systemDefault();
        ZonedDateTime now = ZonedDateTime.now(zoneDefault);
        ZoneId newZoneId = ZoneId.of("America/Los_Angeles");
        ZonedDateTime zonedDateTime = now.withZoneSameLocal(newZoneId);
        System.out.println("Date and time in " + newZoneId + " timezone: " + zonedDateTime);


        // Работа со временем
//        int getYear() Возвращает год из конкретной даты
//        Month getMonth() Возвращает месяц даты: одну из специальных констант JANUARY, FEBRUARY, ...;
//        int getMonthValue() Возвращает номер месяца из даты. Январь == 1
//        int getDayOfMonth() Возвращает номер дня в месяце
//        DayOfWeek getDayOfWeek() Возвращает день недели: одну из специальных констант MONDAY, TUESDAY, ...;
//        int getDayOfYear() Возвращает номер дня в году
//        int getHour() Возвращает часы
//        int getMinute() Возвращает минуты
//        int getSecond() Возвращает секунды
//        int getNano() Возвращает наносекунды


        // Все методы полностью аналогичны методам LocalDateTime. И, конечно, у класса ZonedDateTime есть методы,
        // которые позволяют работать с датой и временем. При этом объект, у которого вызываются методы, не меняется:
        // вместо этого методы возвращают новый объект ZonedDateTime:
//        plusYears(int) Добавляет годы к дате
//        plusMonths(int) Добавляет месяцы к дате
//        plusDays(int) Добавляет дни к дате
//        plusHours(int) Добавляет часы
//        plusMinutes(int) Добавляет минуты
//        plusSeconds(int) Добавляет секунды
//        plusNanos(int) Добавляет наносекунды
//        minusYears(int) Отнимает годы от даты
//        minusMonths(int) Отнимает месяцы от даты
//        minusDays(int) Отнимает дни от даты
//        minusHours(int) Вычитает часы
//        minusMinutes(int) Вычитает минуты
//        minusSeconds(int) Вычитает секунды
//        minusNanos(int) Вычитает наносекунды
    }
}
