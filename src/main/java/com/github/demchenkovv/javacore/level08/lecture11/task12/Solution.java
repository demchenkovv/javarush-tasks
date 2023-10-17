package com.github.demchenkovv.javacore.level08.lecture11.task12;

import java.io.*;

/*
Файлы и исключения
*/

public class Solution {
    public static void main(String[] args) {
        String file;
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            while (true) {
                file = bufferedReader.readLine();
                try (FileReader fileReader = new FileReader(file)) {
                } catch (FileNotFoundException ex) {
                    System.out.println(file);
                    throw new FileNotFoundException(file);
                }
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}