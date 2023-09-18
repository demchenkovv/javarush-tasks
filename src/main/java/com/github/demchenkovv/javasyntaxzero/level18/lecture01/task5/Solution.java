package com.github.demchenkovv.javasyntaxzero.level18.lecture01.task5;

import java.util.ArrayList;
import java.util.Collections;

/*
Преобразование списка в массив
*/

public class Solution {

    public static void main(String[] args) {
        var strings = new ArrayList<String>();
        Collections.addAll(strings, "Ты", "ж", "программист");

        var integers = new ArrayList<Integer>();
        Collections.addAll(integers, 1000, 2000, 3000);


        String[] stringArray = toStringArray(strings);
        for (String string : stringArray) {
            System.out.println(string);
        }

        Integer[] integerArray = toIntegerArray(integers);
        for (Integer integer : integerArray) {
            System.out.println(integer);
        }
    }

    public static String[] toStringArray(ArrayList<String> strings) {
        return strings.toArray(String[]::new);
    }

    public static Integer[] toIntegerArray(ArrayList<Integer> integers) {
        return integers.toArray(Integer[]::new);
    }
}

/*
В классе Solution есть два публичных статических метода:

String[] toStringArray(ArrayList<String>), в котором нужно преобразовать список строк
в массив строк и вернуть его;
Integer[] toIntegerArray(ArrayList<Integer>), в котором нужно преобразовать список
чисел в массив чисел и вернуть его.
Для преобразования списка в массив используй метод списка toArray(), в который нужно
передать ссылку на конструктор массива, тип которого соответствует типу списка.
Метод main() не принимает участие в тестировании.

Требования:
В методе toStringArray(ArrayList<String>) у полученного в качестве аргумента списка
нужно вызывать метод toArray(), в который передается ссылка на конструктор массива,
тип которого соответствует типу списка.
Нужно, чтобы метод toStringArray(ArrayList<String>) возвращал массив строк с теми же
элементами и в том же порядке, что и в полученном списке.
В методе toIntegerArray(ArrayList<Integer>) у полученного в качестве аргумента списка
нужно вызывать метод toArray(), в который передается ссылка на конструктор массива, тип
которого соответствует типу списка.
Нужно, чтобы метод toIntegerArray(ArrayList<Integer>) возвращал массив чисел с теми же
элементами и в том же порядке, что и в полученном списке.
 */