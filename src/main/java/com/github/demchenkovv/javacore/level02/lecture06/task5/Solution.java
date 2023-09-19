package com.github.demchenkovv.javacore.level02.lecture06.task5;

/*
Кошки не должны быть абстрактными!
*/

public class Solution {
    public static void main(String[] args) {

    }

    public static abstract class Pet {
        public abstract String getName();

        public abstract Pet getChild();
    }

    public static class Cat extends Pet {
        @Override
        public String getName() {
            return "Cat";
        }

        @Override
        public Pet getChild() {
            return new Cat();
        }
    }

    public static class Dog extends Pet {
        @Override
        public String getName() {
            return "Dog";
        }

        @Override
        public Pet getChild() {
            return new Dog();
        }
    }
}

/*
Кошки не должны быть абстрактными!
Унаследуй классы Cat и Dog от Pet.
Реализуй недостающие методы. Классы Cat и Dog не должны быть абстрактными.


Requirements:
1. Класс Pet должен быть абстрактным.
2. Класс Dog не должен быть абстрактным.
3. Класс Cat не должен быть абстрактным.
4. Класс Dog должен наследоваться от класса Pet и реализовывать его абстрактные методы.
5. Класс Cat должен наследоваться от класса Pet и реализовывать его абстрактные методы.
 */