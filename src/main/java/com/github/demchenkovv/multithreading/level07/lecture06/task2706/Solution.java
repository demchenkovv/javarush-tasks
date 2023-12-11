package com.github.demchenkovv.multithreading.level07.lecture06.task2706;

/* 
Убираем deadlock
*/

public class Solution {
    public void safeMethod(Object obj1, Object obj2) {
        // Очередность блокировки мьютексов определяется значением hash code.
        // Первым блокируется тот, чей hash code больше.
        // Если hash code одинаковый, то стоит добавить дополнительный монитор синхронизации.
        // Подробнее: https://javarush.com/groups/posts/1422-vzaimnaja-blokirovkadeadlock-v-java-i-metodih-borjhbih-s-ney
        Object lock1 = System.identityHashCode(obj1) > System.identityHashCode(obj2) ? obj1 : obj2;
        Object lock2 = System.identityHashCode(obj1) > System.identityHashCode(obj2) ? obj2 : obj1;
        synchronized (lock1) {
            longTimeMethod();
            synchronized (lock2) {
                unsafeMethod(obj1, obj2);
            }
        }
    }

    public void longTimeMethod() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException ignored) {
        }
    }

    protected void unsafeMethod(Object obj1, Object obj2) {
        System.out.println(obj1 + " " + obj2);
    }

    public static void main(String[] args) {
        final Object o1 = new Object();
        final Object o2 = new Object();
        final Solution solution = new Solution();

        new Thread() {
            @Override
            public void run() {
                solution.safeMethod(o1, o2);
            }
        }.start();

        new Thread() {
            @Override
            public void run() {
                solution.safeMethod(o2, o1);
            }
        }.start();
    }
}
