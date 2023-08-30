package com.github.demchenkovv.level10.lecture02.task1;
/**
 Логирование

 Логированием называется запись в консоль или файл действий, которые происходят во время работы программы.
 Определить, что вызвался конструктор, довольно просто: нужно в теле конструктора написать в консоль сообщение об этом.
 А вот как определить, что переменная инициализировалась?
 На самом деле это тоже не очень сложно: нужно написать специальный метод, который будет возвращать значение,
 которым инициализируется переменная класса, и логировать этот факт. Вот как может выглядеть этот код:
 */
public class Main {
    public static void main(String[] args) {
        ChildClass obj = new ChildClass(); // Создаем объект типа ChildClass
    }

    public static String print(String text) { // Этот метод пишет в консоль переданный текст и возвращает его же
        System.out.println(text);
        return text;
    }
}

class ParentClass { // Объявляем ParentClass

    public String a = Main.print("ParentClass.a"); // Пишем текст и им же инициализируем переменные
    public String b = Main.print("ParentClass.b");

    public ParentClass() {
        Main.print("ParentClass.constructor"); // Пишем в консоль сообщение о вызове конструктора. Возвращаемое значение игнорируем.
    }
}

class ChildClass extends ParentClass { // Объявляем ChildClass

    public String c = Main.print("ChildClass.c"); // Пишем текст и им же инициализируем переменные
    public String d = Main.print("ChildClass.d");

    public ChildClass() {
        Main.print("ChildClass.constructor"); // Пишем в консоль сообщение о вызове конструктора. Возвращаемое значение игнорируем.
    }
}