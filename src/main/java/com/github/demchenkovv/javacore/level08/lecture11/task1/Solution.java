package com.github.demchenkovv.javacore.level08.lecture11.task1;

/*
Шифровка
*/

import java.io.*;
import java.nio.file.Path;

public class Solution {
    public static void main(String[] args) throws IOException {

//        String inputFile = Path.of("src/main/java/com/github/demchenkovv/javacore/level08/lecture11/task1/inputFile.txt").toAbsolutePath().toString();
//        String outputFile = Path.of("src/main/java/com/github/demchenkovv/javacore/level08/lecture11/task1/outputFile.txt").toAbsolutePath().toString();
//        BufferedInputStream inputStream = new BufferedInputStream(new FileInputStream(inputFile));
//        BufferedOutputStream outputStream = new BufferedOutputStream(new FileOutputStream(outputFile));

        try (BufferedInputStream inputStream = new BufferedInputStream(new FileInputStream(args[1]));
             BufferedOutputStream outputStream = new BufferedOutputStream(new FileOutputStream(args[2]))) {
            byte[] buffer = new byte[inputStream.available()];
            switch (args[0]) {
                case "-e": {
                    while (inputStream.available() > 0) {
                        int len = inputStream.read(buffer);
                        byte[] encrypt = new byte[len];
                        for (int i = 0; i < len; i++) {
                            encrypt[i] = (byte) (buffer[i] + 1);
                        }
                        outputStream.write(encrypt);
                    }
                }
                case "-d": {
                    while (inputStream.available() > 0) {
                        int len = inputStream.read(buffer);
                        byte[] decrypt = new byte[len];
                        for (int i = 0; i < len; i++) {
                            decrypt[i] = (byte) (buffer[i] - 1);
                        }
                        outputStream.write(decrypt);
                    }
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}

// Решение попроще
// public class Solution {
//    public static void main(String[] args) throws IOException {
//        String mode = args[0];
//        if (!(mode.equals("-e") || mode.equals("-d"))) {
//        return;
//        }
//        try (FileInputStream fileInputStream = new FileInputStream(args[1]);
//             FileOutputStream fileOutputStream = new FileOutputStream(args[2])) {
//            if (mode.equals("-e")) {
//                while (fileInputStream.available() > 0) {
//                    fileOutputStream.write(fileInputStream.read() + 32);
//                }
//            } else {
//                while (fileInputStream.available() > 0) {
//                    fileOutputStream.write(fileInputStream.read() - 32);
//                }
//            }
//        }
//    }
//}