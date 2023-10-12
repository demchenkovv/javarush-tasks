package com.github.demchenkovv.javacore.level08.lecture08.IOByteArray;

import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Передача массива байт в другой поток с помощью метода writeTo, который принимает объект реализации OutputStream out.
 * Для объектов ByteArrayInputStream и ByteArrayOutputStream не надо явным образом закрывать поток с помощью метода close.
 */
public class FileOutputStreamExample {
    public static void main(String[] args) {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        String text = "Hello World!";
        byte[] buffer = text.getBytes();
        try {
            baos.write(buffer);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        // После выполнения этой программы в папке с программой появится файл hello.txt, который будет содержать строку "Hello World!".
        try (FileOutputStream fos = new FileOutputStream("hello.txt")) {
            // С помощью метода writeTo мы можем вывести массив байт в другой поток.
            baos.writeTo(fos);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
