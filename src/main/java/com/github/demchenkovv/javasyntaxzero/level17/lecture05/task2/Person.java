package com.github.demchenkovv.javasyntaxzero.level17.lecture05.task2;

/*
От абстракции к реальности
*/

public class Person {
    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

/*
Класс Person объявлен как абстрактный. Это значит, что мы не можем создавать его экземпляры.
Сделай из данного класса обычный, допиши недостающую логику, которая отвечает общепринятым подходам к инкапсуляции:
геттеры должны возвращать, а сеттеры — устанавливать значения соответствующим полям.

Требования:
•	Класс Person не должен быть абстрактным.
•	Метод getName() должен возвращать значение поля name.
•	Метод setName(String) должен устанавливать переданное значение полю name.
•	Метод getAge() должен возвращать значение поля age.
•	Метод setAge(int) должен устанавливать переданное значение полю age.
 */