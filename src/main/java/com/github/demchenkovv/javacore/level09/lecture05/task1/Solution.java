package com.github.demchenkovv.javacore.level09.lecture05.task1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

/*
Четные символы
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        String inputFile;
        String outputFile;
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            inputFile = reader.readLine();
            outputFile = reader.readLine();
        }
        try (FileReader fileReader = new FileReader(inputFile);
             FileWriter fileWriter = new FileWriter(outputFile)) {
            int charDec;
            int ordinalNumberOfTheSymbol = 1;
            while ((charDec = fileReader.read()) != -1) {
                if (ordinalNumberOfTheSymbol++ % 2 == 0) {
                    fileWriter.write(charDec);
                }
            }
        }
    }
}
