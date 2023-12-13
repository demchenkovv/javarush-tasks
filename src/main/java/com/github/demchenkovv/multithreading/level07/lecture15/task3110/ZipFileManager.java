package com.github.demchenkovv.multithreading.level07.lecture15.task3110;

import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * Менеджер архива будет совершать операции над файлом архива
 * (файлом, который будет храниться на диске и иметь расширение zip).
 */
public class ZipFileManager {
    private Path zipFile; // полный путь к архиву, с которым будем работать

    public ZipFileManager(Path zipFile) {
        this.zipFile = zipFile;
    }

    /* В Java есть специальный класс ZipOutputStream из пакета java.util.zip, который сжимает
    (архивирует) переданные в него данные. Чтобы несколько файлов, сжимаемые в один архив, не
    слиплись вместе, для каждого из них создается специальная сущность - элемент архива ZipEntry.
    Т.е. в ZipOutputStream мы сначала кладем ZipEntry, а затем уже записываем содержимое файла.
    При записи файл автоматически сжимается, а при чтении - автоматически восстанавливается.
    ZipEntry может быть не только файлом, но и папкой. */
    // Path source - это путь к чему-то, что мы будем архивировать.
    public void createZip(Path source) throws Exception {
        System.out.println("Start archiving...");
        try (ZipOutputStream zipOutputStream = new ZipOutputStream(Files.newOutputStream(zipFile)); // поток архива
             InputStream inputStream = Files.newInputStream(source)) { // поток для добавляемого файла source

            // Создай новый элемент архива ZipEntry. В конструктор ZipEntry передай только имя файла
            ZipEntry zipEntry = new ZipEntry(source.getFileName().toString());
            zipOutputStream.putNextEntry(zipEntry); // добавить в поток архива созданный элемент архива

            // Прочитать данные из IStream, пока они там есть, и записать их в ZOStream
            byte[] buffer = new byte[8 * 1024]; // 8 Кб
            int len;
            while ((len = inputStream.read(buffer)) > 0) {
                zipOutputStream.write(buffer, 0, len);
            }
            zipOutputStream.closeEntry(); // закрыть элемент архива у потока архива
        }
        System.out.println("Archiving is complete.");
    }
}
