package com.github.demchenkovv.multithreading.level10.lecture02.task3010;

/*
Минимальное допустимое основание системы счисления
*/

public class Solution {
    public static void main(String[] args) {
//        //for testing
//        args = new String[]{"00"};
//        args = new String[]{"12AS08z"};
//        args = new String[]{"12AS08Z/"};

        if (args.length == 0) {
            System.out.println("incorrect");
            return;
        }

        String inputLine = args[0];

        // проверка на длину, буквы, числа
        if (inputLine.length() > 255 || !inputLine.matches("[\\w\\d]+")) {
            System.out.println("incorrect");
            return;
        }

        int radix = 2;
        while (radix != 37) {
            try {
                long number = Long.parseLong(inputLine, radix);
                System.out.println(radix);
                return;
            } catch (Exception exception) {
                radix++;
            }
        }
        System.out.println("incorrect");
    }
}