package com.github.demchenkovv.multithreading.level05.lecture16.task2909.human;

public class Professor extends Teacher {
    Professor(String name, int age, int numberOfStudents) {
        super(name, age, numberOfStudents);
    }

    public void live() {
        teach();
    }

}