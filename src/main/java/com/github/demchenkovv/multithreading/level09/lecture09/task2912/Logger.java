package com.github.demchenkovv.multithreading.level09.lecture09.task2912;

public interface Logger {
    void inform(String message, int level);

    void setNext(Logger next);

    void info(String message);
}