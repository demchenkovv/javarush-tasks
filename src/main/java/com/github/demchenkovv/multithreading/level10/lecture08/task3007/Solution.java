package com.github.demchenkovv.multithreading.level10.lecture08.task3007;

/* 
Найдем число 2 в максимальной степени
*/

/**
 * <a href="https://tproger.ru/articles/awesome-bits">Хитрости с битовыми операциями</a>
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println(maxPowerOf2(140_000));   //131072
        System.out.println(maxPowerOf2(1026));      //1024
        System.out.println(maxPowerOf2(17));        //16
    }

    // Метод находит максимальное значение степени двойки, которое
    // является подпоследовательностью битового представления числа x.
    public static int maxPowerOf2(int x) {
        x--;
        x |= x >> 1;
        x |= x >> 2;
        x |= x >> 4;
        x |= x >> 8;
        x |= x >> 16;
        x++;
        return x >> 1;

        // Альтернативное решение
//        x |= x >> 1;
//        x |= x >> 2;
//        x |= x >> 4;
//        x |= x >> 8;
//        x |= x >> 16;
//        return x ^ (x >> 1);
    }
}
