package com.github.demchenkovv.javacore.level02.lecture09.task2;

/*
Лететь, бежать и плыть
*/

public class Solution {
    public static void main(String[] args) {

    }

    //add interfaces here - добавь интерфейсы тут
    public interface CanFly {
        void fly();
    }

    public interface CanRun {
        void run();
    }

    public interface CanSwim {
        void swim();
    }

}


/*
Лететь, бежать и плыть
Напиши public интерфейсы CanFly(летать),
CanRun(бежать/ездить), CanSwim(плавать).
Добавить в каждый интерфейс по одному методу.


Requirements:
1. Класс Solution должен содержать интерфейс CanFly.
2. Класс Solution должен содержать интерфейс CanRun.
3. Класс Solution должен содержать интерфейс CanSwim.
4. Интерфейс CanFly должен содержать один метод.
5. Интерфейс CanRun должен содержать один метод.
6. Интерфейс CanSwim должен содержать один метод.
 */