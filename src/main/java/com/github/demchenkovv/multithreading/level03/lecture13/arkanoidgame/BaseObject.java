package com.github.demchenkovv.multithreading.level03.lecture13.arkanoidgame;

public abstract class BaseObject {
    protected double x;
    protected double y;
    protected double radius;

    public BaseObject(double x, double y, double radius) {
        this.x = x;
        this.y = y;
        this.radius = radius;
    }

    abstract void draw(Canvas canvas);

    abstract void move();

    // Евклидова норма
    // Math hypot() == sqrt(x2 + y2) == sqrt (x * x + y * y)
    // ---
    // дистанция_между_объектами_A_B =
    // квадратный_корень(
    // квадрат_числа(координата_x_объекта_B - координата_x_объекта_A) +
    // квадрат_числа(координата_y_объекта_B - координата_y_объекта_A)
    // )
    /** Проверки столкновения */
    public boolean intersects(BaseObject o) {
        double distanceAB = Math.hypot((this.x - o.x), (this.y - o.y));
        return distanceAB <= Math.max(this.radius, o.radius);
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }
}
