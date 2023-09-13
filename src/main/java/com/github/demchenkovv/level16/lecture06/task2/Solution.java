package com.github.demchenkovv.level16.lecture06.task2;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

/*
Временная глобализация
*/

public class Solution {

    static LocalDateTime localDateTime = LocalDateTime.of(2020, 3, 19, 9, 17);
    static ZoneId zoneId = ZoneId.of("Zulu");
    static ZonedDateTime globalTime;

    public static void main(String[] args) {
            globalTime = ZonedDateTime.of(localDateTime, zoneId);

        System.out.println(globalTime);
    }
}

/*
В методе main присвой значение переменной globalTime,
используя переменные localDateTime и zoneId.
Требования:
•	Метод main должен присвоить значение переменной globalTime,
используя переменные localDateTime и zoneId.
 */