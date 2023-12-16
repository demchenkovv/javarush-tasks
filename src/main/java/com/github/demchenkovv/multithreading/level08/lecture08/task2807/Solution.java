package com.github.demchenkovv.multithreading.level08.lecture08.task2807;

/*
Знакомство с ThreadPoolExecutor
*/

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Solution {

    public static void main(String[] args) throws InterruptedException {

        // Создать блокирующую одностороннюю очередь на связанных узлах с задачами.
        // Упорядочивает порядок поступления и выдачи элементов FIFO. Новые элементы
        // вставляются в хвост очереди; операции чтения извлекают элемент из головы очереди.
        LinkedBlockingQueue<Runnable> taskQueue = new LinkedBlockingQueue<>();
        for (int i = 0; i < 10; i++) {
            int localId = i + 1;
            // добавить в очередь 10 задач Runnable (используем лямбда-выражение для краткости)
            taskQueue.add(() -> doExpensiveOperation(localId));
        }

        int corePoolSize = 3;       // основное количество трэдов (ядро)
        int maxPoolSize = 5;        // максимальное количество трэдов
        long keepAliveTime = 1000;  // время удержания трэда живым после завершения работы
        TimeUnit milliseconds = TimeUnit.MILLISECONDS; // тайм-юнит - миллисекунды

        // Создать объект ThreadPoolExecutor и передать аргументы
        ThreadPoolExecutor threadPoolExecutor =
                new ThreadPoolExecutor(corePoolSize, maxPoolSize, keepAliveTime, milliseconds, taskQueue);

        // Запустить все трэды, которые входят в основное количество трэдов (ядро)
        threadPoolExecutor.prestartAllCoreThreads();

        // Запретить добавление новых задач на исполнение в пул
        threadPoolExecutor.shutdown();

        // Дать объекту ThreadPoolExecutor 5 секунд на завершение всех тасок
        threadPoolExecutor.awaitTermination(5, TimeUnit.SECONDS);
    }

    private static void doExpensiveOperation(int localId) {
        System.out.println(Thread.currentThread().getName() + ", localId=" + localId);
    }
}
