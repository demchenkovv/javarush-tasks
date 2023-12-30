package com.github.demchenkovv.collections.level01.lecture04.task3103;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

/* 
Своя реализация
*/

public class Solution {

    // Вернуть массив байт файла fileName
    public static byte[] readBytes(String fileName) throws IOException {
        return Files.readAllBytes(Path.of(fileName));
    }

    // Вернуть список строк файла fileName
    public static List<String> readLines(String fileName) throws IOException {
        return Files.readAllLines(Path.of(fileName));
    }

    // Записать массив bytes в файл fileName
    public static void writeBytes(String fileName, byte[] bytes) throws IOException {
        Files.write(Path.of(fileName), bytes);
    }

    // Копировать файл resourceFileName на место destinationFileName
    public static void copy(String resourceFileName, String destinationFileName) throws IOException {
        Files.copy(Path.of(resourceFileName), Path.of(destinationFileName));
    }
}
