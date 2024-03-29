package com.github.demchenkovv.javasyntaxzero.level18.lecture06.task4;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.joining;

/*
Из потока данных — в строку
*/

public class Solution {

    public static void main(String[] args) {
        var stringStream = Stream.of("To", "be", "a", "programmer", "you", "need", "to", "code");

        System.out.println(getString(stringStream));
    }

    public static String getString(Stream<String> stringStream) {
        return stringStream
                .collect(Collectors.joining(" ")); // разделить пробелами
//                .collect(Collectors.joining(" ", "{", "}")); // разделить пробелами, результат взять в фигурные скобки
    }
}

/*
Необходимо, чтобы метод getString(Stream<String>) преобразовывал входящий поток строк в строку,
слова в которой нужно разделить пробелом. Порядок слов в строке должен соответствовать порядку
элементов в потоке.
Реализуй его, используя метод collect() объекта типа Stream<String>. В качестве параметра передай
нужный коллектор (объект типа Collector<String>). Такой объект можно получить, вызвав статический
метод joining() класса Collectors.

Метод main() не принимает участие в тестировании.

Требования:
•	В публичном статическом методе getString(Stream<String>) нужно вызывать статический метод
joining() класса Collectors.
•	Метод getString(Stream<String>) нужно реализовать согласно условию.
 */