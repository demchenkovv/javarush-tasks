package com.github.demchenkovv.javasyntaxzero.level18.lecture03.task3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.stream.Stream;

/*
Без повторов
*/

public class Solution {

    public static void main(String[] args) {
        var words = new ArrayList<String>();
        Collections.addAll(words, "чтобы", "стать", "программистом", "нужно", "программировать",
                "а", "чтобы", "программировать", "нужно", "учиться");

        Stream<String> distinctWords = getDistinctWords(words);
        distinctWords.forEach(System.out::println);
    }

    public static Stream<String> getDistinctWords(ArrayList<String> words) {
        return words.stream()
                .distinct();
    }
}

/*
Метод getDistinct(ArrayList<String>) получает список слов, в котором содержатся повторы.
Твоя задача — реализовать этот метод так, чтобы он возвращал поток слов без повторов
(каждое слово — по одному разу).
В этом тебе поможет метод distinct() объекта типа Stream<String>.

Метод main() не принимает участие в тестировании.

Требования:
•	В публичном статическом методе getDistinct(ArrayList<String>) нужно вызывать метод distinct()
объекта типа Stream<String>.
•	Нужно, чтобы метод getDistinct(ArrayList<String>) возвращал поток слов без повторов.
 */