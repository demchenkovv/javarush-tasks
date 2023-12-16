package com.github.demchenkovv.multithreading.level08.lecture08.task2812;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* 
ShutdownNow!
*/

public class Solution {

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(5);
        for (int i = 1; i <= 10; i++) {
            final int localId = i;
            executor.submit(new Runnable() {
                public void run() {
                    doExpensiveOperation(localId);
                }
            });
        }

        // Основное отличие между shutdown и shutdownNow заключается в том,
        // как они обрабатывают текущие задачи:
        // shutdown ждет их завершения, а shutdownNow прерывает их выполнение.
        // Это означает, что задачи могут не закончить свое выполнение корректно,
        // и может потребоваться дополнительная обработка ошибок.
        List<Runnable> uncompletedTasks = executor.shutdownNow();
        for (Runnable r : uncompletedTasks) {
            System.out.println(r + " was not completed");
        }
    }

    private static void doExpensiveOperation(int localId) {
        System.out.println(Thread.currentThread().getName() + ", localId=" + localId);
    }
}
