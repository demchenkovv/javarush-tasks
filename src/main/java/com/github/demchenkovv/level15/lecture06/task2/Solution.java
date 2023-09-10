package com.github.demchenkovv.level15.lecture06.task2;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

/*
Получение информации по API
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        URL url = new URL("https://javarush.ru/api/1.0/rest/projects");
        //напишите тут ваш код
        try (InputStream input = url.openStream()) {
            byte[] buffer = input.readAllBytes();
            String str = new String(buffer);
            System.out.println(str);
        }
    }
}

/*
Твоя задача — обратиться к публичному API в интернете и получить данные.
Напиши программу, которая будет обращаться по ссылке к публичному API в интернете,
получать данные и выводить их на экран.

Подсказки: Используй метод openStream() класса URL.
Если не знаешь, какой API использовать, можешь запросить у нас на сервере список проектов-игр:
https://javarush.com/api/1.0/rest/projects
Требования:
•	Программа должна выводить полученную информацию на экран.
•	В программе должен вызываться метод openStream() класса URL.
 */