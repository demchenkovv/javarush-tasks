package com.github.demchenkovv.javacore.level08.lecture03.task5;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/*
Сортировка байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        try (BufferedReader bReader = new BufferedReader(new InputStreamReader(System.in));
             FileInputStream fileInputStream = new FileInputStream(bReader.readLine())) {

            int[] arrays = new int[256];
            while (fileInputStream.available() > 0) {
                arrays[fileInputStream.read()]++;
            }
            for (int i = 0; i < arrays.length; i++) {
                if (arrays[i] != 0) {
                    System.out.print(i + " ");
                }
            }

//            // Решение проще, но более ресурсоемкое
//            Set<Integer> set = new TreeSet<>();
//            while (fileInputStream.available() > 0) {
//                set.add(fileInputStream.read());
//            }
//            set.forEach(x -> System.out.print(x + " "));
        }
    }
}
