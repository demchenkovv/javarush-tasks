package com.github.demchenkovv.level10.lecture05.task1;

/**
 * Очень понравилась задача!
 * Решение - как за одну итерацию объекты со значениями переместить в начало массива
 */

/*
Дефрагментация памяти
*/

import java.util.Arrays;

public class Memory {

    public static void main(String[] args) {
        String[] memory = {"object15", null, null, "object2", null, null, null, "object32", null, "object4"};
        executeDefragmentation(memory);
        System.out.println(Arrays.toString(memory));
    }

    public static void executeDefragmentation(String[] array) {
        int lastNotNullIndex = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] != null) {
                array[lastNotNullIndex] = array[i];
                if (i != lastNotNullIndex) {        // Если текущий индекс равен индексу последней перезаписи,
                    array[i] = null;                // то условие перезаписи не выполняется
                }
                lastNotNullIndex++; // После присвоения нового значения
            }
        }
    }
}


/*
Рассмотрим аналог памяти компьютера на примере массива строк.
Если удалить некоторые элементы, то в массиве появятся так называемые "дыры" - то есть элементы равные null.
Метод executeDefragmentation(String[]), принимающий массив строк, выполняет его "дефрагментацию",
то есть перемещает все объекты в начало массива в таком же порядке, передвинув все "дыры" (элементы равные null)
в конец массива.
В этой задаче тебе нужно реализовать метод executeDefragmentation(String[]).
Метод main() можешь использовать для проверки результата работы метода executeDefragmentation(String[]).

Требования:
•	В классе Memory должен быть метод public static void executeDefragmentation(String[]).
•	Реализуй метод executeDefragmentation(String[]) согласно условию.
 */