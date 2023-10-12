package com.github.demchenkovv.javacore.level08.lecture08.task4;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Path;

/* 
UnsupportedFileName
*/

public class TxtInputStream extends FileInputStream {

    public TxtInputStream(String filePath) throws IOException, UnsupportedFileNameException {
        super(filePath);
        if (!filePath.endsWith(".txt")) {
            // В случае выброшенного исключения, должен быть вызван super.close()
            // Мы же хотим закрыть поток
            super.close();
            throw new UnsupportedFileNameException();
        }
    }

    public static void main(String[] args) throws UnsupportedFileNameException, IOException {
        String pathToFile = Path.of("src/main/java/com/github/demchenkovv/javacore/level08/lecture08/task4/wrongFile.jpg").toAbsolutePath().toString();
        TxtInputStream xx = new TxtInputStream(pathToFile);
    }
}