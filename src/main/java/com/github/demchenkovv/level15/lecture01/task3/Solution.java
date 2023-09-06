package com.github.demchenkovv.level15.lecture01.task3;

/*
Фейсконтроль
*/

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {

//        String path = "src/main/java/com/github/demchenkovv/level15/lecture01/task3/log.txt";

        try (Scanner scanner = new Scanner(System.in)) {
//            Files.readAllLines(Paths.get(path))
            Files.readAllLines(Paths.get(scanner.nextLine()))
                    .forEach(str -> System.out.println(str
                            .replaceAll("[., ]", "")));

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}

/*
Напиши программу, которая считывает из консоли имя текстового файла, далее читает символы из этого
файла (используй метод readAllLines(Path) класса Files) и выводит на экран все, за исключением точки, запятой и пробела.

Требования:
•	Программа должна считать с консоли путь к файлу.
•	Программа должна вывести в консоль содержимое файла согласно условию.
•	Для чтения строк из файла должен быть использован метод readAllLines(Path) класса Files.
•	Не используй следующие классы: File, FileInputStream, FileOutputStream, FileReader, FileWriter пакета java.io.
 */