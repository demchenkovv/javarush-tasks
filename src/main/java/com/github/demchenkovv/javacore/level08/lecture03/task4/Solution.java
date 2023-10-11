package com.github.demchenkovv.javacore.level08.lecture03.task4;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Самые редкие байты
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        try (BufferedReader bReader = new BufferedReader(new InputStreamReader(System.in));
             FileInputStream fis = new FileInputStream(bReader.readLine())) {
            int[] byteCountArray = new int[256];
            while (fis.available() > 0) {
                byteCountArray[fis.read()] += 1;
            }
            int numberOfRepetitions = Arrays.stream(byteCountArray).filter(x -> x != 0).min().getAsInt();
            List<Integer> result = new ArrayList<>();
            for (int i = 0; i < byteCountArray.length; i++) {
                if (byteCountArray[i] == numberOfRepetitions) {
                    result.add(i);
                }
            }
            result.forEach(x -> System.out.print(x + " "));
        }
    }
}