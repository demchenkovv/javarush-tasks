package com.github.demchenkovv.collections.level02.lecture06.task3204;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Random;

/* 
Генератор паролей
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        for (int i = 0; i < 2000; i++) {
            ByteArrayOutputStream password = getPassword();
            System.out.println(password.toString());
        }
    }

    public static ByteArrayOutputStream getPassword() throws IOException {
        final char[] numbers = "0123456789".toCharArray();
        final char[] lovercase = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        final char[] uppercase = "ABCDEFGJKLMNPRSTUVWXYZ".toCharArray();
        final char[] allchars = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGJKLMNPRSTUVWXYZ".toCharArray();

        Random random = new Random();

        StringBuilder sb = new StringBuilder();

        // добавить обязательные случайные цифру, букву нижнего и букву верхнего регистра
        sb.append(numbers[random.nextInt(numbers.length)]);
        sb.append(lovercase[random.nextInt(lovercase.length)]);
        sb.append(uppercase[random.nextInt(uppercase.length)]);

        // добавить недостающие 5 символов
        for (int i = 0; i < 5; i++) {
            sb.append(allchars[random.nextInt(allchars.length)]);
        }

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        baos.write(sb.toString().getBytes());
        return baos;
    }
}
