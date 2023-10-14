package com.github.demchenkovv.javacore.level08.lecture11.task4;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Pattern;

/*
Английские буквы
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        String filePath = args[0];
        String str = "";

        try (BufferedReader fileReader = new BufferedReader(new FileReader(filePath))) {
            while (fileReader.ready()) {
                str += fileReader.readLine() + System.getProperty("line.separator");
            }
        }

        // Вариант сравнивания символа с его десятичным кодом (Dec),
        // где 'a' == 97, 'z' == 122, 'A' == 65, 'Z' == 90
        int countEnglishChars = 0;
        for (int i = 0; i < str.length(); i++) {
            if ((str.charAt(i) >= 'a' && str.charAt(i) <= 'z') || (str.charAt(i) >= 'A' && str.charAt(i) <= 'Z')) {
                ++countEnglishChars;
            }
        }
        System.out.println(countEnglishChars);

//        // Вариант через RegEx
//        int countEnglishChars = 0;
//        for (int i = 0; i < str.length(); i++) {
//            String c = String.valueOf(str.charAt(i));
//            if (Pattern.matches("[a-zA-Z]", c)) {
//                countEnglishChars++;
//            }
//        }
//        System.out.println(countEnglishChars);
    }
}
