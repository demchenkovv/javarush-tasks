package com.github.demchenkovv.javacore.level09.lecture11.task6;

import java.util.Date;

public class Person {
    private String name;
    private Date birthDate;

    public Person(String name, Date birthDate) {
        this.name = name;
        this.birthDate = birthDate;
    }

    public String getName() {
        return name;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    @Override
    public String toString() {
        return "Person{" +
               "name='" + name + '\'' +
               ", birthDate=" + birthDate +
               '}';
    }
}
