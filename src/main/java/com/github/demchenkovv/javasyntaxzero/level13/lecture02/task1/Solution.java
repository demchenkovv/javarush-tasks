package com.github.demchenkovv.javasyntaxzero.level13.lecture02.task1;

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

    /**
     * Важно:
     * Коллекция destination должна иметь длину не меньше, чем длина коллекции source
     * (иначе кинется исключение IndexOutOfBoundsException).
     * @param destination назначение (куда копировать)
     * @param source источник (откуда копировать)
     */
    public static void copy(ArrayList<String> destination, ArrayList<String> source) {
        if (destination.size() < source.size()) {
            throw new IndexOutOfBoundsException("Source does not fit in dest");
        }
        Collections.copy(destination, source);

//        for (int i = 0; i < source.size(); i++) {
//            destination.set(i, source.get(i));
//        }
    }

    /**
     * Метод Collections.addAll(Collection<T> colls, T e1, T e2, T e3, ...)
     * Метод addAll() добавляет в коллекцию colls элементы e1, e2, e3, ...
     * Количество переданных элементов может быть любым.
     * @param list коллекция для добавления
     * @param strings элементы для добавления
     */
    public static void addAll(ArrayList<String> list, String... strings) {
        Collections.addAll(list, strings);

//        for (String string : strings) {
//            list.add(string);
//        }
    }

    /**
     * Метод replaceAll() заменяет все элементы коллекции list, равные oldValue, на элемент newValue.
     * @param list коллекция для изменения
     * @param oldValue старое значение
     * @param newValue новое значение
     */
    public static void replaceAll(ArrayList<String> list, String oldValue, String newValue) {
        Collections.replaceAll(list, oldValue, newValue);

//        for (int i = 0; i < list.size(); i++) {
//            String string = list.get(i);
//            if(string.equals(oldValue)) {
//                list.set(i, newValue);
//            }
//        }
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