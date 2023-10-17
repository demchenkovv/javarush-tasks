package com.github.demchenkovv.javacore.level08.lecture11.task10;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
Поиск данных внутри файла
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        String dataId = args[0];
        String filePath;
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            filePath = bufferedReader.readLine();
        }
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath))) {
            while (bufferedReader.ready()) {
                String line = bufferedReader.readLine();
                String[] splitLines = line.split(" ");
                if (splitLines[0].equals(dataId)) {
                    System.out.println(line);
                    break;
                }
            }
        }
    }
}
