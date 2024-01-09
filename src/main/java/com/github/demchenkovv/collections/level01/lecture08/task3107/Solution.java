package com.github.demchenkovv.collections.level01.lecture08.task3107;

/*
Null Object Pattern
*/

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Solution {
    private FileData fileData;

    public Solution(String pathToFile) {
        try {
            Path path = Paths.get(pathToFile);
            fileData = new ConcreteFileData(Files.isHidden(path), Files.isExecutable(path), Files.isDirectory(path),
                    Files.isWritable(path));
        } catch (IOException ex) {
            fileData = new NullFileData(ex);
        }
    }

    public FileData getFileData() {
        return fileData;
    }
}
