package com.github.demchenkovv.javasyntaxzero.level13.lecture02.task3;

import java.util.ArrayList;
import java.util.Collections;

/*
Изучаем методы класса Collections, часть 3
*/

public class Solution {

    /**
     * Метод min() возвращает минимальный элемент коллекции.
     */
    public static Integer min(ArrayList<Integer> list) {

        return Collections.min(list);

//        Integer minimum = list.get(0);
//        for (int i = 1; i < list.size(); i++) {
//            if (list.get(i) < minimum) {
//                minimum = list.get(i);
//            }
//        }
//        return minimum;
    }

    /**
     * Метод max() возвращает максимальный элемент коллекции.
     */
    public static Integer max(ArrayList<Integer> list) {

        return Collections.max(list);

//        Integer maximum = list.get(0);
//        for (int i = 1; i < list.size(); i++) {
//            if (list.get(i) > maximum) {
//                maximum = list.get(i);
//            }
//        }
//        return maximum;
    }

    /**
     * Метод frequency() подсчитывает, сколько раз в коллекции colls встречается элемент obj
     */
    public static int frequency(ArrayList<Integer> list, Integer element) {

        return Collections.frequency(list, element);

//        int frequency = 0;
//        if (element == null) {
//            return frequency;
//        } else {
//            for (Integer integer : list) {
//                if (element.equals(integer)) {
//                    frequency++;
//                }
//            }
//        }
//        return frequency;
    }

    /**
     * Важно: перед вызовом метода binarySearch() список нужно отсортировать (Collections.sort()).
     * Метод binarySearch() ищет элемент key в списке list. Возвращает номер найденного элемента.
     * Если элемент не найден, возвращает отрицательное число.
     */
    public static int binarySearch(ArrayList<Integer> list, Integer key) {

        Collections.sort(list);
        return Collections.binarySearch(list, key);

//        int low = 0;
//        int high = list.size() - 1;
//        int mid = (low + high) / 2;
//        int index = -1;
//        while (low <= high) {
//            if (list.get(mid) < key) {
//                low = mid + 1;
//            } else if (list.get(mid).equals(key)) {
//                index = mid;
//                break;
//            } else {
//                high = mid - 1;
//            }
//            mid = (low + high) / 2;
//        }
//        return index;
    }
}