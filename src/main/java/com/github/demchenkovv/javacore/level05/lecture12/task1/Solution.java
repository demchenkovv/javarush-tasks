package com.github.demchenkovv.javacore.level05.lecture12.task1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
Осваивание статического блока
*/

public class Solution {
    public static void main(String[] args) {

    }

    static {
        //add your code here - добавьте код тут
        reset();
    }

    public static CanFly result;

    public static void reset() {
        //add your code here - добавьте код тут
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(isr);

        try {
            String line = reader.readLine();

            if (line.equals("helicopter")) {
                result = new Helicopter();
            } else if (line.equals("plane")) {
                int numberOfPassengers = Integer.parseInt(reader.readLine());
                result = new Plane(numberOfPassengers);
            }

            reader.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}


/*
Осваивание статического блока
В этой задаче тебе нужно:
Создать в отдельных файлах классы Plane и Helicopter, реализующие интерфейс CanFly.
Класс Plane должен иметь конструктор с параметром int - количество перевозимых пассажиров.
В статическом методе reset() класса Solution:
считать с консоли параметр типа String;
если параметр равен "helicopter", статическому объекту CanFly result присвоить объект класса Helicopter;
если параметр равен "plane", считать второй параметр типа int (количество пассажиров), статическому объекту CanFly result присвоить объект класса Plane.
В статическом блоке инициализировать CanFly result, вызвав метод reset().
Закрыть поток ввода методом close().

Requirements:
1. Класс Plane должен быть создан в отдельном файле и реализовывать интерфейс CanFly.
2. Класс Helicopter должен быть создан в отдельном файле и реализовывать интерфейс CanFly.
3. Класс Plane должен иметь конструктор с параметром int.
4. В классе Solution должен быть реализован метод public static void reset().
5. Метод reset() должен считывать строки с клавиатуры.
6. Если введенная строка равна "helicopter", в переменную result должен быть сохранен объект типа Helicopter.
7. Если введенная строка равна "plane", в переменную result должен быть сохранен объект типа Plane.
8. Поле result класса Solution должно быть инициализировано в статическом блоке путем вызова метода reset().
 */