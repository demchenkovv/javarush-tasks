package com.github.demchenkovv.multithreading.level05.lecture16.task2909.human;

public class Soldier extends Human {

    public Soldier(String name, int age) {
        super(name, age);
    }

    public void fight() {
    }

    public void live() {
        fight();
    }
}
