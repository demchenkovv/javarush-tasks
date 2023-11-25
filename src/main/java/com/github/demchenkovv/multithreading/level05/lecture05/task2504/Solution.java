package com.github.demchenkovv.multithreading.level05.lecture05.task2504;

/* 
Switch для нитей
*/

public class Solution {
    public static void processThreads(Thread... threads) {
        //implement this method - реализуйте этот метод
        for (Thread thread : threads) {
            // !Через лямбду валидатор не примет, поскольку используется
            switch (thread.getState()) {
                // нить не запущена, нужно ее запустить
                case NEW:
                    thread.start();
                    break;
                // нить находится в ожидании, нужно ее прервать
                case WAITING:
                case TIMED_WAITING:
                case BLOCKED:
                    thread.interrupt();
                    break;
                // нить работает, нужно проверить маркер isInterrupted
                case RUNNABLE:
                    thread.isInterrupted();
                    break;
                // нить завершила работу, нужно вывести в консоль ее приоритет
                case TERMINATED:
                    System.out.println(thread.getPriority());
                    break;
            }
        }
    }

    public static void main(String[] args) {
    }
}