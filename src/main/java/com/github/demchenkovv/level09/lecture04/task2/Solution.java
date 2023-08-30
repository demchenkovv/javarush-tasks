package com.github.demchenkovv.level09.lecture04.task2;

/*
Поиск в строке
*/

public class Solution {
    public static void main(String[] args) {
        String string = "Чтобы стать программистом, нужно писать код. Чтобы писать код, нужно учиться. Чтобы учиться, нужно желание.";
        String word = "код";
        int indexFromFirstWord = getIndexFromFirstWord(string, word);
        int indexFromLastWord = getIndexFromLastWord(string, word);
        System.out.println("Индекс первого символа первого слова \"" + word + "\" равен - " + indexFromFirstWord);
        System.out.println("Индекс первого символа последнего слова \"" + word + "\" равен - " + indexFromLastWord);
    }

    public static int getIndexFromFirstWord(String string, String word) {
        return string.indexOf(word);
    }

    public static int getIndexFromLastWord(String string, String word) {
        return string.lastIndexOf(word);
    }
}

/*
Метод getIndexFromFirstWord(String, String) и метод getIndexFromLastWord(String, String) принимают строку и слово.
Нужно, чтобы метод getIndexFromFirstWord(String, String) вернул индекс первого символа первого слова (второй параметр метода) в строке (первый параметр метода). А метод getIndexFromLastWord(String, String) вернул индекс первого символа последнего слова (второй параметр метода) в строке (первый параметр метода).

Пример:
строка — "Чтобы стать программистом, нужно писать код. Чтобы писать код, нужно учиться. Чтобы учиться, нужно желание."
слово — "код"

метод getIndexFromFirstWord(строка, слово) должен вернуть 40
метод getIndexFromLastWord(строка, слово) должен вернуть 58
Метод main() не принимает участия в тестировании.

Требования:
•	Нужно вывести на экран индекс первого символа первого слова (второй параметр метода) в строке (первый параметр метода).
•	Нужно вывести на экран индекс первого символа последнего слова (второй параметр метода) в строке (первый параметр метода).
 */