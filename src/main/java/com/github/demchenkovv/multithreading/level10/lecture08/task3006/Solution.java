package com.github.demchenkovv.multithreading.level10.lecture08.task3006;

/* 
Swap по-новому
*/

/**
 * <a href="https://www.baeldung.com/java-swap-two-variables">Swap Two Variables in Java</a>
 */
public class Solution {
    public static void main(String[] args) {
        /* expected output
        x=4, y=5
        x=5, y=4
         */

        Pair pair = new Pair(4, 5);
        System.out.println(pair);
        pair.swap();
        System.out.println(pair);
    }
}
