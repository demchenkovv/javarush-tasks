package com.github.demchenkovv.javacore.level02.lecture09.task4;

/*
Создаем человека
*/

public class Solution {
    public static void main(String[] args) {

    }

    public interface CanFly {
        public void fly();
    }

    public interface CanRun {
        public void run();
    }

    public interface CanSwim {
        public void swim();
    }


    public class Human implements CanSwim, CanRun {
        @Override
        public void run() {

        }

        @Override
        public void swim() {

        }
    }

    public class Duck implements CanRun, CanFly, CanSwim {
        @Override
        public void fly() {

        }

        @Override
        public void run() {

        }

        @Override
        public void swim() {

        }
    }

    public class Penguin implements CanSwim, CanRun {
        @Override
        public void run() {

        }

        @Override
        public void swim() {

        }
    }

    public class Airplane implements CanFly {
        @Override
        public void fly() {

        }
    }
}


/*
Создаем человека
Есть public интерфейсы CanFly (летать), CanRun (бежать/ездить), CanSwim (плавать).
Добавь эти интерфейсы классам Human (человек), Duck (утка), Penguin (пингвин), Airplane (самолет), и не забудь про реализацию методов интерфейсов (в методах ничего делать не нужно).


Requirements:
1. Класс Solution должен содержать интерфейс CanFly с одним методом fly().
2. Класс Solution должен содержать интерфейс CanRun с одним методом run().
3. Класс Solution должен содержать интерфейс CanSwim с одним методом swim().
4. Человек должен уметь бегать и плавать.
5. Утка должна уметь летать, плавать и бегать.
6. Пингвин должен уметь плавать и бегать.
7. Самолет должен уметь летать.
 */