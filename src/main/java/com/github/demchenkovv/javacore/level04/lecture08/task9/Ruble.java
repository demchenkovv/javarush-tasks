package com.github.demchenkovv.javacore.level04.lecture08.task9;

public class Ruble extends Money {

    public Ruble(double amount) {
        super(amount);
    }

    @Override
    public String getCurrencyName() {
        return "RUB";
    }
}
