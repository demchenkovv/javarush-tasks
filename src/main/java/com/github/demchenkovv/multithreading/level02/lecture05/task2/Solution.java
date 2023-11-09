package com.github.demchenkovv.multithreading.level02.lecture05.task2;

/* 
Найти подстроку
*/

public class Solution {
    public static void main(String[] args) throws TooShortStringException {
        System.out.println(getPartOfString("JavaRush - лучший сервис обучения Java."));
        System.out.println(getPartOfString("Амиго и Диего лучшие друзья!"));
        System.out.println(getPartOfString(null));
    }

    public static String getPartOfString(String string) throws TooShortStringException {
        StringBuilder result = new StringBuilder();
        try {
            String[] splitLine = string.split(" ");
            for (int i = 1; i < 5; i++) {
                result.append(splitLine[i]);
                result.append(" ");
            }
        } catch (IndexOutOfBoundsException | NullPointerException ex) {
            throw new TooShortStringException();
        }
        return result.toString().trim();
    }

    public static class TooShortStringException extends RuntimeException {
    }
}
