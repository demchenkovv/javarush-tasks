package com.github.demchenkovv.javacore.level02.lecture02.task2;

/*
Кит, коровий потомок
*/

public class Solution {
    public static void main(String[] args) {
        Cow cow = new Whale();

        System.out.println(cow.getName());
    }

    public static class Cow {
        public String getName() {
            return "Я - корова";
        }
    }

    public static class Whale extends Cow {
        @Override
        public String getName() {
            return "";
        }
    }
}

/*
Кит, коровий потомок
Переопредели метод getName в классе Whale(Кит), чтобы программа выводила на экран пустую строку.


Requirements:
1. Программа должна выводить на экран пустую строку.
2. Класс Whale должен наследоваться от класса Cow.
3. Класс Whale должен переопределять метод getName().
4. Метод main() должен вызывать метод getName() у объекта cow.
5. Реализуй метод getName() класса Whale, чтобы программа выводила на экран пустую строку.
6. Метод main() должен выводить на экран результат вызова метода getName().
 */