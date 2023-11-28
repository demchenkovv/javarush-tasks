package com.github.demchenkovv.multithreading.level05.lecture09.task2512;

/*
Живем своим умом
*/

import java.util.LinkedList;
import java.util.List;

public class Solution implements Thread.UncaughtExceptionHandler {

    @Override
    public void uncaughtException(Thread t, Throwable e) {
        // Прервать нить, которая бросила исключение
        t.interrupt();

        // Вывести в консоль стек исключений, начиная с самого вложенного.

        // Вариант 1. Без рекурсии.
        // LinkedList - вставка и удаление О(1)
        List<Throwable> throwableList = new LinkedList<>();
        Throwable throwable = e;
        while (throwable != null) {
            // добавляем текущее исключение в начало списка, чтобы достичь нужного вывода (FILO)
            throwableList.add(0, throwable);
            // getCause() - получаем исключение, сохраненное внутри объекта (может быть null)
            throwable = throwable.getCause();
        }
        // У Throwable уже переопределен метод toString в нужном нам формате, поэтому применять
        // дополнительное форматирование строк не требуется. Т.о. просто выводим на экран элементы
        throwableList.forEach(System.out::println);


//        // Вариант 2. Через рекурсию.
//        if (e.getCause() != null) {
//            uncaughtException(t, e.getCause());
//        }
//        System.out.println(e);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.uncaughtException(Thread.currentThread(),
                new Exception("ABC", new RuntimeException("DEF", new IllegalArgumentException("GHI"))));
    }
}
