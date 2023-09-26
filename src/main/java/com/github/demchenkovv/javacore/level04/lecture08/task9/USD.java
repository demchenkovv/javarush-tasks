package com.github.demchenkovv.javacore.level04.lecture08.task9;

public class USD extends Money {

    public USD(double amount) {
        super(amount);
    }

    @Override
    public String getCurrencyName() {
        return "USD";
    }
}
