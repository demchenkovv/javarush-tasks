package com.github.demchenkovv.level09.lecture03;

/*
Методы класса String
У класса String очень много методов: одних только конструкторов у него 18 штук!
Поэтому ниже мы приведем только самые основные из них:

Методы	                        Описание

int length()                    Возвращает количество символов в строке
boolean isEmpty()               Проверяет, что строка == пустая строка
boolean isBlank()               Проверяет, что в строке — только whitespace-символы: пробел, tab, enter и т.п.
char charAt(int index)          Возвращает символ, который стоит на index-позиции в строке.
char[] toCharArray()            Возвращает массив символов (копию), из которых состоит строка
byte[] getBytes()               Преобразует строку в набор байт и возвращает массив байт.
String[] split(String regex)    Разделяет строку на несколько подстрок.
String join(CharSequence delimiter, elements) Склеивает вместе несколько подстрок
String intern()                 Помещает строку в пул StringPool.
 */

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {

        // charArray(); // использование массива char’ов
        // splitAndJoin(); // использование методов split() и join()
        // replaceCharOldCharNew(); // использование метода replace(char oldChar, char newChar)
    }

    /**
     * Решение 1 — использование массива char’ов
     */
    public static void charArray() {
        Scanner console = new Scanner(System.in);
        String path = console.nextLine();

        char[] chars = path.toCharArray();
        for (int i = 0; i < chars.length; i++)
            if (chars[i] == '/')
                chars[i] = '\\';

        String result = new String(chars);
        System.out.println(result);
    }

    /** Решение 2 — использование методов split() и join(): */
    public static void splitAndJoin() {
        Scanner console = new Scanner(System.in);
        String path = console.nextLine();
        String[] array = path.split("/");
        String result = String.join("\\", array);
        System.out.println(result);
    }

    /** Решение 3 — использование метода replace(char oldChar, char newChar): */
    public static void replaceCharOldCharNew() {
        Scanner console = new Scanner(System.in);
        String path = console.nextLine();
        String result = path.replace('/', '\\');
        System.out.println(result);
    }
}
