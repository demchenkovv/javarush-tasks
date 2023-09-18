package com.github.demchenkovv.javasyntaxzero.level08.lecture06;

/*
Внеси исправления в метод taskForCondition(), чтобы он выводил в консоли число 30.
Изменять можно только логические операторы: && на & и || на |.

Требования:
•	Нужно, чтобы метод taskForCondition() выводил число 30.
•	В методе taskForCondition() не меняй ничего, кроме логических операторов.
 */
public class Solution {

    public static void main(String[] args) {
        taskForCondition();
    }

    public static void taskForCondition() {
        int number = 15;
        boolean firstCondition = number < 15 & number > 25 & (number += 15) < 25;
        boolean secondCondition = (number | 5) > 12 || (number = number + 2) > 40;
        System.out.println(number);
    }
}

/* исходная задача
public class Solution {

    public static void main(String[] args) {
        taskForCondition();
    }

    public static void taskForCondition() {
        int number = 15;
        boolean firstCondition = number < 15 && number > 25 && (number += 15) < 25;
        boolean secondCondition = (number | 5) > 12 || (number = number + 2) > 40;
        System.out.println(number);
    }
}

 */