package com.github.demchenkovv.javacore.level06.lecture13.task3;

/*
Отдебажим все на свете
*/

/**
 * Часть 1 Марлезонского балета.
 * В общем смотрите. Объясняю на пальцах. В первой строчке класса Solution создаётся объект
 * класса OurUncaughtExceptionHandler, который будет обрабатывать наши исключения. Посмотрели,
 * как создаётся, посмотрели сам класс этого объекта, что должно
 * произойти если он сработал. И всё. Теперь разбираемся с программой в главном методе main.
 * Сначала создаётся объект TestedTread. С ним всё замечательно, у него в конструкторе устанавливается наш
 * handler, и, если бы нить прерывалась, то он бы сработал. Но нить не прерывается, Exception не выбрасывается,
 * и handler тут остаётся за кадром.
 * <p>
 * Теперь интереснее. Создаются две нити - threadA и threadB, но они имеют тип просто Thread, а не наш переопределенный TestedThread,
 * потому им переданный в конструктор commonThread "до лампочки" в части отлова исключений. Они ничего не знают
 * про наш конструктор TestedThread, и потому handler просто не видят. Соответственно, threadA и threadB обрабатывают
 * исключения как умеют, по-своему, классом Thread.
 * <p>
 * Часть 2 Марлезонского балета.
 * Читаем доки, что можно сделать:
 * <p>
 * 1.  "Определить свой класс ThreadGroup и переопределить метод uncaughtException()." - это нельзя
 * т.к. наши нити просто нити по условиям задачи.
 * <p>
 * 2. Вызвать статический метод класса Thread — setDefaultUncaughtExceptionHandler(). Это можно. Если вызовем и
 * туда пихнём наш handler, то все нити будут именно им пользоваться. В реальном проекте так делать нельзя. Но знать полезно.
 * <p>
 * 3. Вызвать метод setUncaughtExceptionHandler() у ___объекта___ (у объекта, а не класса!)
 * класса Thread. Берем наши нити threadA и threadB, применяем данный метод и посылаем приветик в виде handler,
 * чтобы они знали как обрабатывать такие исключения.
 */
public class Solution {
    public static Thread.UncaughtExceptionHandler handler = new OurUncaughtExceptionHandler();

    public static void main(String[] args) {
        TestedThread commonThread = new TestedThread(handler);

        Thread threadA = new Thread(commonThread, "Нить 1");
        Thread threadB = new Thread(commonThread, "Нить 2");

        // 1. сюда добавили
        threadA.setUncaughtExceptionHandler(handler);
        threadB.setUncaughtExceptionHandler(handler);

        threadA.start();
        threadB.start();

        threadA.interrupt();
        threadB.interrupt();
    }

    public static class TestedThread extends Thread {
        public TestedThread(Thread.UncaughtExceptionHandler handler) {
            setUncaughtExceptionHandler(handler);
            start();
        }

        public void run() {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException("My exception message");
            }
        }
    }

    public static class OurUncaughtExceptionHandler implements Thread.UncaughtExceptionHandler {
        @Override
        public void uncaughtException(Thread t, Throwable e) {
            System.out.println(t.getName() + ": " + e.getMessage());
        }
    }
}



/*
Отдебажим все на свете
Разобраться, что делает программа.
Почитать про UncaughtExceptionHandler - это важно.
Еще раз внимательно посмотреть программу.
Разобраться - продебажить - почему наш OurUncaughtExceptionHandler не срабатывает.
Исправить ошибку, т.е. все должно работать. :)
Ожидаемый результат в произвольном порядке:
Нить 1: My exception message
Нить 2: My exception message

Requirements:
1. Метод main должен создавать нить с параметрами: commonThread и "Нить 1".
2. Метод main должен создавать нить с параметрами: commonThread и "Нить 2".
3. Метод main должен запускать две созданные нити типа Thread.
4. Метод main должен прерывать две созданные нити типа Thread.
5. Программа с помощью метода uncaughtException класса OurUncaughtExceptionHandler должна вывести 2 сообщения.
6. Метод uncaughtException класса OurUncaughtExceptionHandler явно не вызывать.
7. Вывод программы должен содержать строки: "Нить 1: My exception message" и "Нить 2: My exception message".
 */