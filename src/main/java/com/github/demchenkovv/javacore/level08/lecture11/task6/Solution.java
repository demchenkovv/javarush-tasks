package com.github.demchenkovv.javacore.level08.lecture11.task6;

/*
Два в одном
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        String file1;
        String file2;
        String file3;

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            file1 = reader.readLine();
            file2 = reader.readLine();
            file3 = reader.readLine();
        }

        BufferedWriter writer = new BufferedWriter(new FileWriter(file1, true));
        try (BufferedReader readerFile2 = new BufferedReader(new FileReader(file2))) {
            while (readerFile2.ready()) {
//                writer.write(readerFile2.readLine() + System.getProperty("line.separator")); // не пропустил валидатор
                writer.write(readerFile2.readLine());
            }
        }
        try (BufferedReader readerFile3 = new BufferedReader(new FileReader(file3))) {
            while (readerFile3.ready()) {
                writer.write(readerFile3.readLine());
            }
        }
        writer.close();
    }
}
