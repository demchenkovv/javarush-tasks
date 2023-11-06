package com.github.demchenkovv.multithreading.level01.lecture05.fractions;

/**
 * Простое сравнение дробей
 */
public class Fraction {
    private int numerator;
    private int denominator;

    Fraction(int numerator, int denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
    }

    public boolean equals(Object obj) {
        if (obj == null)
            return false;

        if (obj.getClass() != this.getClass())
            return false;

        Fraction other = (Fraction) obj;
        return this.numerator * other.denominator == this.denominator * other.numerator;
    }

    public static void main(String[] args) {
        Fraction one = new Fraction(2, 3);
        Fraction two = new Fraction(4, 6);
        System.out.println(one.equals(two));
    }
}
