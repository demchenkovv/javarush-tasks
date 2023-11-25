package com.github.demchenkovv.multithreading.level05.lecture05.task2506;

public class LoggingStateThread extends Thread {
    private Thread thread;

    public LoggingStateThread(Thread thread) {
        this.thread = thread;
    }

    @Override
    public void run() {
        String oldState = "";
        while (!thread.isInterrupted()) {
            String currentState = thread.getState().name(); // получить текущее состояние потока
            if (!currentState.equals(oldState)) {
                System.out.println(currentState);
                oldState = currentState;
            }
            if (currentState.equals("TERMINATED")) { // условие выхода из цикла
                return;
            }
        }
    }
}