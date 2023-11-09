package com.github.demchenkovv.multithreading.level02.lecture05.task3;

/* 
Между табуляциями
*/

public class Solution {
    public static String getPartOfString(String string) throws TooShortStringException {
        String result = "";
        try {
            int firstTab = string.indexOf("\t");
            int secondTab = string.indexOf("\t", firstTab + 1);
            result = string.substring(firstTab + 1, secondTab);
        } catch (Exception ex) {
            throw new TooShortStringException();
        }
        return result;
    }

    public static class TooShortStringException extends Exception {
    }

    public static void main(String[] args) throws TooShortStringException {
        System.out.println(getPartOfString("\tJavaRush - лучший сервис \tобучения Java\t."));
        System.out.println(getPartOfString("\tJavaRush - лучший сервис обучения Java."));
    }
}
