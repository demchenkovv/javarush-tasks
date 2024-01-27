package com.github.demchenkovv.collections.level04.lecture04.task3405;

import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.List;

/*
Мягкие ссылки
*/

public class Solution {
    public static Helper helper = new Helper();

    public static class Monkey {
        private String name;

        public Monkey(String name) {
            this.name = name;
        }

        protected void finalize() {
            Helper.isFinalized = true;
            System.out.format("Bye-Bye, %s!\n", name);
        }
    }

    public static void main(String args[]) throws InterruptedException {
        helper.startTime();

        // Создание объекта Monkey
        Monkey monkey = new Monkey("Simka");

        // Создание мягкой ссылки на объект Monkey
        SoftReference<Monkey> reference = new SoftReference<Monkey>(monkey);

        // Запускает сборщик мусора в виртуальной машине Java.
        helper.callGC();

        // Теперь на объект ссылается только мягкая ссылка reference.
        monkey = null;

        // Запускает сборщик мусора в виртуальной машине Java.
        helper.callGC();

        // Заполняем
        helper.heapConsuming();

        if (reference.get() == null)
            System.out.println("Finalized");

        helper.finish();
    }

    public static class Helper {
        public static boolean isFinalized;

        private long startTime;

        void startTime() {
            this.startTime = System.currentTimeMillis();
        }

        int getTime() {
            return (int) (System.currentTimeMillis() - startTime) / 1000;
        }

        void callGC() throws InterruptedException {
            System.gc();
            Thread.sleep(1000);
        }

        // Имитация заполнения кучи (heap). Добавляет новые объекты типа "Solution"
        // в список "heap" до тех пор, пока не произойдет переполнение памяти (OutOfMemoryError)
        void heapConsuming() {
            try {
                List<Solution> heap = new ArrayList<Solution>(100000);
                while (!isFinalized) {
                    heap.add(new Solution());
                }
            } catch (OutOfMemoryError e) {
                System.out.println("Out of memory error raised");
            }
        }

        public void finish() {
            System.out.println("Done");
            System.out.println("It took " + getTime() + " sec");
        }
    }
}