package com.github.demchenkovv.level17.lecture03.task4;

public class Dog extends Pet {
    public static final String DOG = "Я люблю людей.";

    @Override
    public void printInfo() {
        super.printInfo();
        System.out.println(DOG);
    }
}
