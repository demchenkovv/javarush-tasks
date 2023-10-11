package com.github.demchenkovv.javacore.level08.lecture05.task2;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

/*
Подсчет запятых
*/

public class Solution {
    public static void main(String[] args) {
        try (BufferedReader bReader = new BufferedReader(new InputStreamReader(System.in));
             FileInputStream fileInputStream = new FileInputStream(bReader.readLine())) {
            byte[] buffer = new byte[fileInputStream.available()];
            byte[] asciiCharCode = ",".getBytes(StandardCharsets.US_ASCII); // ascii - 44
            int count = 0;
            while (fileInputStream.available() > 0) {
                fileInputStream.read(buffer);
                for (byte b : buffer) {
                    if (b == asciiCharCode[0]) {
                        count++;
                    }
                }
            }
            System.out.println(count);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}