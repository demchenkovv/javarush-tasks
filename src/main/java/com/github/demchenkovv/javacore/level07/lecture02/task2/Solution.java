package com.github.demchenkovv.javacore.level07.lecture02.task2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Вместе быстрее? Ща проверим :)
*/

public class Solution {
    public static int threadCount = 10;
    public static int[] testArray = new int[1000];

    static {
        for (int i = 0; i < Solution.testArray.length; i++) {
            testArray[i] = i;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        StringBuffer expectedResult = new StringBuffer();
        for (int i = 1000 - 1; i >= 0; i--) {
            expectedResult.append(i).append(" ");
        }

        initThreads();

        StringBuffer result = new StringBuffer();
        for (int i = 0; i < testArray.length; i++) {
            result.append(testArray[i]).append(" ");
        }
        System.out.println(result);
        System.out.println((result.toString()).equals(expectedResult.toString()));
    }

    public static void initThreads() throws InterruptedException {
        List<Thread> threads = new ArrayList<Thread>(threadCount);
        for (int i = 0; i < threadCount; i++) threads.add(new SortThread());
        for (Thread thread : threads) thread.start();
        for (Thread thread : threads) thread.join();
    }

    public static void sort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] < array[j]) {
                    int k = array[i];
                    array[i] = array[j];
                    array[j] = k;
                }
            }
        }
    }

    public static class SortThread extends Thread {

        @Override
        public void run() {
            sort(testArray);
        }
    }
}

/*
Вместе быстрее? Ща проверим :)
1. Разберись, что и как работает.
2. Создай public static нить SortThread, которая в методе run отсортирует статический массив testArray используя метод sort.


Requirements:
1. Класс Solution должен содержать public static класс SortThread.
2. Класс SortThread должен быть нитью.
3. В методе run класса SortThread должен вызывать метод sort() с параметром testArray.
4. Программа должна выводить текст на экран.
 */

/**
 * Задача прелюбопытнейшая для экспериментов.
 * Пришла такая мысль: а почему бы не раздробить массив по количеству нитей и не скормить каждой по отдельности
 * только ее кусок, а в конце слить обратно? Тогда и параллельность, и целостность данных сохранятся, и прирост скорости можно ожидать.
 * Закодил эту идею, увеличил входящий массив для пущего эффекта и таки да! В данной нам реализации массив
 * на 10000 элементов десять нитей ломают как им вздумается порядка 400-500 мс.
 * Эксперимент дал результат на 50ти запусках:
 * - всегда true
 * - время выполнения 25-60 мс
 */