package com.github.demchenkovv.multithreading.level05.lecture16.task2909.car;

public class Cabriolet extends Car {

    public Cabriolet(int numberOfPassengers) {
        super(Car.CABRIOLET, numberOfPassengers);
    }

    @Override
    public int getMaxSpeed() {
        return MAX_CABRIOLET_SPEED;
    }
}
