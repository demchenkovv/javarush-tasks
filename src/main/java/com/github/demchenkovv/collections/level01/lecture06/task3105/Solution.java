package com.github.demchenkovv.collections.level01.lecture06.task3105;

import java.io.*;
import java.nio.file.Files;
import java.util.HashMap;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

/* 
Добавление файла в архив
*/

public class Solution {

    public static void main(String[] args) throws IOException {

        // for testing
        args = new String[]{
                "src/main/java/com/github/demchenkovv/collections/level01/lecture06/task3105/test/to_be_added.txt",
                "src/main/java/com/github/demchenkovv/collections/level01/lecture06/task3105/test/archive.zip"};

        if (args.length == 0) {
            System.out.println("Массив аргументов пуст.");
            return;
        }

        String archive = args[1];

        // Для сохранения содержимого всех ZipEntry создадим Map,
        // где ключ - относительный пути внутри архива,
        // а значение - ByteArrayOutputStream, т.е. содержимое файла.
        Map<String, ByteArrayOutputStream> archiveContents = new HashMap<>();
        try (ZipInputStream zipInputStream = new ZipInputStream(new FileInputStream(archive))) {
            ZipEntry entry;
            while ((entry = zipInputStream.getNextEntry()) != null) {
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                byte[] buffer = new byte[1024 * 2048]; // 2 Mb
                int length = 0;
                while ((length = zipInputStream.read(buffer)) != -1) {
                    baos.write(buffer, 0, length);
                }
                archiveContents.put(entry.getName(), baos);
            }
        }

        File addFile = new File(args[0]);
        try (ZipOutputStream zipOutputStream = new ZipOutputStream(new FileOutputStream(archive))) {

            // Переписываем содержимое архива
            for (Map.Entry<String, ByteArrayOutputStream> entry : archiveContents.entrySet()) {

                // Если файл, который мы хотим добавить в архив, уже существует - перейти к следующей итерации;
                // иначе получим исключение ZipException: duplicate entry, свидетельствующее о попытке
                // добавить дубликат в выходной поток.
                String fileName = entry.getKey().substring(entry.getKey().lastIndexOf("/") + 1);
                if (fileName.equals(addFile.getName())) {
                    continue;
                }
                zipOutputStream.putNextEntry(new ZipEntry(entry.getKey()));
                zipOutputStream.write(entry.getValue().toByteArray());
            }

            // Создаем zipEntry из первого аргумента и кладем в выходной поток ZipOutputStream.
            ZipEntry zipEntry = new ZipEntry("new/" + addFile.getName());
            zipOutputStream.putNextEntry(zipEntry);

            // Копирует все байты из файла в выходной поток.
            // Первый параметр - путь к файлу, данные которого должны быть скопированы;
            // второй параметр - поток, в который должны быть записаны данные.
            Files.copy(addFile.toPath(), zipOutputStream);
        }
    }
}
