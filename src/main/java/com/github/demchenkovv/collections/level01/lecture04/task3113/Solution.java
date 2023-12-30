package com.github.demchenkovv.collections.level01.lecture04.task3113;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

/* 
Что внутри папки?
*/

/**
 * <a href="https://habr.com/ru/articles/437694/">Разбор утилиты Files.walkFileTree() | Хабр</a>
 */
public class Solution extends SimpleFileVisitor<Path> {
    private static int fileCounter;
    private static int folderCounter;
    private static long totalSize;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Path path = Paths.get(reader.readLine()).toAbsolutePath();
        reader.close();

        if (!Files.isDirectory(path)) {
            System.out.println(path.toAbsolutePath() + " - не папка");
            return;
        }

        // Переданная директория также учитывается в итоговой сумме
        Files.walkFileTree(path, new Solution());

        System.out.println("Всего папок - " + folderCounter);
        System.out.println("Всего файлов - " + fileCounter);
        System.out.println("Общий размер - " + totalSize);

    }


    // Вызывается для каждой директории, включая исходную, перед обработкой записей в ней.
    @Override
    public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
        folderCounter++;
        return super.preVisitDirectory(dir, attrs);
    }

    // Вызывается для каждого файла в каталоге.
    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        fileCounter++;
        totalSize += Files.size(file);
        return super.visitFile(file, attrs);
    }
}
