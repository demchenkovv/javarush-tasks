package com.github.demchenkovv.javacore.level09.lecture11.task11;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
Перевертыши
*/

public class Solution {
    public static void main(String[] args) {
        try (BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
             BufferedReader fileReader = new BufferedReader(new FileReader(consoleReader.readLine()))) {
            while (fileReader.ready()) {
                String line = fileReader.readLine();
                System.out.println(new StringBuffer(line).reverse().toString());
            }
        } catch (IOException ignore) {
            /* NOP */
        }
    }
}
