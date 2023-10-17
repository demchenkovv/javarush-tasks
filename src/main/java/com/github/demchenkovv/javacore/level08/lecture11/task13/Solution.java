package com.github.demchenkovv.javacore.level08.lecture11.task13;

import java.io.*;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

/*
Собираем файл
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        List<String> paths = new ArrayList<>();
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            String currentFileName;
            while (!(currentFileName = bufferedReader.readLine()).equals("end")) {
                paths.add(currentFileName);
            }
        }
        paths.sort(String::compareTo);

        //
//        String destDir = Path.of(paths.get(0)).getParent().toString();
//        String destFile = Path.of(paths.get(0)).getFileName().toString().replaceAll("\\.part\\d+$", "");
//        String destinationPath = Path.of(destDir, destFile).normalize().toAbsolutePath().toString();

        String[] splittedPath = paths.get(0).split("\\.part\\d+$");
        String destinationPath = splittedPath[0];

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        for (String path : paths) {
            try (BufferedInputStream fileInputStream = new BufferedInputStream(new FileInputStream(path))) {
                while (fileInputStream.available() > 0) {
                    byteArrayOutputStream.write(fileInputStream.read());
                }
            }
        }

        try (FileOutputStream fileOutputStream = new FileOutputStream(destinationPath)) {
            byteArrayOutputStream.writeTo(fileOutputStream);
        }
    }
}
