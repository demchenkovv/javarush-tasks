package com.github.demchenkovv.javacore.level04.lecture08.task12;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
НОД
*/

/**
 * <a href=https://www.baeldung.com/java-greatest-common-divisor>Finding Greatest Common Divisor in Java</a>
 */

public class Solution {

    public static void main(String[] args) throws Exception {

        InputStreamReader inputStreamReader = new InputStreamReader(System.in);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

        int n1 = Integer.parseInt(bufferedReader.readLine());
        int n2 = Integer.parseInt(bufferedReader.readLine());

//        Решение 1 - Brute Force
        System.out.println(gcdByBruteForce(n1, n2));

//        Решение 2 - Euclid’s Algorithm
        System.out.println(gcdByEuclidsAlgorithm(n1, n2));

//        Решение 3 - От авторов JavaRush
        System.out.println(getNOD(n1, n2));

    }

    /**
     * Решение 1 - Brute Force
     */
    // Для нашего первого подхода мы выполняем итерацию от 1 до наименьшего заданного числа и
    // проверяем, делятся ли заданные целые числа на индекс. Наибольшим индексом, который делит
    // заданные числа, является GCD заданных чисел.
    // Как мы можем видеть, сложность приведенной реализации равна O(min(n1, n2)),
    // потому что нам нужно выполнить итерацию по циклу n раз (что эквивалентно меньшему числу),
    // чтобы найти GCD.
    public static int gcdByBruteForce(int n1, int n2) {
        if (n1 <= 0 || n2 <= 0)
            throw new IllegalArgumentException("Введено отрицательное число");

        int gcd = 1;
        for (int i = 1; i <= n1 && i <= n2; i++) {
            if (n1 % i == 0 && n2 % i == 0)
                gcd = i;
        }
        return gcd;
    }

    /**
     * Решение 2 - Euclid’s Algorithm
     */
// Во-вторых, мы можем использовать алгоритм Евклида, чтобы найти GCD. Алгоритм Евклида не только
// эффективен, но и прост для понимания и простой реализации с использованием рекурсии на Java.
// Метод Евклида основан на двух важных теоремах:
// Во–первых, если мы вычтем меньшее число из большего, GCD не изменится - следовательно, если мы
// продолжим вычитание числа, то в конечном итоге получим их GCD
// Во-вторых, когда меньшее число точно делит большее число, меньшее число является GCD из двух
// заданных чисел.
// Обратите внимание, что в нашей реализации мы будем использовать по модулю вместо вычитания,
// поскольку в основном это много вычитаний за раз.
//
// Также обратите внимание, как мы используем n2 в позиции n1 и используем остаток в позиции n2
// на рекурсивном шаге алгоритма.
//
// Кроме того, сложность алгоритма Евклида равна O (Log min (n1, n2)), что лучше по сравнению с
// методом Brute Force, который мы видели ранее.
    public static int gcdByEuclidsAlgorithm(int n1, int n2) {
        if (n2 == 0) {
            return n1;
        }
        return gcdByEuclidsAlgorithm(n2, n1 % n2);
    }

    /**
     * От авторов JavaRush
     */
    private static int getNOD(int n1, int n2) {
        if (n1 < 1 || n2 < 1) {
            throw new IllegalArgumentException();
        }

        while (n1 != n2) {
            if (n1 > n2) {
                n1 -= n2;
            }
            if (n2 > n1) {
                n2 -= n1;
            }
        }
        return n1;
    }
}

/*
НОД
Давай найдем наибольший общий делитель (НОД). Для этого:
Введи с клавиатуры 2 целых положительных числа.
Выведи в консоли наибольший общий делитель.

Requirements:
1. Программа должна считывать с клавиатуры 2 строки.
2. Программа должна выводить данные на экран.
3. Программа должна выводить на экран наибольший общий делитель (НОД) чисел,
считанных с клавиатуры, и успешно завершаться.
 */