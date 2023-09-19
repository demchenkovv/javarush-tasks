package com.github.demchenkovv.javacore.level02.lecture04.task2;

/*
Int и Integer
*/

public class Solution {
    public static void main(String[] args) {
        print(1);
        Integer integer = Integer.valueOf(3);
        print(integer);
    }

    public static void print(int i) {

    }

    public static void print(Integer i) {

    }
}


/*
Int и Integer
Реализуй два метода: print(int) и print(Integer).
Напиши такой код в методе main(), чтобы вызвались оба.


Requirements:
1. Класс Solution должен содержать статический метод main().
2. Класс Solution должен содержать статический void метод print() с параметром типа int.
3. Класс Solution должен содержать статический void метод print() с параметром типа Integer.
4. Метод main() должен вызывать метод print() с параметром типа int.
5. Метод main() должен вызывать метод print() с параметром типа Integer.
 */