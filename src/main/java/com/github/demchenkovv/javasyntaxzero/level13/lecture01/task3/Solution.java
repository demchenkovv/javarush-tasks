package com.github.demchenkovv.javasyntaxzero.level13.lecture01.task3;

/*
Найти и обезвредить
*/

import java.util.ArrayList;
import java.util.Iterator;

public class Solution {

    public static void main(String[] args) {
        ArrayList<String> words = new ArrayList<>();
        words.add("Hello world!");
        words.add("Amigo");
        words.add("Elly");
        words.add("Kerry");
        words.add("Bug");
        words.add("bug");
        words.add("Easy ug");
        words.add("Risha");

        ArrayList<String> copyWordsFirst = new ArrayList<>(words);
        ArrayList<String> copyWordsSecond = new ArrayList<>(words);
        ArrayList<String> copyWordsThird = new ArrayList<>(words);

        removeBugWithFor(copyWordsFirst);
        removeBugWithWhile(copyWordsSecond);
        removeBugWithCopy(copyWordsThird);

        copyWordsFirst.forEach(System.out::println);
        String line = "_________________________";
        System.out.println(line);
        copyWordsSecond.forEach(System.out::println);
        System.out.println(line);
        copyWordsThird.forEach(System.out::println);
        System.out.println(line);
    }

    public static void removeBugWithFor(ArrayList<String> list) {
        //напишите тут ваш код
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).equalsIgnoreCase("bug")) {
                list.remove(i);
                i--;
            }
        }
    }

    public static void removeBugWithWhile(ArrayList<String> list) {
        //напишите тут ваш код
        Iterator<String> iterator = list.iterator();    // создаем итератор
        while (iterator.hasNext()) {                    // до тех пор, пока в списке есть элементы
            String currentString = iterator.next();     // получаем следующий элемент
            if (currentString.equalsIgnoreCase("bug")) {
                iterator.remove();                      // удаляем элемент с нужным именем
            }
        }
    }

    public static void removeBugWithCopy(ArrayList<String> list) {
        //напишите тут ваш код
        ArrayList<String> copyList = new ArrayList<>(list);
        for (String s : copyList) {
            if (s.equalsIgnoreCase("bug"))
                list.remove(s);
        }
    }
}

/*
В классе Solution объявлены методы, которые тебе нужно реализовать следующим образом:

removeBugWithFor(ArrayList<String>) - должен удалить строку из списка, если она содержит слово bug, используя цикл for и счетчик.
removeBugWithWhile(ArrayList<String>) - должен удалить строку из списка, если она содержит слово bug, используя цикл while и метод iterator().
removeBugWithCopy(ArrayList<String>) - должен удалить строку из списка, если она содержит слово bug, используя цикл for-each и копию списка.
В слове bug может быть разный регистр букв (BUg, BuG, и т.д.).
Метод main реализован для вашего кода и не участвует в проверке.
Требования:
•	В классе Solution должен быть публичный статический метод removeBugWithFor(ArrayList<String>) с типом возвращаемого значения void.
•	В классе Solution должен быть публичный статический метод removeBugWithWhile(ArrayList<String>) с типом возвращаемого значения void.
•	В классе Solution должен быть публичный статический метод removeBugWithCopy(ArrayList<String>) с типом возвращаемого значения void.
•	Метод removeBugWithFor(ArrayList<String>) должен работать согласно условию.
•	Метод removeBugWithWhile(ArrayList<String>) должен работать согласно условию.
•	Метод removeBugWithCopy(ArrayList<String>) должен работать согласно услови
 */