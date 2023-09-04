package com.github.demchenkovv.other.stackTraceElementDemo;
/**
 * Класс StackTraceElement, как следует из его названия, создан для того,
 * чтобы хранить информацию по одному элементу stack trace — т.е. по одному методу из StackTrace.
 * Благодаря методам класса StackTraceElement можно получить более полную информацию о текущем стеке вызовов.
 */
public class StackTraceElementDemo {
    public static void main(String[] args) {
        test();
    }

    public static void test() {
        Thread current = Thread.currentThread();
        StackTraceElement[] methods = current.getStackTrace();

        for (StackTraceElement info : methods) {
            System.out.println("getClassName() =\t" + info.getClassName());         // Возвращает имя класса
            System.out.println("getMethodName() =\t" + info.getMethodName());       // Возвращает имя метода

            System.out.println("getFileName() =\t\t" + info.getFileName());         // Возвращает имя файла (в одном файле может быть много классов)
            System.out.println("getLineNumber()\t\t" + info.getLineNumber());       // Возвращает номер строки в файле, в которой был вызов метода

            System.out.println("getModuleName() = \t" + info.getModuleName());       // Возвращает имя модуля (может быть null)
            System.out.println("getModuleVersion() = " + info.getModuleVersion());   // Возвращает версию модуля (может быть null)
            System.out.println();
        }
    }
}