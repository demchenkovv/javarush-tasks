package com.github.demchenkovv.javasyntaxzero.level10.lecture04.task3;

/*
Два айфона
*/

public class Iphone {
    private String model;
    private String color;
    private int price;

    public Iphone(String model, String color, int price) {
        this.model = model;
        this.color = color;
        this.price = price;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (!(obj instanceof Iphone)) return false; // равносильно this.getClass() != obj.getClass()

        Iphone iphone = (Iphone) obj;

        if (this.price != iphone.price) return false;
        if (this.model != iphone.model) return false;
        return this.color == iphone.color;
    }

    public static void main(String[] args) {
        Iphone iphone1 = new Iphone("X", "Black", 999);
        Iphone iphone2 = new Iphone("X", "Black", 999);

        System.out.println(iphone1.equals(iphone2));
    }
}
/*
В методе main создаются два айфона с одинаковыми параметрами.
В консоли выводится результат их сравнения. Разберись, почему сейчас результат отрицательный и сделай так, чтобы он был положительным. Для этого тебе нужно переопределить метод equals(Iphone), который будет учитывать все параметры.
У двух равных объектов значения полей должны быть одинаковыми. Метод main не участвует в проверке.

Требования:
•	В классе Iphone должен быть переопределен метод public boolean equals(Object).
•	Метод equals должен возвращать true для двух равных объектов типа Iphone и false — для разных.
•	Метод equals должен возвращать false, если в него передали nu
 */