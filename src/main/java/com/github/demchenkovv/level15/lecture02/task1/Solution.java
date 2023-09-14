package com.github.demchenkovv.level15.lecture02.task1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

/*
Пропускаем не всех
*/

public class Solution {
    public static void main(String[] args) {
//        Path path = Paths.get("src/main/java/com/github/demchenkovv/level15/lecture03/polimorphismExample/text.txt").normalize();

        try (Scanner scanner = new Scanner(System.in)) {
            List<String> lines = Files.readAllLines(Paths.get(scanner.nextLine()));

            int step = lines.size() % 2 == 0
                    ? 2
                    : 1;
            for (int i = 0; i < lines.size(); i += step) {
                System.out.println(lines.get(i));
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}

/*
Напиши программу, которая считывает из консоли имя текстового файла, далее читает строки из этого
файла (используй метод readAllLines(Path) класса Files) и выводит их на экран через одну, начиная с первой.

Требования:
•	Программа должна считать из консоли путь к файлу.
•	Программа должна вывести в консоли содержимое файла согласно условию.
•	Для чтения строк из файла нужно использовать метод readAllLines(Path) класса Files.
•	Не используй следующие классы: File, FileInputStream, FileOutputStream, FileReader, FileWriter пакета java.io.
 */