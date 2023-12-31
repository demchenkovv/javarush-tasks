package com.github.demchenkovv.collections.level01.lecture06.task3106;

/*
Разархивируем файл
*/

import java.io.*;
import java.util.*;
import java.util.zip.ZipInputStream;

public class Solution {

    public static void main(String[] args) throws IOException {

//        // for testing
//        args = new String[]{
//                "src/main/java/com/github/demchenkovv/collections/level01/lecture06/task3106/test/result.mp3",
//                "src/main/java/com/github/demchenkovv/collections/level01/lecture06/task3106/test/abc.zip.003",
//                "src/main/java/com/github/demchenkovv/collections/level01/lecture06/task3106/test/abc.zip.001",
//                "src/main/java/com/github/demchenkovv/collections/level01/lecture06/task3106/test/abc.zip.004",
//                "src/main/java/com/github/demchenkovv/collections/level01/lecture06/task3106/test/abc.zip.002"
//        };

        if (args.length == 0) {
            return;
        }

        // Массив для хранения частей файла с последующей сортировкой
        // для корректного порядка извлечения файлов (от меньшего к большему)
        String[] fileNamePartArray = Arrays.copyOfRange(args, 1, args.length);
        Arrays.sort(fileNamePartArray);

        // Для каждой части файла создаем поток для чтения файла
        List<FileInputStream> fileInputStreams = new ArrayList<>();
        for (String filePart : fileNamePartArray) {
            fileInputStreams.add(new FileInputStream(filePart));
        }

        // SequenceInputStream представляет собой логическую конкатенацию
        // других входных потоков. Он начинает с упорядоченной коллекции
        // входных потоков и читает из первого до тех пор, пока не будет
        // достигнут конец файла, после чего читает из второго, и так далее,
        // пока конец файла не будет достигнут на последнем из содержащихся
        // входных потоков.
        // Мы можем инициализировать SequenceInputStream, используя два
        // объекта InputStream, или с помощью перечисления объектов InputStream.
        Enumeration<FileInputStream> enumeration = Collections.enumeration(fileInputStreams);

        try (SequenceInputStream sequenceIS = new SequenceInputStream(enumeration);
             ZipInputStream zipIS = new ZipInputStream(sequenceIS);
             BufferedOutputStream bufferedOS = new BufferedOutputStream(new FileOutputStream(args[0]))) {

            byte[] buffer = new byte[8192];
            while (zipIS.getNextEntry() != null) {
                int len;
                while ((len = zipIS.read(buffer)) != -1) {
                    bufferedOS.write(buffer, 0, len);
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
