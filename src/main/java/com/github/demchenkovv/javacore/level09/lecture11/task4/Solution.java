package com.github.demchenkovv.javacore.level09.lecture11.task4;

/*
Считаем зарплаты
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        args = new String[]{"src/main/java/com/github/demchenkovv/javacore/level09/lecture11/task4/input.txt"};

        Map<String, Double> map = new TreeMap<>();
        try (BufferedReader fileReader = new BufferedReader(new FileReader(args[0]))) {
            while (fileReader.ready()) {
                String[] split = fileReader.readLine().split(" ");
                String name = split[0];
                double value = Double.parseDouble(split[1]);

                // Вариант 1 - getOrDefault(возвращает значение ключа или значение по умолчанию) + спарсенный value
                map.put(name, map.getOrDefault(name, 0.0) + value);

//                // Вариант 2
//                // Map.compute(K key,BiFunction<? super K, ? super V, ? extends V> remappingFunction)
//                // Для указанного ключа key этот метод устанавливает в качестве value результат выполнения функции remappingFunction
//                map.compute(name, (k, v) -> v != null ? v + value : value);

//                // Вариант 3
//                // Map.merge(K key, V value, BiFunction<? super V, ? super V, ? extends V> remappingFunction)
//                // - Если в вашей Map ключ key не существует, или value для этого ключа равно null — метод добавляет в Map переданную пару key-value.
//                // - Если ключ Key существует и его value != null — метод меняет его value на результат выполнения переданной функции remappingFunction.
//                // - Если remappingFunction возвращает null - key удаляется из коллекции.
//                map.merge(name, value, (currentValue, newValue) -> currentValue + newValue);

//                // Вариант 4
//                if (map.containsKey(name)) {
//                    map.put(name, map.get(name) + value);
//                } else {
//                    map.put(name, value);
//                }
            }
        }
        map.forEach((k, v) -> System.out.println(k + " " + v));
    }
}

