package com.github.demchenkovv.javacore.level09.lecture05.task4;

import java.io.*;

/*
Выделяем числа
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        String inputFile;
        String outputFile;
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            inputFile = reader.readLine();
            outputFile = reader.readLine();
        }
        try (BufferedReader fileReader = new BufferedReader(new FileReader(inputFile));
             BufferedWriter fileWriter = new BufferedWriter(new FileWriter(outputFile))) {
            while (fileReader.ready()) {
                String currentString = fileReader.readLine().replaceAll("\\.", "!");
                fileWriter.write(currentString);
//                fileWriter.write(currentString + System.getProperty("line.separator"));
            }
        }
    }
}
