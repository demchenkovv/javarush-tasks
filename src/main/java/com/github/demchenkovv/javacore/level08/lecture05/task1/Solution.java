package com.github.demchenkovv.javacore.level08.lecture05.task1;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/* 
Исправить ошибки
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        FileInputStream inputStream = new FileInputStream("c:/data.txt");
        // Создаем поток-записи-байт-в-файл
        FileOutputStream outputStream = new FileOutputStream("c:/result.txt");
        //читаем весь файл одним куском
        byte[] buffer = new byte[inputStream.available()];
        if (inputStream.available() > 0) {
            int count = inputStream.read(buffer);
            outputStream.write(buffer, 0, count);
        }
        outputStream.close();
        inputStream.close();
    }
}