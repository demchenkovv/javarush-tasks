package com.github.demchenkovv.collections.level01.lecture02.task3101;

/*
Проход по дереву файлов
*/

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Solution {

    public static void main(String[] args) {
//        // Для тестов
//        String dir = "src/main/java/com/github/demchenkovv/collections/level01/lecture02/task3101/test/inner_folder";
//        String res = "src/main/java/com/github/demchenkovv/collections/level01/lecture02/task3101/test/res.txt";
//        args = new String[]{dir, res};

        // Проверка, что на вход приходит два параметра
        if (args.length != 2) {
            return;
        }

        File path = new File(args[0]);
        File resultFileAbsolutePath = new File(args[1]);
        File allFilesContent = new File(resultFileAbsolutePath.getParent() + "/" + "allFilesContent.txt");
//        File allFilesContent = new File(resultFileAbsolutePath.getParent() + File.separator + "allFilesContent.txt");

        if (FileUtils.isExist(resultFileAbsolutePath)) {
            FileUtils.renameFile(resultFileAbsolutePath, allFilesContent);
        }

        List<File> files = getFilesUnder50Bytes(path, new ArrayList<>());

        try (BufferedOutputStream outputStream = new BufferedOutputStream(new FileOutputStream(allFilesContent))) {
            for (File file : files) {
                try (BufferedInputStream inputStream = new BufferedInputStream(new FileInputStream(file))) {
                    byte[] buffer = new byte[inputStream.available()];
                    inputStream.read(buffer);
                    outputStream.write(buffer);
                    outputStream.write('\n');
                }
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static List<File> getFilesUnder50Bytes(File directory, List<File> fileList) {
        File[] files = directory.listFiles();

        if (files == null) {
            throw new NullPointerException();
        }

        for (File entry : files) {

            // Если элемент является директорией, то для этой директории
            // рекурсивно вызываем метод recursiveFileTreeTraversal,
            // куда передаем директорию и текущее состояние списка
            if (entry.isDirectory()) {
                getFilesUnder50Bytes(entry, fileList);
                continue;
            }

            // Иначе элемент является файлом.
            // Метод length():long класса File возвращает размер файла в байтах
            if (entry.length() <= 50) {
//                System.out.println(entry.getName() + ": " + entry.length());
                fileList.add(entry);
            }
        }
        return fileList;
    }
}
