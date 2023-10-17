package com.github.demchenkovv.javacore.level08.lecture11.task9;

/*
Встречаемость символов
*/

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException {
        String filePath = args[0];
//        // избыточно, поскольку явно указано англ. текст (см. табл. ASCII)
//        byte[] bytes = new byte[256];
        int[] bytes = new int[128];
        try (BufferedInputStream inputStream = new BufferedInputStream(new FileInputStream(filePath))) {
            while (inputStream.available() > 0) {
                bytes[inputStream.read()]++;
            }
        }
        for (int i = 0; i < bytes.length; i++) {
            if (bytes[i] != 0) {
                System.out.printf("%c %d" + System.getProperty("line.separator"), i, bytes[i]);
            }
        }
    }
}
