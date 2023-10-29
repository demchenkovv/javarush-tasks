package com.github.demchenkovv.javacore.level10.lecture04.serializationDemo.simpleSerialization;

import java.io.Serializable;

public class Person implements Serializable {
    private String name;
    private int countOfNiva;
    private String fatherName;
    private Home home;

    public Person(String name, int countOfNiva, String fatherName, Home home) {
        this.name = name;
        this.countOfNiva = countOfNiva;
        this.fatherName = fatherName;
        this.home = home;
    }

    @Override
    public String toString() {
        return "Person{" +
               "name='" + name + '\'' +
               ", countOfNiva=" + countOfNiva +
               ", fatherName='" + fatherName + '\'' +
               ", home=" + home +
               '}';
    }
}