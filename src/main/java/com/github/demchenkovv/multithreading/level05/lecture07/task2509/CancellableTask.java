package com.github.demchenkovv.multithreading.level05.lecture07.task2509;

import java.util.concurrent.Callable;
import java.util.concurrent.RunnableFuture;

public interface CancellableTask<T> extends Callable<T> {
    void cancel();

    // фабричный метод для построения экземпляра RunnableFuture
    RunnableFuture<T> newTask();
}