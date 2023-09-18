package com.github.demchenkovv.javasyntaxzero.level15.lecture05.task3;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

/*
А что же внутри папки?
*/

public class Solution {

    private static final String THIS_IS_FILE = " - это файл";
    private static final String THIS_IS_DIR = " - это директория";

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        Path directory = Path.of(scanner.nextLine());
        //напишите тут ваш код
        try (DirectoryStream<Path> files = Files.newDirectoryStream(directory)) {
            for (Path path : files) {
                if (Files.isDirectory(path))
                    System.out.println(path + THIS_IS_DIR);
                else if (Files.isRegularFile(path))
                    System.out.println(path + THIS_IS_FILE);
            }
        } catch (IOException ex) {
            ex.getCause();
        }
    }
}

/*
Напиши программу, которая будет считывать с клавиатуры путь к директории, получать список файлов и
директорий в заданной директории и выводить в консоли информацию о них в виде:
"<путь к файлу> - это файл", если это файл,
"<путь к директории> - это директория", если это директория.
Треугольные скобки и кавычки выводить не нужно.
Используй соответствующие методы класса Files: newDirectoryStream(Path), isRegularFile(Path) и isDirectory(Path).

Ввод:
C:\javarush\

Вывод:
C:\javarush\test.txt - это файл
C:\javarush\tasks - это директория
...

Требования:
•	Программа должна считать из консоли путь к директории.
•	В программе должны быть использованы соответствующие методы класса Files: newDirectoryStream(Path), isRegularFile(Path) и isDirectory(Path).
•	Программа должна получать список файлов и директорий в заданной директории и выводить в консоли информацию согласно условию.
•	Не используй следующие классы: File, FileInputStream, FileOutputStream, FileReader, FileWriter пакета java.io.
 */