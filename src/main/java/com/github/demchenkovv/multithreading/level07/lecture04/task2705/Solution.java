package com.github.demchenkovv.multithreading.level07.lecture04.task2705;

/* 
Второй вариант deadlock
*/

public class Solution {
    private final Object lock = new Object();
//    public static int count = 0; // счетчик для тестов

    public synchronized void firstMethod() {
        synchronized (lock) {
            doSomething();
        }
    }

    public void secondMethod() {
        synchronized (lock) {
            synchronized (this) {
                doSomething();
            }
        }
    }

    private void doSomething() {
//        System.out.println(count + " : " + Thread.currentThread().getName()); // для тестов
    }

    public static void main(String[] args) {
//        // код для тестов
//        Solution sol = new Solution();
//        for (int i = 0; i < 100; i++) {
//            new Thread(sol::secondMethod).start();
//            new Thread(sol::firstMethod).start();
//        }
    }
}