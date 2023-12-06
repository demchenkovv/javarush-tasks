package com.github.demchenkovv.multithreading.level06.lecture10.task2612;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* 
Весь мир играет комедию
*/

/**
 * Статья на тему <a href="https://java-online.ru/concurrent-locks.xhtml">"Блокировки пакета concurrent"</a>
 */
public class Solution {
    private Lock lock = new ReentrantLock();

    public void someMethod() {
        // true - лок свободен и забрали себе / false - занят другим потоком
        boolean isLockAcquired = lock.tryLock();
        if (!isLockAcquired) {
            actionIfLockIsBusy();
        } else {
            try {
                actionIfLockIsFree();
            } finally {
                lock.unlock();
            }
        }
    }

    public void actionIfLockIsFree() {
    }

    public void actionIfLockIsBusy() {
    }
}
