package com.github.demchenkovv.multithreading.level07.lecture02.task2702;

/* 
Нужный оператор
*/

/**
 * <a href="https://javarush.com/groups/posts/2877-operatorih-perekhoda-v-java">Операторы перехода в Java</a>
 * <p>
 * Метка в коде определяется весьма просто — через имя и двоеточие. Например:
 * labelName:
 * outerLoop:
 * printing:
 * anyWordYouLike:
 */
public class Solution {
    public static void main(String args[]) {
        label:
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (j > i) {
                    System.out.println();
                    continue label;
                }
                System.out.print("S");
            }
        }
    }
}
