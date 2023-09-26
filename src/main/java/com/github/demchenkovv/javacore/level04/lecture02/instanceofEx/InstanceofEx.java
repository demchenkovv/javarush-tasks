package com.github.demchenkovv.javacore.level04.lecture02.instanceofEx;

public class InstanceofEx {
    public static void main(String[] args) {
        Tiger t = new Tiger();
        t.doAnimalActions();
        t.doCatActions();
        t.doTigerActions();
    }

    static class Animal
    {
        public void doAnimalActions(){
            System.out.println("Привет из класса Animal");
        }
    }
    static class Cat extends Animal
    {
        public void doCatActions(){
            System.out.println("Привет из класса Cat");
        }
    }
    static class Tiger extends Cat
    {
        public void doTigerActions(){
            System.out.println("Привет из класса Tiger");
        }
    }
}
