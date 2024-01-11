package com.github.demchenkovv.collections.level02.lecture04.task3202;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;

/* 
Читаем из потока
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        StringWriter writer = getAllDataFromInputStream(new FileInputStream("testFile.log"));
        System.out.println(writer.toString());
    }

    // Без использования BufferedReader
    public static StringWriter getAllDataFromInputStream(InputStream is) {
        StringWriter writer = new StringWriter();
        try {
            byte[] buffer = new byte[1024];
            int len;
            while (is.available() > 0) {
                len = is.read(buffer);
                String line = new String(buffer, 0, len);
                writer.write(line);
            }
        } catch (Exception ex) {
            return new StringWriter();
        }
        return writer;
    }

//    // С использованием BufferedReader
//    public static StringWriter getAllDataFromInputStream(InputStream is) throws IOException {
//        StringWriter writer = new StringWriter();
//        try (BufferedReader reader = new BufferedReader(new InputStreamReader(is));) {
//            String line;
//            while ((line = reader.readLine()) != null) {
//                writer.write(line + System.lineSeparator());
//            }
//        } catch (Exception e) {
//            return new StringWriter();
//        }
//        return writer;
//    }
}
