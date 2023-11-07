package com.github.demchenkovv.multithreading.level02.lecture05.chainedExceptions;

/**
 * Цепочка исключений методом initCause()
 */
public class ChainExcDemo {

    static void demoproc() {
        // создать исключение
        NullPointerException е = new NullPointerException("верхний уровень");
        // добавить причину
        е.initCause(new ArithmeticException("причина"));
        throw е;
    }


    public static void main(String args[]) {
        try {
            demoproc();
        } catch (NullPointerException e) {
            // отобразить исключение верхнего уровня
            System.out.println("Перехвачено: " + e);
            // отобразить исключение-причину
            System.out.println("Исходная причина: " + e.getCause());
        }
    }
}