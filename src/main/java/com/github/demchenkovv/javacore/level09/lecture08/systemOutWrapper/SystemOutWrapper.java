package com.github.demchenkovv.javacore.level09.lecture08.systemOutWrapper;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

/** Пишем свой ридер-обертку на System.out */
public class SystemOutWrapper {
    public static void main(String[] args) throws Exception
    {
        //запоминаем настоящий PrintStream в специальную переменную
        PrintStream consoleStream = System.out;

        //Создаем динамический массив
        //Создаем динамический массив (а можем FileInputStream или другой вывод)
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        //создаем адаптер к классу PrintStream
        PrintStream stream = new PrintStream(outputStream);
        //Устанавливаем его как текущий System.out
        System.setOut(stream);

        //Вызываем функцию, которая ничего не знает о наших манипуляциях
        printSomething();

        //Преобразовываем записанные в наш ByteArray данные в строку
        String result = outputStream.toString();

        //Возвращаем все как было
        System.setOut(consoleStream);

        //разворачиваем строку
        StringBuilder stringBuilder = new StringBuilder(result);
        stringBuilder.reverse();
        String reverseString = stringBuilder.toString();

        //выводим ее в консоль
        System.out.println(reverseString);
    }

    public static void printSomething()
    {
        System.out.println("Hi");
        System.out.println("My name is Amigo");
        System.out.println("Bye-bye!");
    }
}
