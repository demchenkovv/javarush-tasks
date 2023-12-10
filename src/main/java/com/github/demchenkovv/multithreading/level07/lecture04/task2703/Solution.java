package com.github.demchenkovv.multithreading.level07.lecture04.task2703;

/* 
Создаем deadlock
*/

/*
Почему происходит deadlock?
1. В классе Friend методы bow() и bowBack() объявлены как synchronized, т.е. происходит блокировка по объекту this.
2. Обе нити входят в метод bow(). Происходит блокировка каждого мьютекса объекта this (1-й alphonce, 2-й gaston).
Исходя из этого, все методы, в имени которых объявлено synchronized или внутри тела метода объявлен блок
synchronized(this) {}, будут недоступны для других потоков, пока мьютекс этого объекта заблокирован.
3. Нить Alphonce из метода bow() вызывает метод bowBack() у объекта gaston, мьютекс которого заблокирован. А Gaston
вызывает метод bowBack() у объекта alphonce, мьютекс которого тоже заблокирован.
4. Выходит взаимная блокировка, поскольку метод bowBack() является synchronized(this), а оба объекта мьютекса в
данный момент заблокированы.
 */

public class Solution {
    static class Friend {
        private final String name;

        public Friend(String name) {
            this.name = name;
        }

        public String getName() {
            return this.name;
        }

        public synchronized void bow(Friend bower) {
            System.out.format("%s: %s bowed to me!%n", this.name, bower.getName());
            bower.bowBack(this);
        }

        public synchronized void bowBack(Friend bower) {
            System.out.format("%s: %s bowed back to me!%n", this.name, bower.getName());
        }
    }

    public static void main(String[] args) {
        final Friend alphonse = new Friend("Alphonse");
        final Friend gaston = new Friend("Gaston");

        new Thread(new Runnable() {
            public void run() {
                alphonse.bow(gaston);
            }
        }).start();

        new Thread(new Runnable() {
            public void run() {
                gaston.bow(alphonse);
            }
        }).start();
    }
}
