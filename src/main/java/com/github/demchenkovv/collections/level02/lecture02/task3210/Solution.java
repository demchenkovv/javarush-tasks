package com.github.demchenkovv.collections.level02.lecture02.task3210;

/*
Используем RandomAccessFile
*/

import java.io.IOException;
import java.io.RandomAccessFile;

public class Solution {

    public static void main(String... args) throws IOException {
        //for testing
        args = new String[]{
                "src/main/java/com/github/demchenkovv/collections/level02/lecture02/task3210/test_data.txt",
                "0",
                "This"
        };

        if (args.length != 3) {
            return;
        }

        String fileName = args[0];
        long position = Long.parseLong(args[1]);
        String text = args[2];

        RandomAccessFile raf = new RandomAccessFile(fileName, "rw");
        raf.seek(position);

        byte[] buffer = new byte[text.length()];
        raf.read(buffer, 0, text.length());
        String readLine = new String(buffer);

        raf.seek(raf.length());
        if (readLine.equals(text)) {
            raf.writeBytes("true");
        } else {
            raf.writeBytes("false");
        }

        raf.close();
    }
}
