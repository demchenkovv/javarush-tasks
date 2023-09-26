package com.github.demchenkovv.javacore.level05.lecture02.task5;

/*
ООП - исправь ошибки в наследовании
*/

public class Solution {
    public interface HasWeight {
        int getWeight();
    }

    public interface HasHeight {
        int getHeight();
    }

    public static class Human implements HasWeight, HasHeight {
        @Override
        public int getWeight() {
            return 80;
        }

        @Override
        public int getHeight() {
            return 180;
        }
    }

    public static void main(String[] args) {
        Human human = new Human();
        System.out.println(human.getHeight());
        System.out.println(human.getWeight());
    }
}

/*
ООП - исправь ошибки в наследовании
У каждого человека есть рост и вес. Класс Human реализует соответствующие интерфейсы. Но, похоже, в такой реализации закралась ошибка. Обрати внимание на вывод программы. Исправь ошибки в интерфейсах (подсказка: переименуй методы, согласно требований к задаче) и, соответственно, в остальном коде. На экран должны быть выведены рост и вес человека (любые положительные целые числа).


Requirements:
1. Метод int getValue() интерфейса HasWeight должен быть переименован в getWeight.
2. Метод int getValue() интерфейса HasHeight должен быть переименован в getHeight.
3. В классе Human должны быть переопределены методы getWeight и getHeight. Каждый из них должен возвращать любое целое число больше 0.
4. В классе Human не должно быть метода getValue.
5. В методе main у объекта класса human должны вызываться методы getWeight и getHeight.
 */