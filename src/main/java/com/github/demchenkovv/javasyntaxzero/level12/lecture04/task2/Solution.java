package com.github.demchenkovv.javasyntaxzero.level12.lecture04.task2;

import java.util.ArrayList;

/**
 * Удаление элементов из ArrayList
 * Элементы нужно или удалять с конца, или просто в одном и том же месте,
 * а после каждого удаления элементы будут сдвигаться на один.
 */
public class Solution {

    public static void main(String[] args) {

        ArrayList<Integer> list = new ArrayList<Integer>();

        for (int i = 1; i <= 20; i++)           // Цикл по всем числам от 1 до 20
            if (i % 2 == 0)                     // если число делится на 2 без остатка,
                list.add(i);                    // добавить его в список.

        for (int i = 0; i < list.size(); i++)   // Цикл от нуля до размера списка
            if (list.get(i) % 4 == 0) {         // если элемент списка делится на 4 без остатка:
                list.remove(i);                 // а) удаляем элемент
                i--;                            // б) уменьшаем счетчик i, чтобы на следующем витке цикла опять попасть на тот же элемент
            }


        // Как еще можно удалить элементы:

        // Вариант 1
//        int n = list.size();
//        list.remove(n - 3);
//        list.remove(n - 3);
//        list.remove(n - 3);

        // Вариант 2
//        int n = list.size();
//        list.remove(n - 1);
//        list.remove(n - 2);
//        list.remove(n - 3);
    }
}
