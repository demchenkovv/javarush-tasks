package com.github.demchenkovv.javasyntaxzero.level13.lecture00.task2;

/*
Проверка присутствия
*/

import java.util.Arrays;
import java.util.HashSet;

public class Solution {
    public static HashSet<String> words = new HashSet<>(Arrays
            .asList("Если бы меня попросили выбрать язык на замену Java я бы не выбирал"
                    .split(" ")));

    public static void checkWords(String word) {
        //напишите тут ваш код
        if (words.contains(word))
            System.out.printf("Слово %s есть в множестве\n", word);
        else System.out.printf("Слова %s нет в множестве\n", word);
    }

    public static void main(String[] args) {
        checkWords("JavaScript");
        checkWords("Java");
    }
}

/*
В классе Solution есть метод checkWords(String), который должен проверять наличие переданного слова в множестве words.
Если слово есть, то выводим в консоль:
Слово [переданное слово] есть в множестве
Если нет:
Слова [переданное слово] нет в множестве

Метод main не участвует в проверке.

Пример вывода:
Слово Java есть в множестве

Требования:
•	В классе Solution должно быть публичное статическое поле words типа HashSet<String>.
•	В классе Solution должен быть публичный статический метод checkWords(String) с типом возвращаемого значения void.
•	Метод checkWords(String) должен работать согласно условию.
 */