package com.github.demchenkovv.level16.lecture06.zonedDateTimeExample;

import java.time.ZoneId;
import java.util.Set;
import java.util.TreeSet;

/**
 * <a href=https://javarush.com/quests/lectures/questsyntaxpro.level16.lecture06>Часовые пояса</a>
 * <p> Есть еще один очень интересный класс в Date Time API — класс ZonedDateTime.
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
    }
}
