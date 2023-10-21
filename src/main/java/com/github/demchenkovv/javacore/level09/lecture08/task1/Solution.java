package com.github.demchenkovv.javacore.level09.lecture08.task1;

/*
Ридер обертка
*/

import java.io.*;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        // Запоминаем настоящий PrintStream (тот что выдает результат в консоль) в специальную переменную
        PrintStream consoleStreamOut = System.out;

        // Создаем динамический массив
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

        // Создаем адаптер к классу PrintStream
        PrintStream stream = new PrintStream(outputStream);

        //Устанавливаем его как текущий System.out
        System.setOut(stream);

        // Вызываем функцию, которая ничего не знает о наших манипуляциях
        testString.printSomething();

        // Преобразовываем записанные в наш ByteArray данные в строку
        // Модифицируем строку согласно заданию
        String result = outputStream.toString().toUpperCase();

        // Возвращаем все как было (для вывода информации в консоль)
        System.setOut(consoleStreamOut);

        // выводим полученную строку в консоль
        System.out.println(result);

    }

    public static class TestString {
        public void printSomething() {
            System.out.println("it's a text for testing");
        }
    }
}
