package com.github.demchenkovv.level18.lecture06.task3;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toMap;

/*
Из потока данных — в map
*/

public class Solution {

    public static void main(String[] args) {
        var stringStream = Stream.of("JavaRush", "CodeGym", "Amigo", "Elly", "Kim", "Risha");

        getMap(stringStream).forEach((s, i) -> System.out.println(s + " - " + i));
    }

    public static Map<String, Integer> getMap(Stream<String> stringStream) {
        return stringStream
                .collect(Collectors.toMap(String::valueOf, String::length));
    }
}

/*
Необходимо, чтобы метод getMap(Stream<String>) преобразовывал входящий поток строк в карту (map),
ключом которой является сама строка, а значением — её длина.
Реализуй его, используя метод collect() объекта типа Stream<String>. В качестве параметра передай
нужный коллектор (объект типа Collector<Map<String, Integer>>). Такой объект можно получить, вызвав
статический метод toMap() класса Collectors.

Метод main() не принимает участие в тестировании.

Требования:
•	В публичном статическом методе getMap(Stream<String>) нужно вызывать статический метод toMap() класса Collectors.
•	Метод getMap(Stream<String>) нужно реализовать согласно условию.
 */
