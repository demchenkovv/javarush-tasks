package com.github.demchenkovv.javacore.level04.lecture08.task11;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.nio.file.FileAlreadyExistsException;
import java.util.ArrayList;
import java.util.List;

/*
Нашествие исключений
*/

public class Solution {
    public static List<Exception> exceptions = new ArrayList<Exception>();

    public static void main(String[] args) {
        initExceptions();

        for (Exception exception : exceptions) {
            System.out.println(exception);
        }
    }

    private static void initExceptions() {   //the first exception
        try {
            float i = 1 / 0;

        } catch (Exception e) {
            exceptions.add(e);
            exceptions.add(new ArrayIndexOutOfBoundsException());
            exceptions.add(new StringIndexOutOfBoundsException());
            exceptions.add(new NullPointerException());
            exceptions.add(new ClassCastException());
            exceptions.add(new NegativeArraySizeException());
            exceptions.add(new FileNotFoundException());
            exceptions.add(new IllegalArgumentException());
            exceptions.add(new NoSuchFieldException());
            exceptions.add(new NoSuchFieldException());
        }

        //напишите тут ваш код

    }
}


/*
Нашествие исключений
Заполни список exceptions десятью различными исключениями.
Первое исключение уже реализовано в методе initExceptions.


Requirements:
1. Список exceptions должен содержать 10 элементов.
2. Все элементы списка exceptions должны быть исключениями (потомками класса Throwable).
3. Все элементы списка exceptions должны быть уникальны.
4. Метод initExceptions должен быть статическим.
 */