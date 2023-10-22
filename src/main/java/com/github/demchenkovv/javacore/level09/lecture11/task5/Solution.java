package com.github.demchenkovv.javacore.level09.lecture11.task5;

/*
Самый богатый
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static void main(String[] args) throws IOException {
        args = new String[]{"src/main/java/com/github/demchenkovv/javacore/level09/lecture11/task5/input.txt"};

        Map<String, Double> map = new HashMap<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(args[0]))) {
            while (reader.ready()) {
                String[] strip = reader.readLine().split(" ");
                String name = strip[0];
                double value = Double.parseDouble(strip[1]);
                map.merge(name, value, (currentValue, newValue) -> currentValue + newValue);
            }
        }
        double maxValue = map.values().stream().max(Double::compareTo).get();
        map.forEach((key, value) -> {
            if (value == maxValue) {
                System.out.println(key);
            }
        });

//        map.entrySet().stream()
//                .filter(e -> e.getValue() == maxValue)
//                .map(Map.Entry::getKey)
//                .forEach(System.out::println);
    }
}
