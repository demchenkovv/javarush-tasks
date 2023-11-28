package com.github.demchenkovv.multithreading.level05.lecture09.task2511;

import java.util.TimerTask;

/* 
Вооружаемся до зубов!
*/

public class Solution extends TimerTask {
    protected TimerTask original;
    protected final Thread.UncaughtExceptionHandler handler;

    public Solution(TimerTask original) {
        if (original == null) {
            throw new NullPointerException();
        }
        this.original = original;

        //init handler here
        class MyUncaughtExceptionHandler implements Thread.UncaughtExceptionHandler {
            @Override
            public void uncaughtException(Thread t, Throwable e) {
                // получить текущее имя потока
                String threadName = t.getName();
                // замаскировать текущее имя потока
                String maskedThreadName = threadName.replaceAll(".", "*");
                // найти в строке "текущее имя потока" и заменить на замаскированное имя
                String message = e.getMessage().replace(threadName, maskedThreadName);
                System.out.println(message);
            }
        }
        this.handler = new MyUncaughtExceptionHandler();
    }


    public void run() {
        try {
            original.run();
        } catch (Throwable cause) {
            Thread currentThread = Thread.currentThread();
            handler.uncaughtException(currentThread, new Exception("Blah " + currentThread.getName() + " blah-blah-blah", cause));
        }
    }

    public long scheduledExecutionTime() {
        return original.scheduledExecutionTime();
    }

    public boolean cancel() {
        return original.cancel();
    }

    public static void main(String[] args) {
        Solution solution = new Solution(new TimerTask() {
            @Override
            public void run() {
                throw new NullPointerException();
            }
        });
        solution.run();
    }
}