package com.github.demchenkovv.javacore.level08.lecture05.task4;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/*
Реверс файла
*/

public class Solution {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             FileInputStream inputStream = new FileInputStream(reader.readLine());
             FileOutputStream outputStream = new FileOutputStream(reader.readLine())) {
            byte[] buffer = new byte[inputStream.available()];
            inputStream.read(buffer);
            for (int i = buffer.length - 1; i >= 0; i--) {
                outputStream.write(buffer[i]);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
