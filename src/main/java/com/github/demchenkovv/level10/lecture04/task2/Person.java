package com.github.demchenkovv.level10.lecture04.task2;

/*
Переопределяем метод equals()
 */
public class Person {
    String name;
    int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public static void main(String[] args) {
        Person person1 = new Person("Anna", 20);
        Person person2 = new Person("Petr", 25);
        Person person3 = new Person("Anna", 20);

        System.out.println("person1.equals(person2) = " + person1.equals(person2));
        System.out.println("person2.equals(person3) = " + person2.equals(person3));
        System.out.println("person1.equals(person3) = " + person1.equals(person3));
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true; // Сравниваем ссылки
        if (obj == null) return false; // Переданный объект - null?
        if (!(obj instanceof Person)) return false; // Если переданный объект не типа Person

        Person person = (Person) obj; // Операция приведения типа
        if (this.age != person.age) return false; // Если возрасты (age) не равны, то false
        return this.name.equals(person.name);
    }
}