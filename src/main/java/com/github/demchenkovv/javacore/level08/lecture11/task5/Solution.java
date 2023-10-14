package com.github.demchenkovv.javacore.level08.lecture11.task5;

/*
Пробелы
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Locale;

public class Solution {
    public static void main(String[] args) throws IOException {
        String filePath = args[0];
        String str = "";

        try (BufferedReader fileReader = new BufferedReader(new FileReader(filePath))) {
            while (fileReader.ready()) {
                str += fileReader.readLine();
            }
        }
        char space = ' ';
        double countSpace = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == space) {
                countSpace++;
            }
        }
        double average = countSpace / str.length() * 100.0;
        System.out.printf(Locale.ROOT, "%.2f", average);


//        double average2 = ((double) Math.round(countSpace / str.length() * 100.0 * 100) / 100.0);
//        System.out.printf(Locale.ROOT, "%.2f", average2);

//        System.out.println(Math.round(5.0 / 2 * 100) / 100.0); // на выходе тип double
    }
}