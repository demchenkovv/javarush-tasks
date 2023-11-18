package com.github.demchenkovv.multithreading.level03.lecture13.arkanoidgame;

import java.util.Iterator;
import java.util.List;

public class Arkanoid {
    static Arkanoid game;
    private int width;
    private int height;
    private Ball ball;
    private Stand stand;
    private List<Brick> bricks;
    private boolean isGameOver;

    public Arkanoid(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public static void main(String[] args) {

    }

    public void run() {

    }

    /**
     * Двигать все движимые объекты
     */
    public void move() {
        ball.move();
        stand.move();
    }

    public void draw(Canvas canvas) {
        ball.draw(canvas);
        stand.draw(canvas);
        for (Brick brick : bricks) {
            brick.draw(canvas);
        }
    }

    /**
     * Метод проверяет - столкнулся ли шарик с каким-либо из кирпичей.
     */
    public void checkBricksBump() {
        Iterator<Brick> iterator = bricks.iterator();
        while (iterator.hasNext()) {
            Brick brick = iterator.next();
            if (ball.intersects(brick)) {
                double angle = Math.random() * 360; // шарик отлетает в случайном направлении
                ball.setDirection(angle);
                iterator.remove();
                break;
            }
        }
    }

    /**
     * Метод проверяет - не ударился ли шарик о подставку.
     */
    public void checkStandBump() {
        if (ball.intersects(stand)) {
            double angle = 90 + 20 * (Math.random() - 0.5);
            ball.setDirection(angle);
        }
    }

    /**
     * Метод проверяет - улетел ли шарик за границу экрана.
     */
    public void checkEndGame() {
        if (ball.y > height) {
            isGameOver = true;
        }
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public Ball getBall() {
        return ball;
    }

    public void setBall(Ball ball) {
        this.ball = ball;
    }

    public Stand getStand() {
        return stand;
    }

    public void setStand(Stand stand) {
        this.stand = stand;
    }

    public List<Brick> getBricks() {
        return bricks;
    }

    public void setBricks(List<Brick> bricks) {
        this.bricks = bricks;
    }
}
