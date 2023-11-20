package com.github.demchenkovv.multithreading.level04.lecture09.task2;

public class C implements JustAnInterface {
    public C() {
        System.out.print("C");
        B localB = B;
    }
}