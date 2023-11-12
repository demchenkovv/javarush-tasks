package com.github.demchenkovv.multithreading.level02.lecture13.task3;

/* 
Проверка номера телефона
*/

public class Solution {

    public static void main(String[] args) {
        System.out.println(checkTelNumber(null)); //false

        System.out.println(checkTelNumber("+380501234567")); //true
        System.out.println(checkTelNumber("+38(050)1234567")); //true
        System.out.println(checkTelNumber("(050)1234567")); //true
        System.out.println(checkTelNumber("0(501)234567")); //true

        System.out.println(checkTelNumber("+38)050(1234567")); //false
        System.out.println(checkTelNumber("+38(050)123-45-67")); //false
        System.out.println(checkTelNumber("050ххх4567")); //false
        System.out.println(checkTelNumber("050123456")); //false
        System.out.println(checkTelNumber("(0)501234567")); //false

        System.out.println(checkTelNumber("+111234567890")); //true

        System.out.println(checkTelNumber("1234567890")); //true

        System.out.println(checkTelNumber("(234)5678890")); //true
        System.out.println(checkTelNumber("1(234)567890")); //true
        System.out.println(checkTelNumber("12(345)67890")); //true
        System.out.println(checkTelNumber("123(456)7890")); //true
        System.out.println(checkTelNumber("1234(567)890")); //true
        System.out.println(checkTelNumber("12345(678)90")); //true
        System.out.println(checkTelNumber("123456(789)0")); //true

        System.out.println(checkTelNumber("+(123)456789012")); //true
        System.out.println(checkTelNumber("+1(234)56789012")); //true
        System.out.println(checkTelNumber("+12(345)6789012")); //true
        System.out.println(checkTelNumber("+123(456)789012")); //true
        System.out.println(checkTelNumber("+1234(567)89012")); //true
        System.out.println(checkTelNumber("+12345(678)9012")); //true
        System.out.println(checkTelNumber("+123456(789)012")); //true
        System.out.println(checkTelNumber("+1234567(890)12")); //true
        System.out.println(checkTelNumber("+12345678(901)2")); //true
    }

    public static boolean checkTelNumber(String telNumber) {
        if (telNumber == null || telNumber.equals("")) {
            return false;
        }

        int telNumberLength = telNumber.length();

        if (telNumberLength == 13 || telNumberLength == 15) {
            return telNumber.matches("^\\+((\\d+)?(\\(\\d{3}\\))?)\\d+$");
        } else if (telNumberLength == 12 || telNumberLength == 10) {
            return telNumber.matches("^(\\d+)?(\\([0-9]{3}\\))?\\d+$");
        }

        return false;
    }

//    // Решение JR
//    public static boolean checkTelNumber(String telNumber) {
//        if (telNumber == null) {
//            return false;
//        }
//        return (telNumber.matches("^\\+(\\d[()]?){12}$") || telNumber.matches("^([()]?\\d){10}$"))
//               && telNumber.matches("^(\\+)?(\\d+)?(\\(\\d{3}\\))?\\d+$");
//    }
}