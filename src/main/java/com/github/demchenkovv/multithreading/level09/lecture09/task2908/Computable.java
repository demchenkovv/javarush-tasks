package com.github.demchenkovv.multithreading.level09.lecture09.task2908;

/* Argument and Value are generic types*/
public interface Computable<Argument, Value> {
    Value compute(Argument argument) throws InterruptedException;
}
