package com.github.demchenkovv.javacore.level07.lecture10.task3;

public class Table {
    private static byte tableNumber;
    private byte number = ++tableNumber;

    public Order getOrder() {
        return new Order(number);
    }
}
