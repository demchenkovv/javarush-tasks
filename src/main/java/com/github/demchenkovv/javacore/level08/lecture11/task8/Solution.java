package com.github.demchenkovv.javacore.level08.lecture11.task8;

/*
Округление чисел
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        String inputFile;
        String outputFile;
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            inputFile = reader.readLine();
            outputFile = reader.readLine();
        }

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(inputFile));
             BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(outputFile))) {
            String[] splitLines = bufferedReader.readLine().split(" ");
            for (String s : splitLines) {
                double number = Double.parseDouble(s);
                long roundedNumber = Math.round(number);
                bufferedWriter.write(roundedNumber + " ");
            }
        }
    }
}
