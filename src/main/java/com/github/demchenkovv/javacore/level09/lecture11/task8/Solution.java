package com.github.demchenkovv.javacore.level09.lecture11.task8;

/*
Слова с цифрами
*/

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) throws IOException {
        args = new String[]{
                "src/main/java/com/github/demchenkovv/javacore/level09/lecture11/task8/input.txt",
                "src/main/java/com/github/demchenkovv/javacore/level09/lecture11/task8/output.txt"
        };

        try (BufferedReader fileReader = new BufferedReader(new FileReader(args[0]));
             BufferedWriter fileWriter = new BufferedWriter(new FileWriter(args[1]))) {
            while (fileReader.ready()) {
                String[] splits = fileReader.readLine().split(" ");
                for (String word : splits) {
                    if (word.matches(".*[0-9].*")) {    // v1
//                    if (word.matches("\\S*[0-9]\\S*")) {      // v2
                        fileWriter.write(word + " ");
                    }
                }
//                Pattern pattern = Pattern.compile("\\w*\\d+\\w*");    // v3
//                for (String s : splits) {
//                    Matcher matcher = pattern.matcher(s);
//                    if (matcher.find()) {
//                        fileWriter.write(s + " ");
//                    }
//                }
            }
        }
    }
}
