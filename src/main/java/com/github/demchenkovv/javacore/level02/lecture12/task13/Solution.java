package com.github.demchenkovv.javacore.level02.lecture12.task13;

/*
Изоморфы наступают
*/

import java.util.Comparator;
import java.util.stream.IntStream;

public class Solution {
    public static void main(String[] args) throws Exception {
        int[] data = new int[]{1, 2, 3, 5, -2, -8, 0, 77, 5, 5};

        Pair<Integer, Integer> result = getMinimumAndIndex(data);

        System.out.println("The minimum is " + result.x);
        System.out.println("The index of the minimum element is " + result.y);
    }

    public static Pair<Integer, Integer> getMinimumAndIndex(int[] array) {
        if (array == null || array.length == 0) {
            return new Pair<Integer, Integer>(null, null);
        }

        // Решение через стримы
        Pair minPair = IntStream.range(0, array.length) // stream indexes
                .mapToObj(index -> new Pair<>(array[index], index)) // map VALUE (first) and INDEX (second) together using the class
                .min(Comparator.comparing(element -> element.x)) // find minimum by comparing values (first)
                .orElseGet(() -> new Pair<>(Integer.MIN_VALUE, -1)); // supply default value suiting your needs, if array was empty
        return minPair;


        // Решение через стримы, используя Map.entry()
        // Этот способ подойдет, если нет желания использовать отдельный класс (типа Pair)
//        Optional<Map.Entry<Integer, Double>> keyValueOpt = IntStream.range(0, arr.length)
//                .mapToObj(i -> Map.entry(i,arr[i]))
//                .min(Map.Entry.comparingByValue());
//        keyValueOpt.ifPresent(keyValue -> System.out.println(String.format("Index %s with min value %s", keyValue.getKey(), keyValue.getValue())));


        // Решение через цикл for 1
//        Integer minValue = Integer.MAX_VALUE;
//        Integer minIndex = 0;
//        for (int i = 0; i < array.length; i++) {
//            if (array[i] < minValue) {
//                minValue = array[i];
//                minIndex = i;
//            }
//        }
//        return new Pair<Integer, Integer>(minValue, minIndex);

        // Решение через цикл for 2
//        int index = 0;
//        for (int i = 1; i < array.length; i++) {
//            if (array[i] < array[index]) {
//                index = i;
//            }
//        }
//        return new Pair<Integer, Integer>(array[index], index);
//    }
    }

    public static class Pair<X, Y> {
        public X x;
        public Y y;

        public Pair(X x, Y y) {
            this.x = x;
            this.y = y;
        }
    }
}


/*
Изоморфы наступают
Напиши метод, который возвращает минимальное число в массиве
и его позицию (индекс).


Requirements:
1. Класс Solution должен содержать класс Pair.
2. Класс Solution должен содержать два метода.
3. Класс Solution должен содержать метод getMinimumAndIndex().
4. Метод getMinimumAndIndex() должен возвращать минимальное число
в массиве и его позицию (индекс).
 */