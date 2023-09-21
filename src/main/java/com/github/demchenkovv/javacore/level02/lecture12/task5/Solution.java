package com.github.demchenkovv.javacore.level02.lecture12.task5;

/*
Посетители
*/

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static void main(String[] args) {
        System.out.println(getObjectType(new Cat()));
        System.out.println(getObjectType(new Tiger()));
        System.out.println(getObjectType(new Lion()));
        System.out.println(getObjectType(new Bull()));
        System.out.println(getObjectType(new Cow()));
        System.out.println(getObjectType(new Animal()));
    }

    public static String getObjectType(Object o) {
        // Более изящное решение без if-else
        Map<Class<? extends Animal>, String> classes = new HashMap<>();
        classes.put(Cat.class, "Кот");
        classes.put(Tiger.class, "Тигр");
        classes.put(Lion.class, "Лев");
        classes.put(Bull.class, "Бык");
        classes.put(Cow.class, "Корова");
        return classes.getOrDefault(o.getClass(), "Животное");

        // Тривиальное решение
//        if (o.getClass() == Cat.class) return "Кот";
//        else if(o.getClass() == Tiger.class) return "Тигр";
//        else if(o.getClass() == Lion.class) return "Лев";
//        else if(o.getClass() == Bull.class) return "Бык";
//        else if(o.getClass() == Cow.class) return "Корова";
//        return "Животное";
    }

    public static class Cat extends Animal { //<--Классы наследуются!!

    }

    public static class Tiger extends Cat {
    }

    public static class Lion extends Cat {
    }

    public static class Bull extends Animal {
    }

    public static class Cow extends Animal {
    }

    public static class Animal {
    }
}


/*
Посетители
Напиши метод, который определяет, какой объект в него передали.
Программа должна выводить на экран одну из надписей: «Кот», «Тигр», «Лев», «Бык», «Корова», «Животное».

Примечание: постарайся определять тип животного как можно более точно.


Requirements:
1. Класс Solution должен содержать классы Cat, Tiger, Lion, Bull, Cow, Animal.
2. Класс Solution должен содержать метод String getObjectType(Object o).
3. Метод getObjectType() должен возвращать строку "Кот", если передан объект типа Cat.
4. Метод getObjectType() должен возвращать строку "Тигр", если передан объект типа Tiger.
5. Метод getObjectType() должен возвращать строку "Лев", если передан объект типа Lion.
6. Метод getObjectType() должен возвращать строку "Бык", если передан объект типа Bull.
7. Метод getObjectType() должен возвращать строку "Корова", если передан объект типа Cow.
8. Метод getObjectType() должен возвращать строку "Животное", если передан объект типа Animal.
9. Программа должна выводить на экран результат метода getObjectType().
 */