package com.github.demchenkovv.multithreading.level07.lecture15.task3110;

import com.github.demchenkovv.multithreading.level07.lecture15.task3110.exception.PathIsNotFoundException;

import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
/*
В Java есть специальный класс ZipOutputStream из пакета java.util.zip, который сжимает
(архивирует) переданные в него данные. Чтобы несколько файлов, сжимаемые в один архив, не
слиплись вместе, для каждого из них создается специальная сущность - элемент архива ZipEntry.
Т.е. в ZipOutputStream мы сначала кладем ZipEntry, а затем уже записываем содержимое файла.
При записи файл автоматически сжимается, а при чтении - автоматически восстанавливается.
ZipEntry может быть не только файлом, но и папкой.
 */

/**
 * Менеджер архива будет совершать операции над файлом архива
 * (файлом, который будет храниться на диске и иметь расширение zip).
 */
public class ZipFileManager {
    private Path zipFile; // полный путь к архиву, с которым будем работать

    public ZipFileManager(Path zipFile) {
        this.zipFile = zipFile;
    }


    // Path source - это путь к чему-то, что мы будем архивировать.
    public void createZip(Path source) throws Exception {
        // Если директории не существует, создать её со всеми вложенными папками
        if (Files.notExists(zipFile.getParent())) {
            Files.createDirectories(zipFile.getParent());
        }

        // Создаем zip поток
        try (ZipOutputStream zipOutputStream = new ZipOutputStream(Files.newOutputStream(zipFile))) {
            if (Files.isRegularFile(source)) {
                // Если архивируем отдельный файл, то нужно получить его директорию и имя
                addNewZipEntry(zipOutputStream, source.getParent(), source.getFileName());

            } else if (Files.isDirectory(source)) {
                // Если архивируем директорию, то нужно получить список файлов в ней
                FileManager fileManager = new FileManager(source);
                List<Path> fileNames = fileManager.getFileList(); // список относительных путей файлов

                // Добавляем каждый файл в архив
                for (Path path : fileNames) {
                    addNewZipEntry(zipOutputStream, source, path);
                }
            } else {
                // Если переданный source не директория и не файл
                throw new PathIsNotFoundException();
            }
        }
    }

    private void addNewZipEntry(ZipOutputStream zipOutputStream, Path filePath, Path fileName) throws Exception {
        Path newPath = filePath.resolve(fileName); // объединяем пути filePath + fileName (разделитель зависит от ОС)
        try (InputStream is = Files.newInputStream(newPath)) {
            ZipEntry zipEntry = new ZipEntry(fileName.toString());
            zipOutputStream.putNextEntry(zipEntry);

            // Копировать данные из InputStream в переданный zipOutputStream
            copyData(is, zipOutputStream);

            // Закрывать в zipOutputStream элемент архива ZipEntry
            zipOutputStream.closeEntry();
        }
    }

    private void copyData(InputStream in, OutputStream out) throws Exception {
        byte[] buffer = new byte[8 * 1024];
        int len;
        while ((len = in.read(buffer)) != -1) {
            out.write(buffer, 0, len);
        }
    }
}
