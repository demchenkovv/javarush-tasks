package com.github.demchenkovv.multithreading.level08.lecture04.task2802;

/*
Пишем свою ThreadFactory
*/

/*
Для решения задачи и пониманий устройства фабрики необходимо провалиться в реализацию
интерфейса ThreadFactory. В описании найти и пройти по ссылке Executors.defaultThreadFactory.
Провалится в реализацию класса DefaultThreadFactory (фабрика нитей по умолчанию).
Ссылка на доп. материал https://wilddiary.com/understanding_custom_threadfactory_in_java/
 */

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

public class Solution {

    public static void main(String[] args) {
        class EmulatorThreadFactoryTask implements Runnable {
            @Override
            public void run() {
                emulateThreadFactory();
            }
        }

        ThreadGroup group = new ThreadGroup("firstGroup");
        Thread thread = new Thread(group, new EmulatorThreadFactoryTask());

        ThreadGroup group2 = new ThreadGroup("secondGroup");
        Thread thread2 = new Thread(group2, new EmulatorThreadFactoryTask());

        thread.start();
        thread2.start();
    }

    private static void emulateThreadFactory() {
        AmigoThreadFactory factory = new AmigoThreadFactory();
        Runnable r = new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
            }
        };
        factory.newThread(r).start();
        factory.newThread(r).start();
        factory.newThread(r).start();
    }

    public static class AmigoThreadFactory implements ThreadFactory {
        // Ключевое слово static привязывает переменную к классу и может выступать в роли каунтера (счетчика).
        // Ключевое слово final у ссылочных переменных позволяет изменять состояние объекта, но не ссылку.
        private static final AtomicInteger poolNumber = new AtomicInteger(1);
        private final AtomicInteger threadNumber = new AtomicInteger(1);
        private final ThreadGroup group;
        private final String namePrefix;

        // В нашем случае создается два объекта, в каждом из которых по три потока. Следовательно,
        // первый объект получит poolNumber 1 и будет инкрементирован; второй объект - poolNumber 2.
        AmigoThreadFactory() {
            group = Thread.currentThread().getThreadGroup(); // получить текущую группу потоков
            namePrefix = "-pool-" + poolNumber.getAndIncrement() + "-thread-";
        }

        // Каждый объект имеет threadNumber. После создания нового потока поле threadNumber будет инкрементироваться.
        public Thread newThread(Runnable r) {
            Thread t = new Thread(group, r, group.getName() + namePrefix + threadNumber.getAndIncrement(), 0);
            t.setDaemon(false);
            t.setPriority(Thread.NORM_PRIORITY);
            return t;
        }
    }
}
