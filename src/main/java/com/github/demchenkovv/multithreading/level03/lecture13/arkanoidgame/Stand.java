package com.github.demchenkovv.multithreading.level03.lecture13.arkanoidgame;

/**
 * Подставка для отскока шарика
 */
public class Stand extends BaseObject {
    private double speed; // скорость шарика
    private double direction; // направление движения по оси x: 1 - вправо, -1 - влево, 0 - начальное значение, стоим на месте

    public Stand(double x, double y) {
        super(x, y, 3);
        speed = 1;
        direction = 0;
    }

    @Override
    void draw(Canvas canvas) {

    }

    @Override
    void move() {
        super.x += speed * direction;
    }

    public void moveLeft() {
        direction = -1;
    }

    public void moveRight() {
        direction = 1;
    }

    public double getSpeed() {
        return speed;
    }

    public double getDirection() {
        return direction;
    }
}
