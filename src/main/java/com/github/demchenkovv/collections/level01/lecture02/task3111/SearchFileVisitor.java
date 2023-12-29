package com.github.demchenkovv.collections.level01.lecture02.task3111;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;

public class SearchFileVisitor extends SimpleFileVisitor<Path> {
    private String partOfName;
    private String partOfContent;
    private int minSize;
    private int maxSize;
    private List<Path> foundFiles = new ArrayList<>();

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        byte[] content = Files.readAllBytes(file); // размер файла: content.length
        boolean isFileUnderMinSize = content.length < minSize;
        boolean isFileOverMaxSize = content.length > maxSize;

        boolean containsOfName = false;
        String fileName = file.getFileName().toString();
        int dotIndex = fileName.lastIndexOf("."); // если -1, значит файл не имеет расширения
        containsOfName = dotIndex != -1
                ? fileName.substring(0, dotIndex).equals(partOfName)
                : fileName.equals(partOfName);

        boolean containsOfContent = false;
        if (partOfContent != null) {
            containsOfContent = Files.readString(file).contains(partOfContent);
        }

        if (containsOfName || containsOfContent || isFileUnderMinSize || isFileOverMaxSize) {
            foundFiles.add(file);
        }

        return super.visitFile(file, attrs);
    }

    public void setPartOfName(String partOfName) {
        this.partOfName = partOfName;
    }

    public void setPartOfContent(String partOfContent) {
        this.partOfContent = partOfContent;
    }

    public void setMinSize(int minSize) {
        this.minSize = minSize;
    }

    public void setMaxSize(int maxSize) {
        this.maxSize = maxSize;
    }

    public List<Path> getFoundFiles() {
        return foundFiles;
    }
}
