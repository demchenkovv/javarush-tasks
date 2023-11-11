package com.github.demchenkovv.multithreading.level02.lecture13.task2;

import java.io.*;
import java.nio.charset.Charset;

/* 
Смена кодировки
*/

public class Solution {

    public static void main(String[] args) throws IOException {
//        args = new String[2];
//        args[0] = "src/main/java/com/github/demchenkovv/multithreading/level02/lecture13/task2/data_win1251.txt";
//        args[1] = "src/main/java/com/github/demchenkovv/multithreading/level02/lecture13/task2/data_utf8.txt";

        Charset win1251 = Charset.forName("Windows-1251");
        Charset utf8 = Charset.forName("UTF-8");
        try (InputStreamReader isr = new InputStreamReader(new FileInputStream(args[0]), win1251);
             BufferedReader reader = new BufferedReader(isr);
             OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream(args[1]), utf8);
             BufferedWriter writer = new BufferedWriter(osw)) {

            while (reader.ready()) {
                writer.write(reader.readLine() + System.lineSeparator());
            }
        }
    }
}


//// Вариант 2. С работой массивом байт в теле try-catch-resources. Без лишних разрывов строк.
//public class Solution {

//    public static void main(String[] args) throws IOException {
//        Charset win1251 = Charset.forName("Windows-1251");
//        Charset utf8 = Charset.forName("UTF-8");
//
//        ByteArrayOutputStream baos = new ByteArrayOutputStream();
//        try (FileInputStream fis = new FileInputStream(args[0]);
//             FileOutputStream fos = new FileOutputStream(args[1])) {
//            while (fis.available() > 0) {
//                baos.write(fis.read());
//            }
//            byte[] byteArray = baos.toByteArray();
//            String strWin = new String(byteArray, win1251);
//            byteArray = strWin.getBytes(utf8);
//            fos.write(byteArray);
//        }
//    }
//}


//// Вариант 3. Валидатор решение ниже не принимает (версия JDK JR не поддерживает конструктор FileReader с кодировкой)
//public class Solution {
//
//    public static void main(String[] args) throws IOException {
//        Charset win1251 = Charset.forName("Windows-1251");
//        Charset utf8 = Charset.forName("UTF-8");
//
//        try (BufferedReader fileReader = new BufferedReader(new FileReader(args[0], win1251));
//             BufferedWriter fileWriter = new BufferedWriter(new FileWriter(args[1], utf8))) {
//
//            StringBuilder stringBuilder = new StringBuilder();
//            while (fileReader.ready()) {
//                stringBuilder.append(fileReader.readLine());
//                stringBuilder.append(System.lineSeparator());
//            }
//            System.out.println(stringBuilder);
//
//            fileWriter.write(stringBuilder.toString());
//        }
//    }
//}
