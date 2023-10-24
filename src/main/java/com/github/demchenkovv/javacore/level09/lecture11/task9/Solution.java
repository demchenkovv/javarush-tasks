package com.github.demchenkovv.javacore.level09.lecture11.task9;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* 
Замена чисел
*/

public class Solution {
    public static Map<Integer, String> map = new HashMap<Integer, String>();

    static {
        map.put(0, "ноль");
        map.put(1, "один");
        map.put(2, "два");
        map.put(3, "три");
        map.put(4, "четыре");
        map.put(5, "пять");
        map.put(6, "шесть");
        map.put(7, "семь");
        map.put(8, "восемь");
        map.put(9, "девять");
        map.put(10, "десять");
        map.put(11, "одиннадцать");
        map.put(12, "двенадцать");
    }

    public static void main(String[] args) throws IOException {
//        String inputFilePath = "src/main/java/com/github/demchenkovv/javacore/level09/lecture11/task9/input.txt";
        String inputFilePath;
        try (BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in))) {
            inputFilePath = consoleReader.readLine();
        }
        try (BufferedReader fileReader = new BufferedReader(new FileReader(inputFilePath))) {
            while (fileReader.ready()) {
                String str = fileReader.readLine();
                Pattern pattern = Pattern.compile("\\b(\\d|1[0-2])\\b");
                Matcher matcher = pattern.matcher(str);
                while (matcher.find()) {
                    String match = matcher.group();
                    Integer parsedInt = Integer.parseInt(match);
                    str = str.replaceAll("\\b" + match + "\\b", map.get(parsedInt));
                }
                System.out.println(str);
            }
        }
    }
}
