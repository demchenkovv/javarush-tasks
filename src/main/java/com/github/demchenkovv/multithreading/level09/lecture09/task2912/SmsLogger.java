package com.github.demchenkovv.multithreading.level09.lecture09.task2912;

public class SmsLogger extends AbstractLogger {

    public SmsLogger(int level) {
        super(level);
    }

    @Override
    public void info(String message) {
        System.out.println("Send SMS to CEO: " + message);
    }
}