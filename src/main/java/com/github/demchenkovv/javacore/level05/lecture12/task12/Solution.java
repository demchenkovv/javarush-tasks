package com.github.demchenkovv.javacore.level05.lecture12.task12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Arrays;

/*
Парсер реквестов
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

//        String string = reader.readLine();

//        String string = "http://javarush.ru/alpha/index.html?obj=3.14&name=Amigo" // obj name -- double: 3.14
//        String string = "http://javarush.ru/alpha/index.html?lvl=15&view&name=Amigo"; // lvl view name
        String string = "http://javarush.ru/alpha/index.html?obj=3.14&name=Amigo"; // lvl view name

        //        String[] split = url.split("&|\\?");

        URL url = new URL(string);
        String query = url.getQuery(); // Возвращается: часть запроса этого URL-адреса или null, если таковой не существует

        String[] params = query.split("&");

        // Первый цикл - возвращает параметры
        for (String s : params) {
            if (s.contains("=")) {
                System.out.print(s.substring(0, s.indexOf("=")) + " ");
            } else
                System.out.print(s + " ");
        }

        System.out.println();

        // Второй цикл - проверяет на наличие параметра obj и запускает метод alert(...)
        for (String s : params) {
            if (s.contains("obj")) {
                String value = s.substring(4); // Важно! Условие не сработает, если obj без параметров
                try {
                    alert(Double.parseDouble(value));
                } catch (Exception ex) {
                    alert(value);
                }
            }
        }
    }

    public static void alert(double value) {
        System.out.println("double: " + value);
    }

    public static void alert(String value) {
        System.out.println("String: " + value);
    }
}


/*
Парсер реквестов
Для решения этой задачи тебе нужно:
1. Считать с консоли URL-ссылку.
2. Вывести на экран список всех параметров через пробел (Параметры идут после ? и разделяются &, например, lvl=15).
    URL содержит минимум 1 параметр.
    Выводить параметры нужно в той же последовательности, в которой они представлены в URL.
3. Если присутствует параметр obj, то передать его значение в нужный метод alert():
    alert(double value) - для чисел (не забывай о том, что число может быть дробным);
    alert(String value) - для строк.
    Обрати внимание на то, что метод alert() необходимо вызывать после вывода списка всех параметров на экран.
Пример 1

Ввод:
http://javarush.ru/alpha/index.html?lvl=15&view&name=Amigo

Вывод:
lvl view name

Пример 2

Ввод:
http://javarush.ru/alpha/index.html?obj=3.14&name=Amigo

Вывод:
obj name
double: 3.14


Requirements:
1. Программа должна считывать с клавиатуры только одну строку.
2. Класс Solution не должен содержать статические поля.
3. Программа должна выводить данные на экран в соответствии с условием.
4. Программа должна вызывать метод alert() с параметром double, если значение параметра obj можно корректно преобразовать в число типа double.
5. Программа должна вызывать метод alert() с параметром String, если значение параметра obj нельзя корректно преобразовать в число типа double.
 */