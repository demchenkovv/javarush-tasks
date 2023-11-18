package com.github.demchenkovv.multithreading.level03.lecture13.arkanoidgame;

public class Ball extends BaseObject {
    private double speed;       // скорость шарика
    private double direction;   // направление движения в градусах: от 0 до 360
    private double dx;          // расстояние по x, которое проходит шарик за один шаг
    private double dy;          // расстояние по y, которое проходит шарик за один шаг
    private boolean isFrozen;   // "истина" если шарик "заморожен", т.е. не двигается

    public Ball(double x, double y, double speed, double direction) {
        super(x, y, 1);
        this.speed = speed;
        this.direction = direction;
        isFrozen = true; // true - в начале игры шарик никуда не летит
    }

    public void start() {
        isFrozen = false;
    }

    @Override
    void draw(Canvas canvas) {
        canvas.setPoint(super.x, super.y, 'O');
    }

    /**
     * Каждый ход увеличивает значение y и x на dy и dx соответственно
     */
    @Override
    void move() {
        if (!isFrozen) {
            super.y += dy;
            super.x += dx;
        }
    }

    /**
     * Шарик может удариться о стенку. При этом он должен от нее отскочить.
     */
    void checkRebound(int minx, int maxx, int miny, int maxy) {

    }

    public double getSpeed() {
        return speed;
    }

    public double getDirection() {
        return direction;
    }

    public void setDirection(double direction) {
        this.direction = direction;
        double angle = Math.toRadians(direction);
        dx = Math.cos(angle) * speed;
        dy = -Math.sin(angle) * speed;
    }

    public double getDx() {
        return dx;
    }

    public double getDy() {
        return dy;
    }
}
