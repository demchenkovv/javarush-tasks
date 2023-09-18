package com.github.demchenkovv.javasyntaxzero.level12.lecture02.task2;

/*
Анализ строк
*/

public class Solution {
    public static void main(String[] args) {
        String string = "Думаю, это будет новой фичей." +
                        "Только не говорите никому, что она возникла случайно.";

        System.out.println("Количество цифр в строке : " + countDigits(string));
        System.out.println("Количество букв в строке : " + countLetters(string));
        System.out.println("Количество пробелов в строке : " + countSpaces(string));
    }

    public static int countDigits(String string) {
        //напишите тут ваш код
        int countDigits = 0;
        for (Character c : string.toCharArray()) {
            if (Character.isDigit(c)) countDigits++;
        }
        return countDigits;
    }

    public static int countLetters(String string) {
        //напишите тут ваш код
        int countLetters = 0;
        for (Character c : string.toCharArray())
            if (Character.isLetter(c)) countLetters++;
        return countLetters;
    }

    public static int countSpaces(String string) {
        //напишите тут ваш код
        int countSpaces = 0;
        for(Character c : string.toCharArray())
            if (Character.isWhitespace(c)) countSpaces++;
        return countSpaces;
    }
}
/*

Реализуй методы countDigits(String), countLetters(String), countSpaces(String),
которые должны возвращать количество цифр, букв и пробелов в строке.
Метод main не принимает участия в проверке.

Требования:
•	Метод countDigits(String) должен возвращать количество цифр в переданной строке.
•	Метод countLetters(String) должен возвращать количество букв в переданной строке.
•	Метод countSpaces(String) должен возвращать количество пробелов в переданной строке.
 */