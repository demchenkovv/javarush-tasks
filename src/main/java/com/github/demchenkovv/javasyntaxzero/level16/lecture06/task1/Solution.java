package com.github.demchenkovv.javasyntaxzero.level16.lecture06.task1;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.TreeSet;

/*
Тренировка временных зон
*/

public class Solution {

    public static void main(String[] args) {
        TreeSet<String> sortedZones = getSortedZones();
        System.out.println(sortedZones.size());
        System.out.println(sortedZones.first());
        System.out.println(sortedZones.last());

        System.out.println(getBeijingDateTime());
    }

    static TreeSet<String> getSortedZones() {
        return new TreeSet<>(ZoneId.getAvailableZoneIds());
    }

    static ZonedDateTime getBeijingDateTime() {
        return ZonedDateTime.now(ZoneId.of("Asia/Shanghai"));
    }
}

/*
Что общего у всех временных зон и Пекина?
Правильно! Они позволят нам потренироваться в использовании классов ZoneId и ZonedDateTime :)

Реализуй два метода:
- в методе getSortedZones верни множество TreeSet всех временных зон;
- в методе getBeijingTime верни текущую дату и время в Пекине (временная зона для него — "Asia/Shanghai").
Требования:
•	Метод getSortedZones должен вернуть множество всех временных зон.
•	Метод getBeijingDateTime должен вернуть текущую дату и время в Пекине.
 */