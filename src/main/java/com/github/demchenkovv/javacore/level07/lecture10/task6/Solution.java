package com.github.demchenkovv.javacore.level07.lecture10.task6;

import java.util.ArrayList;
import java.util.List;

/* 
Аптека
*/

public class Solution {
    public static DrugsController drugsController = new DrugsController();
    public static boolean isStopped = false;

    public static void main(String[] args) throws InterruptedException {
        Thread apteka = new Thread(new Apteka(), "Apteka");
        Thread man = new Thread(new Person(), "Мужчина");
        Thread woman = new Thread(new Person(), "Женщина");

        apteka.start();
        man.start();
        woman.start();

        Thread.sleep(1000);
        isStopped = true;
    }

    /**
     * Можно сделать синхронизацию по объекту drugsController или сразу синхронизировать его методы в классе DrugsController.
     * Нет разницы, но если твой класс в дальнейшем будет использоваться в многопоточке, то все методы лучше
     * помечать сразу synchronized. Иначе придется каждый раз при создании нити, которая использует твой класс,
     * писать синхронизацию по объекту этого класса. Что выглядит уже не очень надежно.
     * Поэтому synchronized (drugsController) в методе run() является не оптимальным решением.
     */
    public static class Apteka implements Runnable {

        @Override
        public void run() {
            while (!isStopped) {
//                synchronized (drugsController) {
                    drugsController.sell(getRandomDrug(), getRandomCount());
                    waitAMoment();
                    waitAMoment();
                    waitAMoment();
//                }
            }
        }
    }

    public static class Person implements Runnable {

        @Override
        public void run() {
            while (!isStopped) {
//                synchronized (drugsController) {
                    drugsController.buy(getRandomDrug(), getRandomCount());
                    waitAMoment();
//                }
            }
        }
    }

    public static int getRandomCount() {
        return (int) (Math.random() * 3) + 1;
    }

    public static Drug getRandomDrug() {
        int index = (int) ((Math.random() * 1000) % (DrugsController.allDrugs.size()));
        List<Drug> drugs = new ArrayList<>(DrugsController.allDrugs.keySet());
        return drugs.get(index);
    }

    private static void waitAMoment() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
        }
    }
}
