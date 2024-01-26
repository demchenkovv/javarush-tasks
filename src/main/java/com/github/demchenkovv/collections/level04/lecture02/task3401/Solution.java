package com.github.demchenkovv.collections.level04.lecture02.task3401;

/*
Числа Фибоначчи с помощью рекурсии
*/

/*
Числа Фибоначчи — это последовательность чисел, которые задаются по определённому правилу.
Оно звучит так: каждое следующее число равно сумме двух предыдущих.
Первые два числа заданы сразу и равны 0 и 1.
 */

public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.fibonacci(9));     //34
        System.out.println(solution.fibonacci(5));     //5
        System.out.println(solution.fibonacci(2));     //1
        System.out.println(solution.fibonacci(1));     //1
    }

    public int fibonacci(int n) {
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else {
            return fibonacci(n - 1) + fibonacci(n - 2);
        }
    }
}
