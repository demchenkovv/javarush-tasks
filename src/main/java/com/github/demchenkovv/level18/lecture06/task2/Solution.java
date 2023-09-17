package com.github.demchenkovv.level18.lecture06.task2;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/*
Из потока данных во множество
*/

public class Solution {

    public static void main(String[] args) {
        var stringStream = Stream.of("JavaRush", "CodeGym", "Amigo", "Elly", "Kim", "Risha");

        getFilteredStrings(stringStream).forEach(System.out::println);
    }

    public static Set<String> getFilteredStrings(Stream<String> stringStream) {
        return stringStream
                .filter(str -> str.length() > 6)
                .collect(Collectors.toSet());
    }
}

/*
Необходимо, чтобы метод getFilteredStrings(Stream<String>) преобразовывал входящий поток строк во
множество строк, длина которых больше шести символов.
Реализуй его, используя метод collect() объекта типа Stream<String>. В качестве параметра передай
нужный коллектор (объект типа Collector<Set<String>>). Такой объект можно получить, вызвав
статический метод toSet() класса Collectors.

Метод main() не принимает участие в тестировании.

Требования:
•	В публичном статическом методе getFilteredStrings(Stream<String>) нужно вызывать статический
метод toSet() класса Collectors.
•	Метод getFilteredStrings(Stream<String>) нужно реализовать согласно условию.
 */