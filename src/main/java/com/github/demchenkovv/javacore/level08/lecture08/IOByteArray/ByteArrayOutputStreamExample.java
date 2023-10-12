package com.github.demchenkovv.javacore.level08.lecture08.IOByteArray;

import java.io.ByteArrayOutputStream;

public class ByteArrayOutputStreamExample {
    public static void main(String[] args) {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        String text = "Hello Wolrd!";
        byte[] buffer = text.getBytes();
        try {
            baos.write(buffer);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        // превращаем массив байтов в строку
        System.out.println(baos.toString());

        // получаем массив байтов и выводим по символьно
        byte[] array = baos.toByteArray();
        for (byte b : array) {
            System.out.print((char) b);
        }
        System.out.println();
    }
}