package com.github.demchenkovv.collections.level02.lecture06.task3211;

import java.io.ByteArrayOutputStream;
import java.io.ObjectOutputStream;
import java.security.MessageDigest;

/* 
Целостность информации
*/

public class Solution {
    public static void main(String... args) throws Exception {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(bos);
        oos.writeObject(new String("test string"));
        oos.flush();
        System.out.println(compareMD5(bos, "5a47d12a2e3f9fecf2d9ba1fd98152eb")); //true

    }

    public static boolean compareMD5(ByteArrayOutputStream byteArrayOutputStream, String md5) throws Exception {

        // Инициализация объекта MessageDigest с передачей в конструктор нужного алгоритма
        MessageDigest digest = MessageDigest.getInstance("MD5");

        // Генерируем хеш для заданного входного сообщения. Хеширование - это процесс
        // преобразования входных данных (обычно текста или байтовых данных) в короткую
        // строку или битовую строку фиксированной длины, которая представляет исходные данные.
        // Метод digest обрабатывает переданные байты с помощью криптографической хеш-функции MD5,
        // чтобы получить MD5 хеш.
        byte[] out = digest.digest(byteArrayOutputStream.toByteArray());

        // Преобразуем хэш-код в формат шестнадцатеричной строки
        StringBuilder sb = new StringBuilder();
        for (byte b : out) {
            sb.append(String.format("%02x", b));
        }

        return sb.toString().equals(md5);
    }
}
