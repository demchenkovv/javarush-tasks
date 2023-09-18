package com.github.demchenkovv.javasyntaxzero.level14.lecture03.task3;

import java.io.FileNotFoundException;
import java.nio.file.FileSystemException;

public class FileUtils {

    public static void readFile(String filePath) throws FileNotFoundException {
        System.out.println("Читаем содержимое файла " + filePath);
    }

    public static void writeFile(String filePath) throws FileSystemException {
        System.out.println("Записываем данные в файл " + filePath);
    }
}
