package com.github.demchenkovv.javasyntaxzero.level13.lecture01.task2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;

/*
Переводим итератор в цикл for-each
*/
public class Solution {

    public static void printList(ArrayList<String> words) {
//        words.forEach(System.out::println); // в одну строку с использованием лямбда-выражения
        for (String s : words)
            System.out.println(s);
    }

    public static void printHashSet(HashSet<String> words) {
//        words.forEach(System.out::println); // // в одну строку с использованием лямбда-выражения
        for (String s : words)
            System.out.println(s);
    }

    public static void main(String[] args) {
        String[] wordsArray = "Думаю, это будет новой фичей. Только не говорите никому, что она возникла случайно.".split(" ");
        ArrayList<String> wordsList = new ArrayList<>(Arrays.asList(wordsArray));
        HashSet<String> wordsHashSet = new HashSet<>(wordsList);
        printList(wordsList);
        System.out.println("__________________________________");
        printHashSet(wordsHashSet);
    }
}

/*
В классе Solution есть методы printHashSet(HashSet<String>) и printList(ArrayList<String>),
которые выводят все элементы из переданных коллекций — списка и множества — с новой строки.
Твоя задача переписать методы на использование цикла for-each.
Метод main не участвует в проверке.

Требования:
•	В классе Solution должен быть публичный статический метод printHashSet(HashSet<String>) с типом возвращаемого значения void.
•	В классе Solution должен быть публичный статический метод printList(ArrayList<String>) с типом возвращаемого значения void.
•	Метод printHashSet(HashSet<String>) должен выводить все элементы с помощью цикла for-each.
•	Метод printList(ArrayList<String>) должен выводить все элементы с помощью цикла for-each.
 */