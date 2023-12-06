package com.github.demchenkovv.multithreading.level06.lecture10.task2611;

import java.util.concurrent.ConcurrentHashMap;

public class Producer implements Runnable {
    private ConcurrentHashMap<String, String> map;

    public Producer(ConcurrentHashMap<String, String> map) {
        this.map = map;
    }

    @Override
    public void run() {
        try {
            int count = 1;
            while (true) {
                map.put(String.valueOf(count), "Some text for " + count);
                count++;
                Thread.sleep(500);
            }
        } catch (InterruptedException ex) {
            System.out.println(Thread.currentThread().getName() + " thread was terminated");
        }
    }
}
