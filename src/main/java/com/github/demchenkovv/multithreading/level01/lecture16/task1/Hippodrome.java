package com.github.demchenkovv.multithreading.level01.lecture16.task1;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Hippodrome {
    private List<Horse> horses;
    static Hippodrome game;

    public Hippodrome(List<Horse> horses) {
        this.horses = horses;
    }

    public static void main(String[] args) throws InterruptedException {
        Horse horse1 = new Horse("Horse_1", 3, 0);
        Horse horse2 = new Horse("Horse_2", 3, 0);
        Horse horse3 = new Horse("Horse_3", 3, 0);

        List<Horse> horseList = new ArrayList<>();
        horseList.add(horse1);
        horseList.add(horse2);
        horseList.add(horse3);

        Hippodrome hippodrome = new Hippodrome(horseList);
        game = hippodrome;
        game.run();
        game.printWinner();
    }

    public List<Horse> getHorses() {
        return this.horses;
    }

    void move() {
        for (Horse horse : horses) {
            horse.move();
        }
    }

    void print() {
        for (Horse horse : horses) {
            horse.print();
        }
        int count = 10;
        while (count-- != 0) {
            System.out.println();
        }
    }

    void run() throws InterruptedException {
        for (int i = 1; i <= 100; i++) {
            move();
            print();
            Thread.sleep(200);
        }
    }

    public Horse getWinner() {
        return horses.stream().max(Comparator.comparingDouble(Horse::getDistance)).get();
    }

    public void printWinner() {
        Horse winner = getWinner();
        System.out.printf("Winner is %s!", winner.getName());
    }
}
