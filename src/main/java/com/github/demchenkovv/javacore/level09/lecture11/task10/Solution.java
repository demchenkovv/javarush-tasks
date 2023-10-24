package com.github.demchenkovv.javacore.level09.lecture11.task10;

/*
Длинные слова
*/

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

//public class Solution {
//    public static void main(String[] args) throws IOException {
//        args = new String[]{
//                "src/main/java/com/github/demchenkovv/javacore/level09/lecture11/task10/input.txt",
//                "src/main/java/com/github/demchenkovv/javacore/level09/lecture11/task10/output.txt"
//        };
//
//        try (BufferedReader fileReader = new BufferedReader(new FileReader(args[0]));
//             BufferedWriter fileWriter = new BufferedWriter(new FileWriter(args[1]))) {
//        }
//    }
//}

public class Solution {
    public static void main(String[] args) throws IOException {
        args = new String[]{
                "src/main/java/com/github/demchenkovv/javacore/level09/lecture11/task10/input.txt",
                "src/main/java/com/github/demchenkovv/javacore/level09/lecture11/task10/output.txt"
        };
        try (BufferedReader fileReader = new BufferedReader(new FileReader(args[0]));
             BufferedWriter fileWriter = new BufferedWriter(new FileWriter(args[1]))) {

            // Вариант 1. Элегантный вариант через стримы, заменяющий код снизу
            fileWriter.write(fileReader.lines()
                    .flatMap(lines -> Arrays.stream(lines.split(" ")))
                    .filter(e -> e.length() > 6)
                    .collect(Collectors.joining(",")));


//            // Вариант 2. Через StringBuilder и счетчик
//            StringBuilder sb = new StringBuilder();
//            int num = 0;
//            while (fileReader.ready()) {
//                String[] splitLines = fileReader.readLine().split(" ");
//                for (String currentLine : splitLines) {
//                    if (currentLine.length() > 6) {
//                        if (num == 0) {
//                            sb.append(currentLine);
//                            num++;
//                        } else {
//                            sb.append(",");
//                            sb.append(currentLine);
//                        }
//                    }
//                }
//            }
//            fileWriter.write(sb.toString());


//            // Вариант 3. Через список и матчер
//            List<String> stringList = new ArrayList<>();
//            while (fileReader.ready()) {
//                String line = fileReader.readLine();
//                Pattern pattern = Pattern.compile("\\b(\\w{7,})\\b", Pattern.UNICODE_CHARACTER_CLASS);
//                Matcher matcher = pattern.matcher(line);
//                while (matcher.find()) {
//                    String match = matcher.group();
//                    stringList.add(match);
//                }
//            }
//            for (int i = 0; i < stringList.size(); i++) {
//                if (i != stringList.size() - 1) {
//                    fileWriter.write(stringList.get(i) + ",");
//                } else {
//                    fileWriter.write(stringList.get(i));
//                }
//            }
        }
    }
}
