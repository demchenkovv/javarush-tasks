package com.github.demchenkovv.multithreading.level07.lecture15.task3110;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Главный класс приложения "Архиватор"
 */
public class Archiver {

    public static void main(String[] args) throws Exception {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {

            System.out.println("Введите полный путь файла архива:");
            Path zipFile = Paths.get(reader.readLine()); // файл, в котором мы будем хранить сжатые данные
            while (!zipFile.isAbsolute()) {
                System.out.println("Введен некорректный путь. Убедитесь, что путь до файла является абсолютным.");
                zipFile = Paths.get(reader.readLine());
            }
            ZipFileManager zipFileManager = new ZipFileManager(zipFile);

            System.out.println("Введите полное имя файла для архивации:");
            Path source = Paths.get(reader.readLine()); // файл, который мы будем сжимать
            while (!source.isAbsolute()) {
                System.out.println("Введен некорректный путь. Убедитесь, что путь до файла является абсолютным.");
                source = Paths.get(reader.readLine());
            }

            zipFileManager.createZip(source);
        }
    }
}