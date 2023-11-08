package com.github.demchenkovv.multithreading.level01.lecture10.task1;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/* 
Рефакторинг методов
*/

public class Solution {
    public static void writeZipEntriesToFile(String zipFileName, String outputFileName) {
        Charset charset = StandardCharsets.UTF_8;
        Path outputFilePath = Paths.get(outputFileName);
        try (BufferedWriter writer = Files.newBufferedWriter(outputFilePath, charset);
             ZipFile zip = new ZipFile(zipFileName)) {
            String newLine = System.getProperty("line.separator");
            for (Enumeration entries = zip.entries(); entries.hasMoreElements(); ) {
                // Берем имя файла из архива и записываем его в результирующий файл
                // Get the entry name and write it to the output file
                String zipEntryName = ((ZipEntry) entries.nextElement()).getName() + newLine;
                writer.write(zipEntryName, 0, zipEntryName.length());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        String zipFileName = "src/main/java/com/github/demchenkovv/multithreading/level01/lecture10/task1/ZipFolder.zip";
        String outputFileName = "src/main/java/com/github/demchenkovv/multithreading/level01/lecture10/task1/outputFromZip.txt";
        writeZipEntriesToFile(zipFileName, outputFileName);
    }
}
