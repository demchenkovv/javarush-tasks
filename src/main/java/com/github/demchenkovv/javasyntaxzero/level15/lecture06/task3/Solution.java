package com.github.demchenkovv.javasyntaxzero.level15.lecture06.task3;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;

/*
Получение информации по API
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        URL url = new URL("http://httpbin.org/post");
        //напишите тут ваш код
        URLConnection connection = url.openConnection(); // Создаем двустороннее соединение
        connection.setDoOutput(true); // вывод данных из URL - разрешен

        try (OutputStream output = connection.getOutputStream(); // получили поток для отправки данных
             InputStream input = connection.getInputStream()) { // получили поток для чтения данных

            byte[] buffer = input.readAllBytes();
            String str = new String(buffer);
            System.out.println(str);
        }
    }
}

/*
Твоя задача — обратиться к публичному API в интернете: отправить и получить данные.
Напиши программу, которая будет обращаться по ссылке к публичному API в интернете,
отправляя туда данные, получать ответные данные и выводить их на экран.

Подсказки:

Используй метод openConnection() класса URL.
Используй методы setDoOutput(true) и getOutputStream() класса URLConnection.
Если не знаешь, какой API использовать, бери http://httpbin.org/post.
Требования:
•	Программа должна выводить полученную информацию на экран.
•	В программе должен вызываться метод openConnection() класса URL.
•	В программе должны вызываться методы setDoOutput(true), getOutputStream() и getInputStream() класса URLConnection.
 */

/*
Сначала мы устанавливаем стабильное двустороннее соединение с помощью метода URLConnection openConnection()
Затем получаем поток для отправки данных с помощью метода connection.getOutputStream() и отправляем данные серверу
Затем получаем поток для чтения данных с помощью метода connection.getInputStream() и начинаем читать из него данные.
 */
