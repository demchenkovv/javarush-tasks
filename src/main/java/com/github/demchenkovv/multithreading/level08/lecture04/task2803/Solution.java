package com.github.demchenkovv.multithreading.level08.lecture04.task2803;

/*
ThreadLocalRandom
*/

import java.util.concurrent.ThreadLocalRandom;

/**
 * ThreadLocalRandom - это класс для обеспечения генерации псевдослучайных
 * чисел независимую от потока, т.е. для каждого потока своя генерация.
 * Использование ThreadLocalRandom особенно уместно, когда несколько задач
 * (например, каждая из которых является ForkJoinTask) используют случайные
 * числа параллельно в пулах потоков.
 */
public class Solution {

    public static int getRandomIntegerBetweenNumbers(int from, int to) {
        return ThreadLocalRandom.current().nextInt(from, to);
    }

    public static double getRandomDouble() {
        return ThreadLocalRandom.current().nextDouble();
    }

    public static long getRandomLongBetween0AndN(long n) {
        return ThreadLocalRandom.current().nextLong(0, n);
    }

    public static void main(String[] args) {
    }
}
