package com.github.demchenkovv.level12.lecture02.task6;

/*
Сортировка пузырьком
*/

import java.util.ArrayList;
import java.util.Arrays;

public class Solution {

    public static int[] numbers = {56, 45, 89, 1, 45, 13, 4, 69, 11, -89};

    public static void main(String[] args) {
        print();
        sort();
        System.out.println("\nОтсортированные числа в натуральном порядке:");
        print();
    }

    /**
     * Внешним циклом проходимся по всему массиву, а внутренним отсекаем самый крайний индекс методом вычитания
     * переменной i внешнего цикла. Мы так делаем, т.к. при каждой итерации больший массив всегда будет в самом
     * конце массива.
     */
    public static void sort() {
        // Проходимся по всему массиву
        for (int i = 0; i < numbers.length - 1; i++) {
            // Отсекаем крайний индекс путем вычитания i, т.к. при итерации больший массив всегда будет в самом конце
            // и его уже нет смысла сравнивать
            for (int j = 0; j < numbers.length - i - 1; j++) {
                if (numbers[j] > numbers[j + 1]) {
                    int temp = numbers[j];
                    numbers[j] = numbers[j + 1];
                    numbers[j + 1] = temp;
                }
            }
        }
    }

    public static void print() {
        for (int number : numbers) {
            System.out.print(number + "\t");
        }
    }
}

/*
Перед тобой программа, которая сортирует элементы списка по возрастанию методом "пузырька".
Перепиши код, чтобы вместо списка ArrayList<Integer> numbers использовался массив int[] numbers.
Методы main() и print() не принимают участие в проверке.

Требования:
•	Поле numbers должно быть типа int[].
•	Поле numbers должно инициализироваться десятью числами при создании.
•	Метод sort() должен сортировать элементы массива int[] numbers по возрастанию.
 */