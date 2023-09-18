package com.github.demchenkovv.javasyntaxzero.level14.lecture03.task1;

/*
Проглатываем исключение
*/

public class Solution {

    public static String errorMessage = "не повезло";

    public static void main(String[] args) {
        try {
            generateLuckyNumber();
        } catch (Exception ex) {
            System.out.println(errorMessage);
        }
    }

    static void generateLuckyNumber() throws Exception {
        int luckyNumber = (int) (Math.random() * 100);
        if (luckyNumber == 13) {
            throw new Exception();
        }
        System.out.println("твое счастливое число: " + luckyNumber);
    }
}

/*
Перехвати исключение в методе main, чтобы программа компилировалась.
При возникновении исключения нужно вывести на экран строку errorMessage.

Требования:
•	В методе main нужно добавить блок try-catch.
•	Метод main не должен бросать проверяемые исключения.
•	Метод main должен вызывать метод generateLuckyNumber.
•	Метод generateLuckyNumber изменять нельзя.
•	При возникновении исключения в методе main нужно вывести на экран строку errorMessage.
 */