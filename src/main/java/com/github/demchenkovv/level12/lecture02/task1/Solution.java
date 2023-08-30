package com.github.demchenkovv.level12.lecture02.task1;

/*
Метод деления
*/

public class Solution {

    public static void main(String[] args) {
        divide(1, 0);
        divide(-1, 0);
        divide(0, 0);
        divide(100, 20);
        divide(200, 20);
    }

    public static void divide(double a, double b) {
        //напишите тут ваш код
        System.out.println(a / b);

        // Но можно и так :)
//        if (a > 0 && b == 0) System.out.println(Double.POSITIVE_INFINITY);
//        else if (a < 0 && b == 0) System.out.println(Double.NEGATIVE_INFINITY);
//        else if (a == 0 && b == 0) System.out.println(Double.NaN);
//        else System.out.println(a / b);
    }
}
