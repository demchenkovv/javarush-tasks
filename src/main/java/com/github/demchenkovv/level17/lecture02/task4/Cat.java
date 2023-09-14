package com.github.demchenkovv.level17.lecture02.task4;

public class Cat extends Pet {
    public static final String CAT = "Я не люблю людей.";

    @Override
    public void printInfo() {
        super.printInfo();
        System.out.println(CAT);
    }
}

