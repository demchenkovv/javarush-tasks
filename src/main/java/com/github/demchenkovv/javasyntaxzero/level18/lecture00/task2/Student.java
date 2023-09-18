package com.github.demchenkovv.javasyntaxzero.level18.lecture00.task2;

public class Student {
    private String name;
    private int age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Студент - " + name +
               ", возраст - " + age +
               '.';
    }
}
