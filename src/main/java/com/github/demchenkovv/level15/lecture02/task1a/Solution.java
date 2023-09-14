package com.github.demchenkovv.level15.lecture02.task1a;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

/**
 * Альтернативное решение задачи 1 из лекции 02 уровня 15
 */
public class Solution {
    public static void main(String[] args) throws IOException {

        Path path = Paths
                .get("src/main/java/com/github/demchenkovv/level15/lecture03/polimorphismExample/text.txt")
                .normalize();

        try (BufferedReader bufferedReader =
                     Files.newBufferedReader(path, StandardCharsets.UTF_8)) {

//        try (Scanner scanner = new Scanner(System.in);
//             BufferedReader bufferedReader =
//                     Files.newBufferedReader(Path.of(scanner.nextLine()), StandardCharsets.UTF_8)) {
            String line = bufferedReader.readLine();
            int i = 0;
            while (line != null) {
                if (i % 2 == 0) {
                    System.out.println(line);
                }
                i++;
                line = bufferedReader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
