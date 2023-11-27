package com.github.demchenkovv.multithreading.level05.lecture07.task2509;

import java.util.concurrent.*;

/* 
Все не так легко, как кажется
*/

/** Класс Solution расширяет класс ThreadPoolExecutor и переопределяет метод newTaskFor,
 чтобы позволить нашему интерфейсу CancellableTask создать свой собственный экземпляр Future */
public class Solution extends ThreadPoolExecutor {
    public Solution(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue) {
        super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue);
    }

    protected <T> RunnableFuture<T> newTaskFor(Callable<T> callable) {
        if (callable instanceof CancellableTask) {
            return ((CancellableTask<T>) callable).newTask();
        } else {
            return super.newTaskFor(callable);
        }
    }

    public static void main(String[] args) {
    }
}
