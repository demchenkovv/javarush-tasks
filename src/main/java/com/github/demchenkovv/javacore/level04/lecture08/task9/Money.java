package com.github.demchenkovv.javacore.level04.lecture08.task9;

public abstract class Money {

    private double amount;

    public Money(double amount) {
        this.amount = amount;
    }

    public double getAmount() {
        return amount;
    }

    public abstract String getCurrencyName();
}

