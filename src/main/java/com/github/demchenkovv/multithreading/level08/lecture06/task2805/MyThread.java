package com.github.demchenkovv.multithreading.level08.lecture06.task2805;

import java.util.concurrent.atomic.AtomicInteger;

public class MyThread extends Thread {
    public static AtomicInteger priority = new AtomicInteger(0);

    // Нестатический блок инициализации (блок инициализации экземпляра)
    // вызывается каждый раз при создании нового экземпляра класса. В
    // нашем случае при создании нового экземпляра блок инициализации
    // устанавливает приоритет для каждого экземпляра (потока), исходя
    // из значения общей статической переменной. Максимальный приоритет
    // для потока 10, минимальный - 1, поэтому для расчета используем
    // остаток от деления 10 и прибавляем 1.

    // Если группе потоков установлено максимальное значение приоритета,
    // то такому потоку будет установлен приоритет не выше максимального
    // приоритета группы потоков. Например, если группе потоков присвоено
    // максимальное значение приоритета 7, то при попытке установить
    // текущему потоку приоритет 8, 9 или 10, в таком случае всё равно
    // будет установлено значение 7.
    {
        this.setPriority(priority.getAndIncrement() % 10 + 1);
    }

    public MyThread() {
    }

    public MyThread(Runnable target) {
        super(target);
    }

    public MyThread(ThreadGroup group, Runnable target) {
        super(group, target);
    }

    public MyThread(String name) {
        super(name);
    }

    public MyThread(ThreadGroup group, String name) {
        super(group, name);
    }

    public MyThread(Runnable target, String name) {
        super(target, name);
    }

    public MyThread(ThreadGroup group, Runnable target, String name) {
        super(group, target, name);
    }

    public MyThread(ThreadGroup group, Runnable target, String name, long stackSize) {
        super(group, target, name, stackSize);
    }
}
