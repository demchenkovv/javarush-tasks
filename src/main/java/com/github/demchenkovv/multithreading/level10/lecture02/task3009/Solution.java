package com.github.demchenkovv.multithreading.level10.lecture02.task3009;

/*
Палиндром?
*/

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public static void main(String[] args) {
        System.out.println(getRadix("112"));        //expected output: [3, 27, 13, 15]
        System.out.println(getRadix("123"));        //expected output: [6]
        System.out.println(getRadix("5321"));       //expected output: []
        System.out.println(getRadix("1A"));         //expected output: []
    }

    private static Set<Integer> getRadix(String number) {
        Set<Integer> result = new HashSet<>();
        final int startNumSystem = 2;
        try {
            int argument = Integer.parseInt(number, 10);
            StringBuilder reverseValue;
            for (int i = startNumSystem; i <= 36; i++) {
                String current = Integer.toString(argument, i);
                reverseValue = new StringBuilder(current).reverse();
                if (reverseValue.toString().equals(current)) {
                    result.add(i);
                }
            }
        } catch (NumberFormatException ignored) {

        }

        return result;
    }
}