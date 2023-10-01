package com.github.demchenkovv.javacore.level06.lecture13.task2;

public class MyThread2 extends Thread {

    @Override
    public void run() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            System.out.println("InterruptedException");
        }
    }
}
