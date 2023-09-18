package com.github.demchenkovv.javasyntaxzero.level15.lecture01.task1;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

/*
Перепутанные байты
*/

public class Solution {
    public static void main(String[] args) {

//        String src = "src/main/java/com/github/demchenkovv/other/test_package/log.txt";
//        String dest = "src/main/java/com/github/demchenkovv/other/test_package/copy.txt";
//
//        try (InputStream input = Files.newInputStream(Paths.get(src));
//             OutputStream output = Files.newOutputStream(Paths.get(dest))) {

        try (Scanner scanner = new Scanner(System.in);
             InputStream input = Files.newInputStream(Paths.get(scanner.nextLine()));
             OutputStream output = Files.newOutputStream(Paths.get(scanner.nextLine()))) {

            byte[] allBytes = input.readAllBytes();
            for (int i = 0; i < allBytes.length - 1; ) {
                byte temp = allBytes[i];
                allBytes[i] = allBytes[i + 1];
                allBytes[i + 1] = temp;
                if (i != allBytes.length - 1)
                    i += 2;
            }
            output.write(allBytes);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}

/*
Напиши программу, которая считывает с консоли путь к файлу1 и путь к файлу2.
Далее все байты из файла1 записывает в файл2, но при этом меняет их местами по такому принципу: первый со вторым, третий с четвертым, и т.д.
Если последний байт в файле1 нечетный, то пишем его в файл2 как есть.
Для чтения и записи файлов используй методы newInputStream и newOutputStream класса Files.

Требования:
•	Программа должна считать с консоли пути к файлам.
•	Программа должна переписывать байты из одного файла в другой согласно условию.
•	Для чтения и записи файлов должны быть использованы методы newInputStream и newOutputStream класса Files.
•	Потоки для чтения и записи должны быть закрыты.
•	Не используй следующие классы File, FileInputStream, FileOutputStream, FileReader, FileWriter пакета java.io.
 */