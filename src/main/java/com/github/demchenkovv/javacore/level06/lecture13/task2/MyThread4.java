package com.github.demchenkovv.javacore.level06.lecture13.task2;

public class MyThread4 extends Thread implements Message {

    private static boolean isCancel = false;

    @Override
    public void run() {
        while (!isCancel) {
//        while (!this.isInterrupted()) { // эквивалентно while (!isCancel)
            System.out.println("Я работаю!");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                ex.getMessage();
            }
        }
    }

    @Override
    public void showWarning() {
        isCancel = true;
//        this.interrupt(); // эквивалентно isCancel = true;
        System.out.println("Сработал метод MyThread4#showWarning()");
    }
}
