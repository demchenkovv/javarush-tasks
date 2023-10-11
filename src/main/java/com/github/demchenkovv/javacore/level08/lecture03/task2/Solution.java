package com.github.demchenkovv.javacore.level08.lecture03.task2;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/*
Минимальный байт
*/

public class Solution {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             FileInputStream fileInputStream = new FileInputStream(reader.readLine())) {
            int minReadByte = Byte.MAX_VALUE;
            while (fileInputStream.available() > 0) {
                int currentByte = fileInputStream.read();
                minReadByte = Math.min(currentByte, minReadByte);
            }
            System.out.println(minReadByte);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}