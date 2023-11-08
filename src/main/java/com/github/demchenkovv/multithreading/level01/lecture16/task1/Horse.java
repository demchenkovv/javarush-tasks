package com.github.demchenkovv.multithreading.level01.lecture16.task1;

public class Horse {
    String name;
    double speed;
    double distance;

    public Horse(String name, double speed, double distance) {
        this.name = name;
        this.speed = speed;
        this.distance = distance;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public void move() {
        double randomValue = Math.random() * 2;
        this.distance += speed * randomValue;
    }

    public void print() {
        int distanceCovered = (int) Math.floor(this.distance);
        for (int i = 0; i < distanceCovered; i++) {
            System.out.print(".");
        }
        System.out.println(this.name);
    }
}
