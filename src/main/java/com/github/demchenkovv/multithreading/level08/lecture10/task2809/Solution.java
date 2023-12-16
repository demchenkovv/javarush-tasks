package com.github.demchenkovv.multithreading.level08.lecture10.task2809;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Phaser;

/* 
Plants vs Zombies
*/

/*
Ознакомиться с Phaser:
Статья 1: https://habr.com/ru/articles/277669/
Статья 2: https://habr.com/ru/articles/117185/
Документация: https://docs.oracle.com/javase/8/docs/api/java/util/concurrent/Phaser.html
Пример из статьи: mt.level08.lecture10.phaserdemo
 */
public class Solution {
    public static void main(String[] args) throws InterruptedException {
        List<Character> characters = new ArrayList<>();
        characters.add(new Plant());
        characters.add(new Plant());
        characters.add(new Zombie());
        characters.add(new Zombie());
        characters.add(new Zombie());
        start(characters);
    }

    private static boolean isEveryoneReady = false;

    private static void start(List<Character> characters) throws InterruptedException {
        final Phaser phaser = new Phaser(1 + characters.size());

        for (final Character character : characters) {
            final String member = character.toString();
            System.out.println(member + " присоединился к игре");
            new Thread() {
                @Override
                public void run() {
                    System.out.println(member + " готовится играть");

                    // текущий поток прибывает к данной фазе и ожидает другие потоки
                    phaser.arriveAndAwaitAdvance();

                    if (!isEveryoneReady) {
                        isEveryoneReady = true;
                        System.out.println("Игра началась!");
                    }
                    character.run();
                }
            }.start();
        }

        // Поток (в нашем случае main) сообщает о завершении всех фаз стороной и снимает ее с регистрации.
        // Это делать обязательно, поскольку список characters с 5 задачами + 1 главная main.
        phaser.arriveAndDeregister();
    }
}