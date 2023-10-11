package com.github.demchenkovv.javacore.level08.lecture03.task3;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
Самые частые байты
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        Map<Integer, Integer> map = new HashMap<>();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             FileInputStream fileInputStream = new FileInputStream(reader.readLine())) {
            while (fileInputStream.available() > 0) {
                int b = fileInputStream.read();
                if (!map.containsKey(b)) {
                    map.put(b, 1);
                } else {
                    map.put(b, map.get(b) + 1);
                }
            }
            int maxValue = map.values().stream().max(Integer::compare).orElse(1);
            map.entrySet().stream()
                    .filter(entry -> entry.getValue() == maxValue)
                    .forEach(entry -> System.out.print(entry.getKey() + " "));
        }
    }
}

//// Можно так: советую запомнить функцию merge - очень помогает увеличивать счетчик для чего-то, при этом неважно, есть ли оно или нет.
//
// Map <Integer, Integer> map = new HashMap<>();
//        int max = 0;
//        while (fileInputStream.available()>0) {
//            int current = fileInputStream.read();
//            map.merge(current, 1, Integer::sum);
//            max = Math.max(map.get(current),max);
//        }
//        for (Map.Entry <Integer,Integer> en : map.entrySet()) {
//            if (en.getValue() == max) System.out.print(en.getKey() + " ");
//        }


//// Альтернативное решение от JavaRush (очень понравилось)
//public class Solution {
//    public static void main(String[] args) throws Exception {
//        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//        String fileName = reader.readLine();
//
//        // 1 байт = 2^8 = 256 бит - [0..255] именно такое максимальное число можем получить при чтении read() из потока.
//        int[] byteCountArray = new int[256];
//        try (FileInputStream fileInputStream = new FileInputStream(fileName)) {
//            while (fileInputStream.available() > 0) {
//                byteCountArray[fileInputStream.read()] += 1; // индекс (байт) выступает как ключ в мапе
//            }
//        }
//        int maxCount = 0;
//        for (int byteCount : byteCountArray) {
//            if (byteCount > maxCount) maxCount = byteCount;
//        }
//        ArrayList<Integer> resultList = new ArrayList<>();
//        for (int i = 0; i < byteCountArray.length; i++) {
//            if (byteCountArray[i] == maxCount) resultList.add(i);
//        }
//        for (Integer resultItem : resultList) System.out.print(resultItem + " ");
//    }
//}