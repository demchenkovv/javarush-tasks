package com.github.demchenkovv.multithreading.level09.lecture09.task2912;

public class FileLogger extends AbstractLogger {

    public FileLogger(int level) {
        super(level);
    }

    @Override
    public void info(String message) {
        System.out.println("Logging to file: " + message);
    }
}