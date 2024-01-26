package com.github.demchenkovv.collections.level04.lecture02.task3402;

/*
Факториал с помощью рекурсии
*/

/*
Факториалом натурального числа n называется произведение всех натуральных чисел от 1 до n. Обозначается как n!
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.factorial(-9));     //362880
        System.out.println(solution.factorial(0));     //1
        System.out.println(solution.factorial(1));     //1
    }

    public int factorial(int n) {
        if (n < 0) {
            System.out.println("Ошибка. Передано отрицательное число " + n);
            return -1;
        }
        if (n == 0) {
            return 1;
        } else {
            return factorial(n - 1) * n;
        }
    }
}