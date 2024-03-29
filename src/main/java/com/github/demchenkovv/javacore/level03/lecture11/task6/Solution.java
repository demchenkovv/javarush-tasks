package com.github.demchenkovv.javacore.level03.lecture11.task6;

/*
Исправление ошибок
*/

public class Solution {

    public static void main(String[] args) {
        System.out.println(Dream.HOBBY.toString());
        System.out.println(new Hobby().INDEX);
    }

    interface Desire {
    }

    interface Dream {
        public static Hobby HOBBY = new Hobby();
    }

    static class Hobby implements Desire, Dream {
        static int INDEX = 1;

        @Override
        public String toString() {
            INDEX++;
            return "" + INDEX;
        }
    }

}


/*
Исправление ошибок
Переделай наследование в классах и интерфейсах так, чтобы программа компилировалась и продолжала делать то же самое.
Класс Hobby должен реализовывать интерфейсы Desire, Dream.


Requirements:
1. Интерфейс Desire должен быть реализован в классе Hobby.
2. Интерфейс Dream должен быть реализован в классе Hobby.
3. Класс Hobby должен содержать статическую переменную INDEX.
4. Метод toString в классе Hobby должен инкрементировать и возвращать переменную INDEX в виде строки.
 */