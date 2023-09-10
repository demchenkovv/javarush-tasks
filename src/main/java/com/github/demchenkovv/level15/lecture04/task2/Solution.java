package com.github.demchenkovv.level15.lecture04.task2;

import java.nio.file.Path;
import java.util.Scanner;

/*
Все относительно
*/

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str1 = scanner.nextLine();
        String str2 = scanner.nextLine();
        //напишите тут ваш код
        Path path1 = Path.of(str1);
        Path path2 = Path.of(str2);
        try {
            Path result = path1.relativize(path2);
            System.out.println(result);
        } catch (IllegalArgumentException ex) {

        }
    }
}

/*
Напиши программу, которая будет считывать с клавиатуры два пути и выводить в консоль относительный
путь между первым и вторым путями, если он существует. В противном случае выводить ничего не нужно.

Требования:
•	Программа должна считать из консоли два пути.
•	Программа должна выводить в консоли относительный путь между введенными путями, если он существует.
•	Для вычисления относительного пути должен быть использован метод relativize() класса Path.
•	Не используй следующие классы: File, FileInputStream, FileOutputStream, FileReader, FileWriter пакета java.io.
 */