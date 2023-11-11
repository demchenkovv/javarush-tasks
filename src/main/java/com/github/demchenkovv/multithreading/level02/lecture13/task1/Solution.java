package com.github.demchenkovv.multithreading.level02.lecture13.task1;

/*
StringTokenizer
*/

import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) {
//        getTokens("Good news everyone!", "ne");
        getTokens("level22.lesson13.task01", ".");

    }

    public static String[] getTokens(String query, String delimiter) {
        StringTokenizer stringTokenizer = new StringTokenizer(query, delimiter);
        int countTokens = stringTokenizer.countTokens();
        String[] result = new String[countTokens];
        int count = 0;
        while (count < countTokens) {
            String token = stringTokenizer.nextToken();
            result[count++] = token;
        }
        System.out.println(Arrays.toString(result));
        return result;
    }
}
