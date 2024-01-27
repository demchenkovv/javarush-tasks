package com.github.demchenkovv.collections.level04.lecture02.task3403;

/*
Разложение на множители с помощью рекурсии

Простое число — это число, которое делится только на само себя и единицу. Любое натуральное число n,
большее единицы, можно разложить на произведение простых чисел, причем это разложение единственно с
точностью до порядка следования сомножителей.
 */

public class Solution {

    public void recursion(int n) {
        int divider = 2;
        int remainder = n % divider;
        while (n > 1) {
            if (remainder == 0) {
                System.out.print(divider + " ");
                recursion(n / divider);
                break;
            } else {
                divider++;
                remainder = n % divider;
            }
        }
    }

    public static void main(String[] args) {
        new Solution().recursion(12); // 2 2 3
//        new Solution().recursion(132); // 2 2 3 11
//        new Solution().recursion(4); // 2 2
//        new Solution().recursion(2); // 2
    }
}
