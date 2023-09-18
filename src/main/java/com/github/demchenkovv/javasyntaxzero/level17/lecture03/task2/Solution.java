package com.github.demchenkovv.javasyntaxzero.level17.lecture03.task2;

import java.util.ArrayList;

/*
Космическая одиссея ч.2
*/

public class Solution {
    public static ArrayList<Astronaut> astronauts = new ArrayList<>();

    public static void main(String[] args) {
        createCrew();
        printCrewInfo();
        runWorkingProcess();
    }

    public static void runWorkingProcess() {
        astronauts.forEach(e -> {
            if (e instanceof Human)
                pilot((Human) e);
            else if (e instanceof Dog)
                createDirection((Dog) e);
            else if (e instanceof Cat)
                research((Cat) e);
        });
    }

    public static void pilot(Human human) {
        System.out.println("Член экипажа " + human.getInfo() + " пилотирует корабль.");
    }

    public static void createDirection(Dog dog) {
        System.out.println("Член экипажа " + dog.getInfo() + " занимается созданием навигационного маршрута.");
    }

    public static void research(Cat cat) {
        System.out.println("Член экипажа " + cat.getInfo() + " исследует ближайшие планеты.");
    }

    public static void createCrew() {
        astronauts.add(new Human());
        astronauts.add(new Human());
        astronauts.add(new Dog());
        astronauts.add(new Cat());
    }

    public static void printCrewInfo() {
        System.out.println("На борт погружены члены экипажа: ");
        for (Astronaut astronaut : astronauts) {
            System.out.println(astronaut.getInfo());
        }
    }
}

/*
Все члены экипажа космического корабля находятся на борту, корабль успешно вышел в открытый космос.
Команде пора приступить к выполнению своих обязанностей:
Людям — пилотировать корабль, Собаке — заниматься навигацией, а Коту — исследовать открытый космос.

Распредели обязанности членов экипажа в методе runWorkingProcess().

Для этого достань из списка astronauts всех людей (ты знаешь, под какими индексами они находятся) и передай их в качестве аргументов методу pilot(Human human), собаку передай в метод createDirection(Dog dog), а кота — в метод research(Cat cat).
Другие методы не изменяй.

Подсказка:
Список astronauts содержит объекты типа Astronaut. Чтобы вызвать методы pilot(), createDirection() и research(), сначала объект Astronaut нужно привести к правильному типу.

Требования:
•	Метод runWorkingProcess() должен вызывать pilot(Human human) 2 раза. В качестве аргументов передать все объекты типа Human из списка astronauts.
•	Метод runWorkingProcess() должен вызывать createDirection(Dog dog) 1 раз. В качестве аргумента передать объект типа Dog из списка astronauts.
•	Метод runWorkingProcess() должен вызывать research(Cat cat) 1 раз. В качестве аргумента передать объект типа Cat из списка astronauts.
 */