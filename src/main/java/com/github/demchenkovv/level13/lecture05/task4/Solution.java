package com.github.demchenkovv.level13.lecture05.task4;

/*
Следующий месяц, пожалуйста
*/

public class Solution {

    public static void main(String[] args) {
        System.out.println(getNextMonth(Month.JANUARY));
        System.out.println(getNextMonth(Month.JULY));
        System.out.println(getNextMonth(Month.DECEMBER));
    }

    public static Month getNextMonth(Month month) {
        //напишите тут ваш код
        int totalMonth = Month.values().length;
        int indexMonth = month.ordinal();
        if (indexMonth == totalMonth - 1)
            return Month.values()[0];
        return Month.values()[indexMonth + 1];
    }
}

/*

В классе Solution реализуй метод getNextMonth,
который должен возвращать следующий месяц,
а если передан последний месяц, возвращать первый. Используй методы values и ordinal.
Метод main не участвует в проверке.

Требования:
•	Реализуй метод public static Month getNextMonth(Month): он должен работать согласно условию.
•	В методе getNextMonth должны использоваться методы ordinal() и values().
 */