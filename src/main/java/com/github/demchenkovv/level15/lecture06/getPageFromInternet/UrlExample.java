package com.github.demchenkovv.level15.lecture06.getPageFromInternet;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

/**
 * Получение странички из интернета
 */
public class UrlExample {
    public static void main(String[] args) throws IOException {

        URL url = new URL("https://javarush.com"); // Создает объект URL с путем к странице
        InputStream input = url.openStream(); // Получает InputStream у интернет-объекта
        byte[] buffer = input.readAllBytes(); // Читает все байты и возвращает массив байт
        String str = new String(buffer); // Преобразуем массив в строку
        System.out.println(str); // Выводим строку на экран

    }
}
