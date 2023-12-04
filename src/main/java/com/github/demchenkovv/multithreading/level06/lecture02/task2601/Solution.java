package com.github.demchenkovv.multithreading.level06.lecture02.task2601;

/*
Почитать в инете про медиану выборки
*/

/*
Для тестов:
// Четная длина (even)
Integer[] array = {13, 8, 15, 5, 17}; // [13, 15, 17, 8, 5]
Integer[] array = {10, 20, 20, 30, 20, 50, 60, 22}; // [20, 20, 20, 22, 30, 10, 50, 60]

// Нечетная длина (odd)
Integer[] array = {10, 8, 12, 6, 19}; // [10, 8, 12, 6, 19]
Integer[] array = {11, 3, 122, 36, 18, 0, 1}; // [11, 18, 3, 1, 0, 36, 122]
*/


import java.util.Arrays;
import java.util.Comparator;

/**
 * https://en.wikipedia.org/wiki/Median
 */
public class Solution {

    public static void main(String[] args) {
        Integer[] array = {13, 8, 15, 5, 17};
        sort(array);
    }

    /**
     * Сортировать данные в массиве по удаленности от его медианы.
     * <p>
     * Удаленность (расстояние) медианы от какого-то конкретного элемента это разница между этим элементом и медианой.
     * <p>
     * Для того чтобы посчитать расстояние от медианы до каждого элемента в массиве, сначала нужно найти медиану.
     * Затем для каждого элемента в массиве нужно сравнить его значение с медианой и вычислить расстояние (абсолютную разницу) между ними.
     * Если, например, массив содержит числа 1, 2, 3, 4, медиана (среднее значение) будет равно 2.
     * Тогда “удаленность” числа 3 от медианы будет равна 1 (поскольку 3 - 2 = 1).
     */
    public static Integer[] sort(Integer[] array) {
        // Для подсчета медианы нужно сначала упорядочить элементы массива по возрастанию.
        Arrays.sort(array);
//        System.out.println("Array after sorting: \n" + Arrays.toString(array));

        int length = array.length;
        double median;
        // если количество элементов нечетно, то медианой будет средний элемент,
        // а если четно - то это среднее арифметическое двух средних элементов.
        if (length % 2 != 0) {
            median = array[length / 2];
        } else {
            median = (array[length / 2] + array[length / 2 - 1]) / 2.0;
        }

//        System.out.println("median: \n" + median);

        Comparator<Integer> comparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                int value1 = (int) Math.abs(o1 - median); // абсолютная разница (расстояние) от элемента1 до медианы
                int value2 = (int) Math.abs(o2 - median); // абсолютная разница (расстояние) от элемента2 до медианы
                return value1 - value2; // сравнение полученных величин
            }
        };

        Arrays.sort(array, comparator);
//        System.out.println("Array after sorting by distance from median: \n" + Arrays.toString(array));
        return array;
    }
}
