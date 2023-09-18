package com.github.demchenkovv.javasyntaxzero.level09.lecture01.task4;

/*
Двоично-шестнадцатеричный конвертер
*/

public class Solution {

    public static void main(String[] args) {
        String binaryNumber = "100111010000";
        System.out.println("Двоичное число " + binaryNumber + " равно шестнадцатеричному числу " + toHex(binaryNumber));
        String hexNumber = "9d0";
        System.out.println("Шестнадцатеричное число " + hexNumber + " равно двоичному числу " + toBinary(hexNumber));
    }

    public static String toHex(String binaryNumber) {
        if (binaryNumber == null || binaryNumber.isBlank() || !binaryNumber.matches("[01]+")) return "";

        // Добавляем нули, если строка не кратна 4
        // Каждый разряд шестнадцатеричного числа содержит 4 бита.
        if (binaryNumber.length() % 4 == 1) {
            binaryNumber = "000" + binaryNumber;
        } else if (binaryNumber.length() % 4 == 2) {
            binaryNumber = "00" + binaryNumber;
        } else if (binaryNumber.length() % 4 == 3) {
            binaryNumber = "0" + binaryNumber;
        }

        String result = "";
        while (binaryNumber.length() != 0) {
            String firstFourDigits = binaryNumber.substring(0, 4);
            if (firstFourDigits.equals("0000")) result += "0";
            if (firstFourDigits.equals("0001")) result += "1";
            if (firstFourDigits.equals("0010")) result += "2";
            if (firstFourDigits.equals("0011")) result += "3";
            if (firstFourDigits.equals("0100")) result += "4";
            if (firstFourDigits.equals("0101")) result += "5";
            if (firstFourDigits.equals("0110")) result += "6";
            if (firstFourDigits.equals("0111")) result += "7";
            if (firstFourDigits.equals("1000")) result += "8";
            if (firstFourDigits.equals("1001")) result += "9";
            if (firstFourDigits.equals("1010")) result += "a";
            if (firstFourDigits.equals("1011")) result += "b";
            if (firstFourDigits.equals("1100")) result += "c";
            if (firstFourDigits.equals("1101")) result += "d";
            if (firstFourDigits.equals("1110")) result += "e";
            if (firstFourDigits.equals("1111")) result += "f";
            binaryNumber = binaryNumber.substring(4);
        }
        return result;
    }

    public static String toBinary(String hexNumber) {
        if (hexNumber == null || hexNumber.isBlank() || !hexNumber.matches("[0-9a-f]+")) return "";
        String result = "";
        for (int i = 0; i < hexNumber.length(); i++) {
            char currentChar = hexNumber.charAt(i);
            if (currentChar == '1') result += "0001";
            if (currentChar == '2') result += "0010";
            if (currentChar == '0') result += "0000";
            if (currentChar == '3') result += "0011";
            if (currentChar == '4') result += "0100";
            if (currentChar == '5') result += "0101";
            if (currentChar == '6') result += "0110";
            if (currentChar == '7') result += "0111";
            if (currentChar == '8') result += "1000";
            if (currentChar == '9') result += "1001";
            if (currentChar == 'a') result += "1010";
            if (currentChar == 'b') result += "1011";
            if (currentChar == 'c') result += "1100";
            if (currentChar == 'd') result += "1101";
            if (currentChar == 'e') result += "1110";
            if (currentChar == 'f') result += "1111";
        }
        return result;
    }
}
/*
        // Для перевода двоичного числа в шестнадцатеричное
        // двоичное число нужно разбить на группы по четыре цифры (тетрады).
 */

/*
Публичный статический метод toHex(String) должен переводить строковое представление двоичного числа, полученное в качестве входящего параметра, из двоичной системы счисления в шестнадцатеричную и возвращать его строковое представление. А публичный статический метод toBinary(String) наоборот — из строкового представления шестнадцатеричного числа в строковое представление двоичного числа.

Методы работают только с не пустыми строками.
Если входящий параметр — пустая строка или null, то оба метода возвращают пустую строку.
Если входящий параметр метода toHex(String) содержит любой символ, кроме 0 или 1, то метод возвращает пустую строку.
Если входящий параметр метода toBinary(String) содержит любой символ, кроме цифр от 0 до 9 или латинскую букву от a до f (в нижнем регистре), то метод возвращает пустую строку.

Твоя задача — реализовать эти методы.

Один из алгоритмов перевода строкового представления двоичного числа в строковое представление шестнадцатеричного числа следующий:

Проверяем длину строки, полученной входящим параметром. Она должна быть кратна 4.
Если это не так, то добавляем нужное количество 0 в начало строки.
Берем каждые четыре символа (бита) и проверяем, какому символу шестнадцатеричной кодировки он соответствует.
Например:

двоичное представление — "100111010000", где "1001" — "9", "1101" — "d", "0000" — "0",
шестнадцатеричное представление — "9d0".
Один из алгоритмов перевода строкового представления шестнадцатеричного числа в строковое представление двоичного числа следующий:
Берем каждый символ и проверяем какому двоичному числу (4 бита) он соответствует.

Например:

шестнадцатеричное представление — "9d0", где "9" — "1001", "d" — "1101", "0" — "0000",
двоичное представление — "100111010000".
Метод main() не принимает участие в тестировании.

Требования:
•	Нужно, чтобы метод toHex(String) был реализован согласно условию.
•	Нужно, чтобы метод toBinary(String) был реализован согласно условию.
•	Методы Integer.toBinaryString(int) и Long.toBinaryString(int) использовать нельзя.
•	Методы Integer.toHexString(int) и Long.toHexString(int) использовать нельзя.
•	Методы Integer.parseInt(String, int) и Long.parseLong(String, int) использовать нельзя.
•	Методы Integer.toString(int, int) и Long.toString(long, int) использовать нельзя.
•	Объект типа BigInteger использовать нельзя.
•	Объект типа BigDecimal использовать нельзя.
 */