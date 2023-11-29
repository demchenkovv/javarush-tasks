package com.github.demchenkovv.multithreading.level05.lecture11.task2514;

/* 
Первый закон Финэйгла: если эксперимент удался, что-то здесь не так...
*/

public class Solution {
    public static class YieldRunnable implements Runnable {
        private int index;

        public YieldRunnable(int index) {
            this.index = index;
        }

        public void run() {
            System.out.println("begin-" + index);
            // текущий поток готов отказаться (но не гарантирует это) от текущего использования процессора,
            // но он хотел бы быть запланированным обратно как можно скорее.
            Thread.yield();
            System.out.println("end-" + index);

        }
    }

    public static void main(String[] args) {
        Thread thread1 = new Thread(new Solution.YieldRunnable(5));
        Thread thread2 = new Thread(new Solution.YieldRunnable(10));
        Thread thread3 = new Thread(new Solution.YieldRunnable(15));

        // порядок вывода не гарантируется
        thread1.start();
        thread2.start();
        thread3.start();
    }
}
