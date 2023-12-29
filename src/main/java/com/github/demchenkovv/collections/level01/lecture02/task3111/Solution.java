package com.github.demchenkovv.collections.level01.lecture02.task3111;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

/* 
Продвинутый поиск файлов
*/

/**
 * <a href="https://habr.com/ru/articles/437694/">Разбор утилиты Files.walkFileTree()</a>
 */
public class Solution {

    public static void main(String[] args) throws IOException {
        SearchFileVisitor searchFileVisitor = new SearchFileVisitor();

        searchFileVisitor.setPartOfName("amigo");
        searchFileVisitor.setPartOfContent("programmer");
        searchFileVisitor.setMinSize(500);
        searchFileVisitor.setMaxSize(10000);

        Files.walkFileTree(Paths.get("D:/SecretFolder"), searchFileVisitor);

//        // Для тестов
//        Path root = Paths.get("src/main/java/com/github/demchenkovv/collections/level01/lecture02/task3111/SecretFolder").toAbsolutePath();
//        Files.walkFileTree(root, searchFileVisitor);

        List<Path> foundFiles = searchFileVisitor.getFoundFiles();
        for (Path file : foundFiles) {
            System.out.println(file);
        }
    }

}
