package com.github.demchenkovv.javasyntaxzero.level18.lecture05.task3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

/*
Как быть, если в списке есть элемент null
*/

public class Solution {

    public static void main(String[] args) {
        List<String> strings = new ArrayList<>();
        Collections.addAll(strings,
                "first", "second", null, "fourth", "fifth");

        printList(strings);
    }

    public static void printList(List<String> list) {
        String text = "Этот элемент равен null";
        list.stream()
                .map(Optional::ofNullable)
                .forEach(s -> System.out.println(s.orElse(text)));
    }
}

/*
Задача метода printList(List<String>) — вывести в консоли все элементы списка,
полученного как параметр, в том же порядке. Но есть один нюанс. В списке могут
быть элементы, равные null.

Твоя задача — вывести все элементы списка в консоли, а вместо null — фразу:
Этот элемент равен null
В методе printList(List<String>) нельзя использовать циклы, оператор if/else и
тернарный оператор.
Для проверки равенства строки на null и замены её на другую строку есть метод
orElse объекта типа Optional<String>.

Метод main() не принимает участие в тестировании.

Требования:
В публичном статическом методе printList(List<String>) нужно вызывать метод orElse() объекта типа Optional<String>
Метод printList(List<String>) нужно реализовать согласно условию.
В методе printList(List<String>) не нужно использовать циклы, оператор if/else и тернарный оператор.
 */