package com.github.demchenkovv.javacore.level06.lecture13.task2;

public class MyThread3 extends Thread {

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            System.out.println("Ура");
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
