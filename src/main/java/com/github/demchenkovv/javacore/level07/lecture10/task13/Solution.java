package com.github.demchenkovv.javacore.level07.lecture10.task13;

/* 
Посчитаем
*/

public class Solution {
    public static void main(String[] args) throws InterruptedException {
        Counter counter1 = new Counter();
        Counter counter2 = new Counter();
        Counter counter3 = new Counter();
        Counter counter4 = new Counter();

        counter1.start();
        counter2.start();
        counter3.start();
        counter4.start();

        // Если 1 поток уже выполнил всю работу, то другие потоки не пройдут по условию цикла (getCount() < 100).
        // Метод getCount() будет всегда возвращать 100 если хоть 1 поток дошёл до этой отметки.
        // Так что join-ить остальные потоки не имеет смысла.
        counter1.join();
//        counter2.join();
//        counter3.join();
//        counter4.join();

        for (int i = 1; i <= 100; i++) {
            if (values[i] != 1) {
                System.out.println("Массив values содержит элементы неравные 1");
                break;
            }
        }
    }

    public static Integer count = 0;
    public static int[] values = new int[105];

    static {
        for (int i = 0; i < 105; i++) {
            values[i] = 0;
        }
    }

    public static void incrementCount() {
        count++;
        System.out.println(Thread.currentThread().getName() + " : " + getCount()); // смотрим имя потока, который инкрементировал count
    }

    public static int getCount() {
        return count;
    }

    public static class Counter extends Thread {
        @Override
        public void run() {
            do {
                synchronized (values) {
                    incrementCount();
                    // Массив уже проинициализирован в статическом блоке
                    // значением 0. Меняем значение на "текущее + 1"
                    values[getCount()]++; // равносильно values[getCount()] += 1;
                }

                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                }
            } while (getCount() < 100);
        }
    }
}
