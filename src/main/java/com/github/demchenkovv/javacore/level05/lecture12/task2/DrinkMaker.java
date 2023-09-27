package com.github.demchenkovv.javacore.level05.lecture12.task2;

public abstract class DrinkMaker {

    abstract void getRightCup(); // выбрать подходящую чашку

    abstract void putIngredient(); // положить ингредиенты

    abstract void pour(); // залить жидкость

    public void makeDrink() {
        getRightCup();
        putIngredient();
        pour();
    }
}
