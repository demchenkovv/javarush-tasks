package com.github.demchenkovv.javasyntaxzero.level16.lecture04.task2;

import java.time.LocalTime;

/*
Нужно просто посчитать
*/

public class Solution {

    public static void main(String[] args) throws InterruptedException {
        LocalTime localTime = LocalTime.MIDNIGHT; // 00-00
        LocalTime next = amazingMethod(localTime);
        while (next.isAfter(localTime)) {
            System.out.println(next);
            next = amazingMethod(next);
            Thread.sleep(500);
        }
    }

    static LocalTime amazingMethod(LocalTime base) {
        return base.plusMinutes(288); // 1440 / 5
    }
}

/*
Цикл while в методе main должен отработать ровно четыре раза,
 чтобы на экран вывелись 4 строки.
Изменения можно вносить только в метод amazingMethod.

Требования:
•	Метод amazingMethod должен быть изменен так, чтобы при запуске программа вывела 4 строки.
 */