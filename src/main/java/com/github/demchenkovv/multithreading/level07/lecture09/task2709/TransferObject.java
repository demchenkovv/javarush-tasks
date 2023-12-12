package com.github.demchenkovv.multithreading.level07.lecture09.task2709;

public class TransferObject {
    private int value;
    protected volatile boolean isValuePresent = false; //use this variable

    // Ожидает появления value и возвращает его после того, как оно появится.
    // Устанавливает флаг isValuePresent в false и уведомляет другие нити, ожидающие освобождения монитора,
    // перед возвратом значение поля value.
    public synchronized int get() {
        while (!isValuePresent) {
            try {
                wait();
            } catch (InterruptedException ignored) {
            }
        }
        System.out.println("Got: " + value);
        isValuePresent = false;
        notify();
        return value;
    }

    public synchronized void put(int value) {
        // Ждет пока value заберут и обновит его значение после того, как оно пропадет.
        // Устанавливает флаг isValuePresent в true и уведомляет другие нити, ожидающие освобождения монитора,
        // после обновления значение поля value.
        while (isValuePresent) {
            try {
                wait();
            } catch (InterruptedException ignored) {
            }
        }
        this.value = value;
        isValuePresent = true;
        System.out.println("Put: " + value);
        notify();
    }
}
