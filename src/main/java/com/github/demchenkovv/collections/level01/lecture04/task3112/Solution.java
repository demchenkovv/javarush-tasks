package com.github.demchenkovv.collections.level01.lecture04.task3112;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

/* 
Загрузчик файлов
*/

public class Solution {

    public static void main(String[] args) throws IOException {
        Path passwords = downloadFile("https://javarush.ru/testdata/secretPasswords.txt", Paths.get("src/main/java/com/github/demchenkovv/collections/level01/lecture04/task3112/mydownloads").toAbsolutePath());

        for (String line : Files.readAllLines(passwords)) {
            System.out.println(line);
        }
    }

    // По умолчанию новые скопированные файлы не могут переписать
    // ранее созданные. Также нельзя скопировать атрибуты файла-источника.
    // Опция REPLACE_EXISTING предотвращает возникновение исключения,
    // так как в этом режиме метод перезапишет существующий файл, а не
    // попытается добавить содержимое входного потока к нему.
    public static Path downloadFile(String urlString, Path downloadDirectory) throws IOException {
        URL url = new URL(urlString);

        Path temp = Files.createTempFile("javarush-task3112-", ".tmp");
        String downloadFileName = urlString.substring(urlString.lastIndexOf("/") + 1);

        // Строит новый абсолютный путь из абсолютного (downloadDirectory) и относительного (downloadFileName).
        Path target = downloadDirectory.resolve(downloadFileName);

        try (InputStream is = url.openStream()) {
            Files.copy(is, temp, StandardCopyOption.REPLACE_EXISTING); /* см. комментарии */
            if (Files.notExists(downloadDirectory)) {
                Files.createDirectories(downloadDirectory);
            }
            Files.move(temp, target, StandardCopyOption.REPLACE_EXISTING);
        }
        return target;
    }
}
