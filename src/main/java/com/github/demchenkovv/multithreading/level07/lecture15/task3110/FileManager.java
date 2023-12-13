package com.github.demchenkovv.multithreading.level07.lecture15.task3110;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FileManager {
    private Path rootPath; // корневой путь директории, файлы которой нас интересуют
    private List<Path> fileList; // список относительных путей файлов внутри rootPath

    public FileManager(Path rootPath) throws IOException {
        this.rootPath = rootPath;
        this.fileList = new ArrayList<>();
        collectFileList(rootPath);
    }

    public List<Path> getFileList() {
        return fileList;
    }

    private void collectFileList(Path path) throws IOException {
        // путь path является обычным файлом, то добавить относительный путь в список
        if (Files.isRegularFile(path)) {
            fileList.add(rootPath.relativize(path));

            // если path является директорией, то пройтись по всему содержимому директории
            // и вызвать collectFileList(Path path), передав в path обнаруженные элементы
        } else if (Files.isDirectory(path)) {
            DirectoryStream<Path> directoryStream = Files.newDirectoryStream(path);
            Iterator<Path> iterator = directoryStream.iterator();
            while (iterator.hasNext()) {
                Path next = iterator.next();
                collectFileList(next); // рекурсивно проверяем путь
            }
            directoryStream.close(); // обязательно закрыть поток DirectoryStream
        }
    }
}
