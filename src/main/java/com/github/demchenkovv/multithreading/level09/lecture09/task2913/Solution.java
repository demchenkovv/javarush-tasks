package com.github.demchenkovv.multithreading.level09.lecture09.task2913;

import java.util.Random;

/* 
Замена рекурсии
*/

public class Solution {
    private static int numberA;
    private static int numberB;

//    public static String recursion(int a, int b) {
//        if (a > b) {
//            return a + " " + recursion(a - 1, b);
//        } else {
//            if (a == b) {
//                return Integer.toString(a);
//            }
//            return a + " " + recursion(a + 1, b);
//        }
//    }

    public static String getAllNumbersBetween(int a, int b) {
        StringBuilder sb = new StringBuilder();
        if (a < b) {
            for (int i = a; i <= b; i++) {
                sb.append(i);
                sb.append(" ");
            }
        } else {
            for (int i = a; i >= b; i--) {
                sb.append(i);
                sb.append(" ");
            }
        }
        return sb.toString().trim();
    }

    // Вариант через массив (при необходимости манипуляции с числами)
//    public static String getAllNumbersBetween(int a, int b) {
//
//        int[] numbers = new int[Math.abs(a - b) + 1];
//
//        int min = a > b ? b : a;
//
//        for (int i = 0; i < numbers.length; i++) {
//            numbers[i] = min;
//            min++;
//        }
//
//        StringBuilder sb = new StringBuilder();
//        if (a < b) {
//            sb.append(numbers[0]);
//            for (int i = 1; i < numbers.length; i++) {
//                sb.append(" ").append(numbers[i]);
//            }
//        } else {
//            sb.append(numbers[numbers.length - 1]);
//            for (int i = numbers.length - 2; i >= 0; i--) {
//                sb.append(" ").append(numbers[i]);
//            }
//        }
//        return sb.toString();
//    }

    public static void main(String[] args) {
        Random random = new Random();
        numberA = random.nextInt(1000);
        numberB = random.nextInt(1000);
        System.out.println(getAllNumbersBetween(numberA, numberB));
        System.out.println(getAllNumbersBetween(numberB, numberA));
//        System.out.println(getAllNumbersBetween(10 , 20));
    }
}