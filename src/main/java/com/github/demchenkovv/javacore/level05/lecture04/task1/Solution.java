package com.github.demchenkovv.javacore.level05.lecture04.task1;

/*
Что-то лишнее
*/

/**
 * Сначала примитив расширяется:
 * byte->short->int->long->float->double.
 * <p>
 * Если не найдёт подходящий метод, то потом упаковывается в свой объект
 * (int->Integer , short -> Short и.т.д) и ищет именно его.
 * <p>
 * Если не находит, сужается (уже будучи объектом) до Number и затем до Object.
 * <p>
 * По-моему так.
 */
public class Solution {
    public static void main(String[] args) {
        print((short) 1);
        print((Number) 1);
        print(1);
        print((Integer) 1);
        print((int) 1);
    }

    public static void print(Integer i) {
        System.out.println("Это Integer");
    }

//    public static void print(int i) {
//        System.out.println("Это Integer");
//    }

    public static void print(Short i) {
        System.out.println("Это Object");
    }

    public static void print(Object i) {
        System.out.println("Это Object");
    }

    public static void print(double i) {
        System.out.println("Это double");
    }

    public static void print(Double i) {
        System.out.println("Это double");
    }

//    public static void print(float i) {
//        System.out.println("Это Double");
//    }
}


/*
Что-то лишнее
Удали реализации всех лишних методов, чтобы вывод программы выглядел так:
Это double
Это Object
Это double
Это Integer
Это double


Requirements:
1. В классе Solution должен остаться метод print() с одним параметром типа Integer.
2. В классе Solution должен остаться метод print() с одним параметром типа Object.
3. В классе Solution должен остаться метод print() с одним параметром типа double.
4. Вывод на экран должен соответствовать условию.
 */