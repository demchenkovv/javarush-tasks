package com.github.demchenkovv.collections.level02.lecture02.task3201;

/*
Запись в существующий файл
*/

import java.io.IOException;
import java.io.RandomAccessFile;

public class Solution {

    public static void main(String... args) throws IOException {
//        //for testing
//        args = new String[]{
//                "src/main/java/com/github/demchenkovv/collections/level02/lecture02/task3201/test_data.txt",
//                "6",
//                "developer"
//        };

        if (args.length != 3) {
            return;
        }

        String fileName = args[0];
        long position = Long.parseLong(args[1]);
        String text = args[2];

        RandomAccessFile raf = new RandomAccessFile(fileName, "rw");

        position = position > raf.length() ? raf.length() : position;

        raf.seek(position);
        raf.writeBytes(text);
        raf.close();
    }
}
