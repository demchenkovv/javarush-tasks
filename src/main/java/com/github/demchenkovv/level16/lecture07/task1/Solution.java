package com.github.demchenkovv.level16.lecture07.task1;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

/*
Простой шаблон
*/

public class Solution {

    static LocalDateTime localDateTime = LocalDateTime.now();

    public static void main(String[] args) {
//        localDateTime = LocalDateTime.of(2020,3,19,5,4);
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd.MM.yyyyг. Hч.mмин");
        System.out.println(dtf.format(localDateTime));
    }
}

/*
В методе main выведи на экран переменную localDateTime в таком виде:
19.03.2020г. 5ч.4мин

Требования:
•	Метод main должен вывести в консоли значение переменной localDateTime согласно шаблону.
 */