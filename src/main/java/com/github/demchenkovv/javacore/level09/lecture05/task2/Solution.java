package com.github.demchenkovv.javacore.level09.lecture05.task2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Pattern;

/*
Считаем слово
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        String inputFile;
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            inputFile = reader.readLine();
        }
        long sumWords = 0;
        Pattern pattern = Pattern.compile("world");
        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile))) {
            while (reader.ready()) {
                String currentLine = reader.readLine();
                sumWords += pattern.matcher(currentLine).results().count();
            }
        }
        System.out.print(sumWords);
    }
}
