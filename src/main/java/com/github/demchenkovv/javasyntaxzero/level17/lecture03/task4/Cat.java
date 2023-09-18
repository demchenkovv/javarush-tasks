package com.github.demchenkovv.javasyntaxzero.level17.lecture03.task4;

public class Cat extends Pet {
    public static final String CAT = "Я не люблю людей.";

    @Override
    public void printInfo() {
        super.printInfo();
        System.out.println(CAT);
    }
}

