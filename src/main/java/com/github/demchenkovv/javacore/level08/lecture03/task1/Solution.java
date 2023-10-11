package com.github.demchenkovv.javacore.level08.lecture03.task1;

/*
Максимальный байт
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             FileInputStream fileInputStream = new FileInputStream(reader.readLine())) {
            int maxReadByte = -1;
            while (fileInputStream.available() > 0) {
                int currentByte = fileInputStream.read();
                maxReadByte = Math.max(currentByte, maxReadByte);
            }
            System.out.println(maxReadByte);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
