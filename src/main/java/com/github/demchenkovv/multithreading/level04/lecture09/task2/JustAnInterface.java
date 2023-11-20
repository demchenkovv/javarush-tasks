package com.github.demchenkovv.multithreading.level04.lecture09.task2;

public interface JustAnInterface {
    public static final B B = new B();

    class B extends C {
        public B() {
            System.out.print("B");
        }
    }
}