package com.github.demchenkovv.multithreading.level01.lecture02.task3;

/* 
Все гениальное - просто!
*/

public class Solution {
    public static boolean calculate(boolean a, boolean b, boolean c, boolean d) {
        return c;

        // верни true, если
        // 1 1 1 0 или 0 1 или 0 1 или 1 1
        // a может быть 0
        // b может быть 0
        // d может быть 0
        // c может быть 0 и 1
    }

    public static void main(String[] args) {
        boolean a = true;
        boolean b = true;
        boolean c = false;
        boolean d = true;
        System.out.println(calculate(a, b, c, d));
    }
}
