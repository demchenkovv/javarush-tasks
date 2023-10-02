package com.github.demchenkovv.javacore.level05.lecture09.task5;

/*
Статики и котики
*/

public class Solution {
    public static Cat cat;

    public static class Cat {

        public String name;

    }

    static {
        cat = new Cat();
        cat.name = "MeowCatName";
        System.out.println(cat.name);
    }

    public static void main(String[] args) {

    }
}


/*
Статики и котики
В этой задаче тебе нужно:
1. Создать класс Cat с публичным полем name типа String в классе Solution.
2. В статическом блоке создать объект типа Cat и инициализировать им переменную cat (не забудь инициализировать поле name).
3. В статическом блоке вывести имя созданного кота на экран.
Примечание: не создавай конструкторы с параметрами в классе Cat.

Requirements:
1. Класс Cat должен быть создан внутри класса Solution и быть публичным и статическим.
2. В классе Cat должно быть публичное поле name типа String.
3. Переменная cat должна быть инициализирована в статическом блоке класса Solution.
4. В статическом блоке на экран должно быть выведено имя созданного кота.
5. Класс Cat не должен содержать конструкторы с параметрами.
 */