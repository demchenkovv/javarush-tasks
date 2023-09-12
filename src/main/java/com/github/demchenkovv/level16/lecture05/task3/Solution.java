package com.github.demchenkovv.level16.lecture05.task3;

import java.time.Instant;
import java.time.temporal.ChronoField;

/*
Конец времен
*/

public class Solution {

    public static void main(String[] args) {
        System.out.println(getMaxFromMilliseconds());
        System.out.println(getMaxFromSeconds());
        System.out.println(getMaxFromSecondsAndNanos());
    }

    static Instant getMaxFromMilliseconds() {
        return Instant.ofEpochMilli(Long.MAX_VALUE);
    }

    static Instant getMaxFromSeconds() {
        return Instant.ofEpochSecond(Instant.MAX.getEpochSecond());
    }

    static Instant getMaxFromSecondsAndNanos() {
        return Instant.ofEpochSecond(Instant.MAX.getEpochSecond(), Instant.MAX.getNano());
    }
}

/*
В классе Solution реализуй три метода:
1. В методе getMaxFromMilliseconds верни максимальный Instant, который можно получить
   с помощью метода ofEpochMilli(long milliseconds);
2. В методе getMaxFromSeconds верни максимальный Instant, который можно получить
   с помощью метода ofEpochSecond(long seconds);
3. В методе getMaxFromSecondsAndNanos верни максимальный Instant, который можно получить
   с помощью метода ofEpochSecond(long seconds, long nanos).

Требования:
•	Метод getMaxFromMilliseconds нужно реализовать согласно условию.
•	Метод getMaxFromSeconds нужно реализовать согласно условию.
•	Метод getMaxFromSecondsAndNanos нужно реализовать согласно условию.
 */