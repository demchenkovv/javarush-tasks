package com.github.demchenkovv.javacore.level10.lecture10.task10;

import java.util.*;

/* 
Алгоритмы-числа
*/

// TODO: Задача не проходит валидацию. Необходимо вернуться и доработать её. Основные моменты:
//  1. Не использовать Math.pow(), т.к. это замедляет программу и на больших числах результат не точен. Старый добрый цикл работает корректней и быстрее в разы.
//  2. Проверяйте число на выход за границы диапазона его значений когда суммируете числа возведенные в степень
//  3. Генерируйте таблицу (двоичный массив) со степенями, это на порядки ускоряет работу программы
//  4. Ссылка на дискуссию https://javarush.com/tasks/com.javarush.task.task20.task2025#discussion
//  5. Количество цифр в целом числе https://www.baeldung.com/java-number-of-digits-in-int
//  6. Создать готовый список чисел Армстронга и сравнивать числа с ним (вариант чисто для валидатора)

public class Solution {

    public static long[] getNumbers(long N) {
        long[] result = null;
        List<Long> list = new ArrayList<>();
        for (long i = 1; i < N; i++) {
            long[] values = parsingNumber(i);
            int pow = values.length;
            long sumValues = 0;
            for (long e : values) {
                sumValues += (long) Math.pow(e, pow);
            }
            if (sumValues == i) {
                list.add(i);
            }
        }
        result = new long[list.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = list.get(i);
        }
        return result;
    }

    private static long[] parsingNumber(long currentNumber) {
//        // Решение на основе строки - самый простой, но ресурсоемкий подход.
//        // Поскольку предполагает выделение памяти для строки для каждой оценки.
//        int length = String.valueOf(currentNumber).length();
        int length = getLengthNumber(currentNumber);
        long[] values = new long[length];
        int i = 0;
        while (currentNumber > 0) {
            values[i++] = currentNumber % 10;
            currentNumber = currentNumber / 10;
        }
        return values;
    }

    // Самый громоздкий для получения длины числа по сравнению со всеми остальными.
    // Однако он также самый быстрый, потому что мы не выполняем никакого преобразования,
    // умножения, сложения или инициализации объекта.
    private static int getLengthNumber(long number) {
        if (number < 100000) {
            if (number < 100) {
                if (number < 10) {
                    return 1;
                } else {
                    return 2;
                }
            } else {
                if (number < 1000) {
                    return 3;
                } else {
                    if (number < 10000) {
                        return 4;
                    } else {
                        return 5;
                    }
                }
            }
        } else {
            if (number < 10000000) {
                if (number < 1000000) {
                    return 6;
                } else {
                    return 7;
                }
            } else {
                if (number < 100000000) {
                    return 8;
                } else {
                    if (number < 1000000000) {
                        return 9;
                    } else {
                        return 10;
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        long a = System.currentTimeMillis();
        System.out.println(Arrays.toString(getNumbers(1000)));
        long b = System.currentTimeMillis();
        System.out.println("memory " + (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) / (8 * 1024));
        System.out.println("time = " + (b - a) / 1000);

        a = System.currentTimeMillis();
        System.out.println(Arrays.toString(getNumbers(1000000)));
        b = System.currentTimeMillis();
        System.out.println("memory " + (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) / (8 * 1024));
        System.out.println("time = " + (b - a) / 1000);
    }
}
