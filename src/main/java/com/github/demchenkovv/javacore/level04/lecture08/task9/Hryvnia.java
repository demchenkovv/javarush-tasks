package com.github.demchenkovv.javacore.level04.lecture08.task9;

public class Hryvnia extends Money {

    public Hryvnia(double amount) {
        super(amount);
    }

    @Override
    public String getCurrencyName() {
        return "UAH";
    }
}
