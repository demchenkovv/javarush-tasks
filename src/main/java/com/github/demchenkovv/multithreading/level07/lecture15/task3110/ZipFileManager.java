package com.github.demchenkovv.multithreading.level07.lecture15.task3110;

import java.nio.file.Path;

/**
 * Менеджер архива будет совершать операции над файлом архива
 * (файлом, который будет храниться на диске и иметь расширение zip).
 */
public class ZipFileManager {
    private Path zipFile; // полный путь к архиву, с которым будем работать

    public ZipFileManager(Path zipFile) {
        this.zipFile = zipFile;
    }

    // Path source - это путь к чему-то, что мы будем архивировать
    public void createZip(Path source) throws Exception {

    }
}
