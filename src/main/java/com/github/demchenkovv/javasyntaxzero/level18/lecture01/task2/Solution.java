package com.github.demchenkovv.javasyntaxzero.level18.lecture01.task2;

import java.util.ArrayList;
import java.util.Collections;

/*
Прощание с foreach
*/

public class Solution {
    public static void main(String[] args) {
        var strings = new ArrayList<String>();
        Collections.addAll(strings, "Hello", "Amigo", "JavaRush", "CodeGym");

        print(strings);
    }

    public static void print(ArrayList<String> strings) {
        for (int i = 0; i < strings.size(); i++) {
            System.out.println(strings.get(i));
        }
    }
}
/*
В классе Solution публичный метод print(ArrayList<String>) выводит
в консоли все элементы списка по порядку.
Сейчас метод реализован с использованием метода списка forEach().
Необходимо переписать реализацию метода print(ArrayList<String>),
используя оператор for, не меняя логику работы метода.

Метод main() не принимает участие в тестировании.

Требования:
•	В методе print(ArrayList<String>) нужно использовать оператор for.
•	В методе print(ArrayList<String>) не нужно использовать метод списка forEach().
•	В методе print(ArrayList<String>) нужно выводить в консоли все элементы полученного списка по порядку.
 */