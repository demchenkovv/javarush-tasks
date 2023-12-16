package com.github.demchenkovv.multithreading.level08.lecture08.task2806;

/*
Знакомство с Executors
*/

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Solution {
    public static void main(String[] args) throws InterruptedException {

        // Создать фиксированный пул из 5 трэдов
        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 10; i++) {
            int finalI = i + 1;
            fixedThreadPool.submit(new Runnable() {
                @Override
                public void run() {
                    doExpensiveOperation(finalI);
                }
            });
        }

        // Запретить добавление новых задач на исполнение в пул.
        fixedThreadPool.shutdown();

        // Дать пулу 5 секунд на завершение всех задач
        fixedThreadPool.awaitTermination(5, TimeUnit.SECONDS);

        /* output example
pool-1-thread-2, localId=2
pool-1-thread-1, localId=1
pool-1-thread-3, localId=3
pool-1-thread-1, localId=7
pool-1-thread-1, localId=9
pool-1-thread-4, localId=4
pool-1-thread-5, localId=5
pool-1-thread-2, localId=6
pool-1-thread-1, localId=10
pool-1-thread-3, localId=8
         */
    }

    private static void doExpensiveOperation(int localId) {
        System.out.println(Thread.currentThread().getName() + ", localId=" + localId);
    }
}
