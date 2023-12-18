package com.github.demchenkovv.multithreading.level09.lecture09.task2912;

public class PhoneLogger extends AbstractLogger {

    public PhoneLogger(int level) {
        super(level);
    }

    @Override
    public void info(String message) {
        System.out.println("Call to director: " + message);
    }
}