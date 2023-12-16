package com.github.demchenkovv.multithreading.level08.lecture10.phaserdemo2;

import java.util.concurrent.Phaser;

public class PhaserExample {
    public static void main(String[] args) {
        Phaser phaser = new Phaser(1); // Инициализация Phaser с 1 участником (главным потоком)

        // Создание и запуск потоков
        for (int i = 0; i < 3; i++) {
            Thread thread = new Thread(new Worker(phaser));
            thread.start();
        }

        // Регистрация дополнительных участников
        phaser.arriveAndDeregister(); // Главный поток регистрирует себя и сразу же отменяет регистрацию

        // Ожидание завершения всех фаз
        phaser.awaitAdvance(phaser.getPhase());

        System.out.println("All workers have finished their tasks.");
    }

    static class Worker implements Runnable {
        private final Phaser phaser;

        Worker(Phaser phaser) {
            this.phaser = phaser;
        }

        @Override
        public void run() {
            // Выполнение задачи

            phaser.arriveAndAwaitAdvance(); // Сигнализация о достижении фазы и ожидание остальных потоков

            // Продолжение выполнения задачи после достижения фазы
        }
    }
}