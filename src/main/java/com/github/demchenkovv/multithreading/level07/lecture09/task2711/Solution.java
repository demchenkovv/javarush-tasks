package com.github.demchenkovv.multithreading.level07.lecture09.task2711;

import java.util.concurrent.CountDownLatch;

/* 
CountDownLatch
*/

/**
 * https://java-online.ru/concurrent-synchronizers.xhtml
 */
public class Solution {
    CountDownLatch latch = new CountDownLatch(1);

    public void someMethod() {
        retrieveValue();
        // Метод уменьшения счетчика latch на 1
        latch.countDown();
        try {
            // Метод самоблокировки. Метод await блокирует поток
            // до тех пор, пока счетчик CountDownLatch не обнулится.
            latch.await();
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }

    void retrieveValue() {
        System.out.println("Value retrieved.");
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        new Thread(solution::someMethod).start();
        new Thread(solution::someMethod).start();
    }
}