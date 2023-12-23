package com.github.demchenkovv.multithreading.level10.lecture06.task3013;

/* 
Битовые операции
*/

/**
 * <a href="https://habr.com/ru/articles/93172/">Алгоритмы поиска старшего бита</a>
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int number = Integer.MAX_VALUE - 133;
//        int number = 1751;
        System.out.println(Integer.toString(number, 2));

        String result = Integer.toString(solution.resetLowerBits(number), 2);
        System.out.println(result);
    }

    public int resetLowerBits(int number) {
        number |= number >> 1;
        number |= number >> 2;
        number |= number >> 4;
        number |= number >> 8;
        number |= number >> 16;
        return number - (number >> 1);

        // Например, пусть number == 1751
        // number                == 00000000 00000000 00000110 11010111
        // number >> 1           == 00000000 00000000 00000011 01101011
        // number | number >> 1  == 00000000 00000000 00000111 11111111

        // number                == 00000000 00000000 00000111 11111111
        // number >> 2           == 00000000 00000000 00000000 11011010
        // number | number >> 2  == 00000000 00000000 00000111 11111111

        // number                == 00000000 00000000 00000111 11111111
        // number >> 4           == 00000000 00000000 00000000 00001101
        // number | number >> 4  == 00000000 00000000 00000111 11111111

        // number                == 00000000 00000000 00000111 11111111
        // number >> 8           == 00000000 00000000 00000000 00000000
        // number | number >> 8  == 00000000 00000000 00000111 11111111

        // number                == 00000000 00000000 00000111 11111111
        // number >> 16          == 00000000 00000000 00000000 00000000
        // number | number >> 16 == 00000000 00000000 00000111 11111111

        // number                   == 111 11111111
        // number >> 1              == 011 11111111
        // number - (number >> 1)   == 100 00000000
    }
}