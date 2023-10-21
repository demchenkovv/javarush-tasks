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
        args = new String[]{"C:\\Users\\HOME\\IdeaProjects\\JavaRush\\lectures\\src\\main\\java\\com\\github\\demchenkovv\\javacore\\level09\\lecture11\\task4\\input.txt"};

        Map<String, Double> map = new TreeMap<>();
        try (BufferedReader fileReader = new BufferedReader(new FileReader(args[0]))) {
            while (fileReader.ready()) {
                String[] split = fileReader.readLine().split(" ");
                String lastname = split[0];
                Double value = Double.parseDouble(split[1]);

                // Вариант 1
                map.put(lastname, map.getOrDefault(lastname, 0.0 + value));

//                // Вариант 2
//                map.compute(lastname, (w, p) -> p != null ? p + value : value);

//                // Вариант 3
//                map.merge(lastname, value, (v, newV) -> v + newV);

//                // Вариант 4
//                if (map.containsKey(lastname)) {
//                    map.put(lastname, map.get(lastname) + value);
//                } else {
//                    map.put(lastname, value);
//                }
            }
        }
        for (Map.Entry<String, Double> el : map.entrySet()) {
            System.out.println(el.getKey() + " " + el.getValue());
        }
    }
}

