package com.github.demchenkovv.javacore.level08.lecture11.task7;

/*
Объединение файлов
*/

import java.io.*;


public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName1 = reader.readLine();
        String fileName2 = reader.readLine();

        // В классе ByteArrayOutputStream метод write записывает в поток некоторые данные (массив байтов).
        // Этот массив байтов записывается в объекте ByteArrayOutputStream в защищенное поле buf.
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try (FileInputStream fileInputStream1 = new FileInputStream(fileName1);
             FileInputStream fileInputStream2 = new FileInputStream(fileName2)) {

            while (fileInputStream2.available() > 0) {
                byteArrayOutputStream.write(fileInputStream2.read());
            }
            while (fileInputStream1.available() > 0) {
                byteArrayOutputStream.write(fileInputStream1.read());
            }
        }
        // С помощью метода writeTo можно перенаправить массив байт в другой поток.
        // Данный метод в качестве параметра принимает объект OutputStream, в который
        // производится запись массива байт.
        try (FileOutputStream fileOutputStream = new FileOutputStream(fileName1)) {
            byteArrayOutputStream.writeTo(fileOutputStream);
        }

        // Для ByteArrayOutputStream не надо явным образом закрывать поток с помощью метода close.
    }
}

//// Альтернативное решение
//public class Solution {
//    public static void main(String[] args) throws IOException {
//        String file1;
//        String file2;
//        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
////            file1 = reader.readLine();
////            file2 = reader.readLine();
//        }
//        List<String> dataFile1 = new ArrayList<>();
//        try (BufferedReader fileReader = new BufferedReader(new FileReader(file1))) {
//            while (fileReader.ready()) {
//                dataFile1.add(fileReader.readLine());
//            }
//        }
//
//        List<String> dataFile2 = new ArrayList<>();
//        try (BufferedReader fileReader = new BufferedReader(new FileReader(file2))) {
//            while (fileReader.ready()) {
//                dataFile2.add(fileReader.readLine());
//            }
//        }
//
//        try (BufferedWriter fileWriter = new BufferedWriter(new FileWriter(file1))) {
//            for (String s2 : dataFile2) {
//                fileWriter.write(s2);
//            }
//            for (String s1 : dataFile1) {
//                fileWriter.write(s1);
//            }
//        }
//    }
//}
