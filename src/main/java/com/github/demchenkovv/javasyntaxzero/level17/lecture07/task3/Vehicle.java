package com.github.demchenkovv.javasyntaxzero.level17.lecture07.task3;

/*
Дорожное движение
*/

public interface Vehicle {
    default void start() {
        System.out.println("Начинаю движение.");
    }
    void move();
    default void stop() {
        System.out.println("Останавливаюсь.");
    }
}

/*
Классы Car и Bus имплементируют интерфейс Vehicle. При этом имплементации некоторых его методов у них сходятся.
Реализуй эти методы как default в самом интерфейсе Vehicle, а из классов Car и Bus их убери.

Требования:
•	Интерфейс Vehicle должен реализовывать метод default void start().
•	Интерфейс Vehicle должен реализовывать метод default void stop().
•	Класс Car не должен имплементировать методы void start() и void stop().
•	Класс Bus не должен имплементировать методы void start() и void stop().
 */