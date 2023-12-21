package com.github.demchenkovv.multithreading.level10.lecture02.task3001;

/*
Конвертер систем счислений
*/

import java.math.BigInteger;

public class Solution {
    public static void main(String[] args) {
        Number number = new Number(NumberSystemType._10, "6");
        Number result = convertNumberToOtherNumberSystem(number, NumberSystemType._2);
        System.out.println(result);    //expected 110

        number = new Number(NumberSystemType._16, "6df");
        result = convertNumberToOtherNumberSystem(number, NumberSystemType._8);
        System.out.println(result);    //expected 3337

        number = new Number(NumberSystemType._16, "abcdefabcdef");
        result = convertNumberToOtherNumberSystem(number, NumberSystemType._16);
        System.out.println(result);    //expected abcdefabcdef
    }

    public static Number convertNumberToOtherNumberSystem(Number number, NumberSystem expectedNumberSystem) {
        Number result;
        try {
            // Текущие число и система счисления
            String currentDigit = number.getDigit();
            int currentSystem = number.getNumberSystem().getNumberSystemIntValue();

            // У класса BigInteger есть конструктор, который принимает
            // два параметра: число в виде строки и систему счисления
            BigInteger src = new BigInteger(currentDigit, currentSystem);

            // Ожидаемая система счисления
            int newNumberSystem = expectedNumberSystem.getNumberSystemIntValue();

            // Метод toString(int radix) у BigInteger возвращает строку в заданной radix системе счисления
            String convert = src.toString(newNumberSystem);
            result = new Number(expectedNumberSystem, convert);
        } catch (NumberFormatException exception) {
            throw new NumberFormatException();
        }
        return result;
    }
}
