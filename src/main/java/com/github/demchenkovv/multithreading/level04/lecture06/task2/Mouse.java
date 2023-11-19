package com.github.demchenkovv.multithreading.level04.lecture06.task2;

/*
обратите внимание, как именно Mouse отличается от Dog
Этот класс - привычный для вас.
*/
public class Mouse implements Pet, Sayable {
    @Override
    public Sayable toSayable(int i) {
        return this;
    }

    @Override
    public String say() {
        return "Мышь пищит.";
    }
}
