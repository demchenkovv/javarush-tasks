package com.github.demchenkovv.javacore.level09.lecture05.task5;

import java.io.*;

/*
Пунктуация
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
                String currentLine = fileReader.readLine().replaceAll("\\p{Punct}", "");
                fileWriter.write(currentLine);
            }
        }
    }
}
