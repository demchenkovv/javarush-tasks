package com.github.demchenkovv.multithreading.level02.lecture05.chainedExceptions;

/**
 * Цепочка исключений через собственное исключение, путем передачи в конструктор причину исключения
 */
public class ChainExcDemo2 {

    static int demoproc(int num1, int num2) throws MyException {
        int result;
        try {
            result = num1 / num2;
        } catch (ArithmeticException ex) {
            throw new MyException(ex);
        }
        return result;
    }


    public static void main(String args[]) throws MyException {
        try {
            demoproc(1, 0);
        } catch (MyException ex) {
//            System.out.println("Перехвачено: " + ex.getClass().getCanonicalName());
            System.out.println("Перехвачено: " + ex.getClass().getSimpleName());
            System.out.println("Исходная причина: " + ex.getCause());
        }
    }


    public static class MyException extends Exception {

        public MyException(Throwable cause) {
            super(cause);
        }
    }
}