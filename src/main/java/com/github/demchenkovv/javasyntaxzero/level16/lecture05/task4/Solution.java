package com.github.demchenkovv.javasyntaxzero.level16.lecture05.task4;

import java.time.Instant;
import java.time.temporal.ChronoUnit;

/*
Ой как много методов!
*/

/**
 * <code>Class Instant</code>
 * <p> <code>public Instant plus(long amountToAdd, TemporalUnit unit)</code>
 * <p><a href="https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/time/Instant.html#plus(long,java.time.temporal.TemporalUnit)">Link to documentation</a>
 * <p> Возвращает копию этого мгновенного сообщения с добавлением указанной суммы.
 * Это возвращает Instant, основанное на этом, с добавленной суммой в единицах измерения.
 * Если добавить сумму невозможно, поскольку единица измерения не поддерживается или по какой-либо
 * другой причине, генерируется исключение.
 * <p> Если поле является ChronoUnit, то добавление выполняется здесь. Поддерживаемые поля ведут себя следующим образом:
 * <ul>
 * <li>NANOS - Возвращает Instant с добавлением указанного количества наносекунд. Это эквивалентно plusNanos(long).
 * <li>MICROS - Возвращает Instant с добавлением указанного количества микросекунд. Это эквивалентно сумме plusNanos(long), умноженной на 1000.
 * <li>MILLIS - Возвращает Instant с добавлением указанного количества миллисекунд. Это эквивалентно сумме plusNanos(long), умноженной на 1 000 000.
 * <li>SECONDS - Возвращает Instant с добавлением указанного количества секунд. Это эквивалентно plusSeconds (long).
 * <li>MINUTES - Возвращает Instant с добавлением указанного количества минут. Это эквивалентно plusSeconds(long) с суммой, умноженной на 60.
 * <li>HOURS - Возвращает Instant с добавлением указанного количества часов. Это эквивалентно plusSeconds(long) с суммой, умноженной на 3600.
 * <li>HALF_DAYS - Возвращает Instant с добавлением указанного количества полудней. Это эквивалентно plusSeconds(long), умноженным на 43 200 (12 часов).
 * <li>DAYS - Возвращает Instant с добавлением указанного количества дней. Это эквивалентно plusSeconds(long), умноженным на 86 400 (24 часа).
 * </ul>
 * <p>Все остальные экземпляры ChronoUnit выдадут исключение UnsupportedTemporalTypeException.
 */
public class Solution {

    public static void main(String[] args) {
        Instant instant = Instant.ofEpochSecond(10);
        System.out.println(instant);
        System.out.println(plusMinutes(instant, 2));
        System.out.println(plusHours(instant, 2));
        System.out.println(plusDays(instant, 2));
        System.out.println(minusMinutes(instant, 2));
        System.out.println(minusHours(instant, 2));
        System.out.println(minusDays(instant, 2));
    }

    static public Instant plusMinutes(Instant instant, long minutes) {
//        return instant.plusSeconds(minutes * 60);
        return instant.plus(minutes, ChronoUnit.MINUTES);
    }

    static public Instant plusHours(Instant instant, long hours) {
//        return instant.plusSeconds(hours * 3600);
        return instant.plus(hours, ChronoUnit.HOURS);
    }

    static public Instant plusDays(Instant instant, long days) {
        return instant.plus(days, ChronoUnit.DAYS);
    }

    static public Instant minusMinutes(Instant instant, long minutes) {
//        return instant.minusSeconds(minutes * 60);
        return instant.minus(minutes, ChronoUnit.MINUTES);
    }

    static public Instant minusHours(Instant instant, long hours) {
//        return instant.minusSeconds(hours * 3600);
        return instant.minus(hours, ChronoUnit.HOURS);
    }

    static public Instant minusDays(Instant instant, long days) {
//        return instant.minusSeconds(days * 24 * 60 * 60);
        return instant.minus(days, ChronoUnit.DAYS);
    }
}

/*
В классе Solution реализуй шесть методов:
    в методе plusMinutes нужно увеличить параметр instant на minutes минут и вернуть результат;
    в методе plusHours нужно увеличить параметр instant на hours часов и вернуть результат;
    в методе plusDays нужно увеличить параметр instant на days дней и вернуть результат;
    в методе minusMinutes нужно уменьшить параметр instant на minutes минут и вернуть результат;
    в методе minusHours нужно уменьшить параметр instant на hours часов и вернуть результат;
    в методе minusDays нужно уменьшить параметр instant на days дней и вернуть результат.
Требования:
•	Метод plusMinutes нужно реализовать согласно условию.
•	Метод plusHours нужно реализовать согласно условию.
•	Метод plusDays нужно реализовать согласно условию.
•	Метод minusMinutes нужно реализовать согласно условию.
•	Метод minusHours нужно реализовать согласно условию.
•	Метод minusDays нужно реализовать согласно условию.
 */