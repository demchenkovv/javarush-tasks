package com.github.demchenkovv.level13.lecture02.task1;

/*
Изучаем методы класса Collections, часть 1
*/

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {

    public static void main(String[] args) {
        ArrayList<String> src = new ArrayList<>(List.of("Hello", "world"));
        ArrayList<String> dest = new ArrayList<>(List.of("My", "name", "is", "Vit"));

        copy(dest, src);
        System.out.println(dest);

        addAll(dest, "1000", "800");
        System.out.println(dest);

        replaceAll(dest, "1000", "T");
        System.out.println(dest);

    }

    public static void copy(ArrayList<String> destination, ArrayList<String> source) {
        if (destination.size() < source.size()) {
            throw new IndexOutOfBoundsException("Source does not fit in dest");
        }
        Collections.copy(destination, source);
    }

    public static void addAll(ArrayList<String> list, String... strings) {
        Collections.addAll(list, strings);
    }

    public static void replaceAll(ArrayList<String> list, String oldValue, String newValue) {
        Collections.replaceAll(list, oldValue, newValue);
    }
}

/*
В классе Solution объявлены методы:
copy(ArrayList<String>, ArrayList<String>), addAll(ArrayList<String>, String...), replaceAll(ArrayList<String>, String, String).
Тебе нужно переписать их реализацию, используя при этом только соответствующие методы класса Collections.
Параметр String... означает то же, что и String[], только аргументы String можно передавать через запятую.

Требования:
•	В классе Solution должен быть публичный статический метод copy(ArrayList<String>, ArrayList<String>) с типом возвращаемого значения void.
•	В классе Solution должен быть публичный статический метод addAll(ArrayList<String>, String...) с типом возвращаемого значения void.
•	В классе Solution должен быть публичный статический метод replaceAll(ArrayList<String>, String, String) с типом возвращаемого значения void.
•	Метод copy(ArrayList<String>, ArrayList<String>) нужно переписать, используя метод copy класса Collections.
•	Метод addAll(ArrayList<String>, String...) нужно переписать, используя метод addAll класса Collections.
•	Метод replaceAll(ArrayList<String>, String, String) нужно переписать, используя метод replaceAll класса Collections.
 */