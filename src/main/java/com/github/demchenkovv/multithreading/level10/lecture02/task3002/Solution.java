package com.github.demchenkovv.multithreading.level10.lecture02.task3002;

/* 
Осваиваем методы класса Integer
*/

public class Solution {

    public static void main(String[] args) {
        System.out.println(convertToDecimalSystem("0x16")); //22
        System.out.println(convertToDecimalSystem("012"));  //10
        System.out.println(convertToDecimalSystem("0b10")); //2
        System.out.println(convertToDecimalSystem("62"));   //62
    }

    // Метод parseInt(String s, int radix) возвращает целое (десятичное) число,
    // разбирая строку s системы счисления radix.
    // 16-ная, 8-ная, 2-ная системы счисления содержат префиксы, которое указывает
    // на систему счисления переданного числа. При парсинге префикс надо отбросить.
    public static String convertToDecimalSystem(String s) {
        int argument;
        if (s.startsWith("0x")) {
            argument = Integer.parseInt(s.substring(2), 16);
        } else if (s.startsWith("0b")) {
            argument = Integer.parseInt(s.substring(2), 2);
        } else if (s.startsWith("0") && s.length() >= 2) {
            argument = Integer.parseInt(s, 8);
        } else {
            argument = Integer.parseInt(s);
        }
        return Integer.toString(argument);
    }
}
