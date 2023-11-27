package com.github.demchenkovv.multithreading.level05.lecture09.task2510;

/* 
Поживем - увидим
*/

public class Solution extends Thread {

    // Оператор instanceof проверяет, является ли параметр 'e' наследником конкретного исключения.
    // Проверку на Throwable ставим в самый конец (else),
    // поскольку Throwable является базовым классом для всех исключений.
    public Solution() {
        this.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
            @Override
            public void uncaughtException(Thread t, Throwable e) {
                if (e instanceof Error) {
                    System.out.println("Нельзя дальше работать");
                } else if (e instanceof Exception) {
                    System.out.println("Надо обработать");
                } else
                    System.out.println("Поживем - увидим");
            }
        });
    }

//    // test code
//    @Override
//    public void run() {
//        throw new IllegalArgumentException();
//    }

    public static void main(String[] args) {
//        Solution solution = new Solution();
//        solution.start();
    }
}
