package com.github.demchenkovv.javasyntaxzero.level15.lecture05.task2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

/*
Файловые операции
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        Path filePath = Path.of(scanner.nextLine());
        Path fileNewPath = Path.of(scanner.nextLine());
        //напишите тут ваш код
        try {
            if (Files.exists(filePath)) {
                if (Files.exists(fileNewPath)) {
                    Files.delete(filePath);
                } else {
                    Files.move(filePath, fileNewPath);
                }
            } else {
                Files.createFile(filePath);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}

/*
Нужно написать программу, которая будет считывать с клавиатуры два пути к файлу.

Если файла по первому пути не существует, его нужно создать.
Если же файл по первому пути существует, нужно переместить этот файл по второму пути,
но только в том случае, если по второму пути файла нет.
Если же он есть, нужно просто удалить файл по первому пути.
Используй соответствующие методы класса Files: createFile(), move(), delete(), exists()/notExists().
Требования:
•	Программа должна считать из консоли два пути.
•	В программе должны быть использованы соответствующие методы класса Files: createFile(Path.class), move(Path, Path), delete(Path), exists(Path)/notExists(Path).
•	Программа должна обрабатывать введенные пути согласно условию.
•	Не используй следующие классы: File, FileInputStream, FileOutputStream, FileReader, FileWriter пакета java.io.
 */