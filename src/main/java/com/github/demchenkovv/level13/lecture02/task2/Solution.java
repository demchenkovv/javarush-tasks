package com.github.demchenkovv.level13.lecture02.task2;

import java.util.ArrayList;
import java.util.Random;
import java.util.Collections;

/*
Изучаем методы класса Collections, часть 2
*/

public class Solution {

    /**
     * Метод reverse() меняет порядок переданных в него элементов списка на обратный.
     */
    public static void reverse(ArrayList<Integer> list) {
        Collections.reverse(list);

//        for (int i = 0, j = list.size() - 1; i < list.size() / 2; i++) {
//            Integer integer = list.get(i);
//            list.set(i, list.get(j - i));
//            list.set(j - i, integer);
//        }
    }

    /**
     * Метод sort() сортирует переданный в него список по возрастанию.
     */
    public static void sort(ArrayList<Integer> list) {
        Collections.sort(list);

//        int n = list.size();
//        int temp;
//        for (int i = 0; i < n; i++) {
//            for (int j = 1; j < (n - i); j++) {
//                if (list.get(j - 1) > list.get(j)) {
//                    temp = list.get(j - 1);
//                    list.set(j - 1, list.get(j));
//                    list.set(j, temp);
//                }
//            }
//        }
    }

    /**
     * Метод rotate() циклическим образом сдвигает переданные в него элементы на distance позиций вперед.
     */
    public static void rotate(ArrayList<Integer> list, int distance) {
        Collections.rotate(list, distance);

//        for (int i = 0; i < distance; i++) {
//            list.add(0, list.get(list.size() - 1));
//            list.remove(list.size() - 1);
//        }
    }

    /**
     * Метод shuffle() случайным образом перемешивает все элементы переданного списка. Результат каждый раз разный.
     */
    public static void shuffle(ArrayList<Integer> list) {
        Collections.shuffle(list);

//        Random rand = new Random();
//        for (int i = 0; i < list.size(); i++) {
//            int randomIndexToSwap = rand.nextInt(list.size());
//            int temp = list.get(randomIndexToSwap);
//            list.set(randomIndexToSwap, list.get(i));
//            list.set(i, temp);
//        }
    }
}