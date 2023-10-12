package com.github.demchenkovv.javacore.level08.lecture08.IOByteArray;

import java.io.ByteArrayInputStream;

/**
 *  Для объектов ByteArrayInputStream и ByteArrayOutputStream не надо явным образом закрывать поток с помощью метода close.
 */
public class ByteArrayInputStreamExample {
    public static void main(String[] args) {
        byte[] array1 = new byte[]{1, 3, 5, 7};
        ByteArrayInputStream byteStream1 = new ByteArrayInputStream(array1);
        int b;
        while ((b = byteStream1.read()) != -1) {
            System.out.println(b);
        }
        String text = "Hello world!";
        byte[] array2 = text.getBytes();
        // считываем 5 символов
        ByteArrayInputStream byteStream2 = new ByteArrayInputStream(array2, 0, 5);
        int c;
        while ((c = byteStream2.read()) != -1) {
            System.out.println((char) c);
        }
    }

//        StringBuilder sb = new StringBuilder();
//        sb.append("Anna\n");
//        sb.append("Lena\n");
//        sb.append("Sveta\n");
//
//        String data = sb.toString();
//
//        InputStream is = new ByteArrayInputStream(data.getBytes());
//
//        System.setIn(is);
//
//        readAndPrinf();
//    }
//
//    private static void readAndPrinf() throws IOException {
//        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//
//        while (true) {
//            String line = reader.readLine();
//            if (line == null) {
//                break;
//            }
//            System.out.println(line);
//        }
//        reader.close();
//    }
}
