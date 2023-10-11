package com.github.demchenkovv.javacore.level08.lecture05.task3;

/*
Разделение файла
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

// Побайтовая запись в файл без использования буфера
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        try (FileInputStream fileInputStream = new FileInputStream(reader.readLine());
             FileOutputStream fileOutputStream1 = new FileOutputStream(reader.readLine());
             FileOutputStream fileOutputStream2 = new FileOutputStream(reader.readLine())) {

            // Если 9 байт, то половина == 5, т.о. запишутся байты под индексами 0...4 в файл1 и 5...8 в файл2
            int halfOfFile = (fileInputStream.available() + 1) / 2;
            int numberOfByte = 0;
            while (fileInputStream.available() > 0) {
                if (numberOfByte < halfOfFile) {
                    fileOutputStream1.write(fileInputStream.read());
                    numberOfByte++;
                } else {
                    fileOutputStream2.write(fileInputStream.read());
                }
            }
        }
    }
}

//// Мое решение (рабочее, но неудобочитаемое)
//// Запись происходит с использованием буфера
//public class Solution {
//    public static void main(String[] args) {
//        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//             FileInputStream inputStream = new FileInputStream(reader.readLine());
//             FileOutputStream outputStreamFile2 = new FileOutputStream(reader.readLine());
//             FileOutputStream outputStreamFile3 = new FileOutputStream(reader.readLine())) {
//
//            byte[] buffer = new byte[inputStream.available()];
//            while (inputStream.available() > 0) {
//                int current = inputStream.read(buffer);
//                if (buffer.length % 2 != 0) {
//                    outputStreamFile2.write(buffer, 0, current / 2 + 1);
//                    outputStreamFile3.write(buffer, current / 2 + 1, current / 2);
//                } else {
//                    outputStreamFile2.write(buffer, 0, current / 2);
//                    outputStreamFile3.write(buffer, current / 2, current / 2);
//                }
//            }
//        } catch (IOException ex) {
//            ex.printStackTrace();
//        }
//    }
//}
