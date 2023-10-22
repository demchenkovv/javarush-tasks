package com.github.demchenkovv.javacore.level09.lecture11.task7;

import java.io.*;
import java.util.*;

/* 
Ищем нужные строки
*/

public class Solution {
    public static List<String> words = new ArrayList<String>();

    static {
        words.add("А");
        words.add("Б");
        words.add("В");
    }

    public static void main(String[] args) throws IOException {
        String inputFile;
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            inputFile = bufferedReader.readLine();
        }
        try (BufferedReader fileReader = new BufferedReader(new FileReader(inputFile))) {
            while (fileReader.ready()) {
                String line = fileReader.readLine();
                String[] split = line.split(" ");
                int countWord = 0;
                for (String s : split) {
                    if (words.contains(s)) {
                        countWord++;
                    }
                }
                if (countWord == 2) {
                    System.out.println(line);
                }
            }
        }
    }
}
