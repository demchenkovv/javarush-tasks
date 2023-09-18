package com.github.demchenkovv.javasyntaxzero.level13.lecture01.task1;

/*
Выводим в консоли элементы множества
*/

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;

public class Solution {

    public static void print(HashSet<String> words) {
        //напишите тут ваш код
        Iterator<String> iterator = words.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    public static void main(String[] args) {
        HashSet<String> words = new HashSet<>(
                Arrays.asList("Программированию обычно учат на примерах."
                        .split(" ")));
        print(words);
    }
}

/*
В классе Solution есть метод print(HashSet<String>),
который должен выводить в консоли все элементы множества, используя iterator().
Метод main не участвует в проверке.

Требования:
•	В классе Solution должен быть публичный статический метод print(HashSet<String>)
с типом возвращаемого значения void.
•	Метод print(HashSet<String>) должен работать согласно условию.
 */