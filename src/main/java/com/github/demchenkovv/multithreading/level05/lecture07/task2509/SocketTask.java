package com.github.demchenkovv.multithreading.level05.lecture07.task2509;

import java.io.IOException;
import java.net.Socket;
import java.util.concurrent.FutureTask;
import java.util.concurrent.RunnableFuture;

/** Класс SocketTask реализует интерфейс CancellableTask и определяет метод Future.cancel, используемый
 * для закрытия сокета, а также вызова метода super.cancel.<p> Если класс SocketTask отменяется через
 * собственный экземпляр Future, сокет закрывается и выполнение потока прерывается. <p>
 * Это повышает отзывчивость задачи к запросам на отмену: она может не только безопасно вызывать прерываемые
 * блокирующие методы, оставаясь отзывчивой к запросам на отмену, но также может вызывать блокирующие методы
 * ввода/вывода сокета.*/
public abstract class SocketTask<T> implements CancellableTask<T> {
    private Socket socket;

    protected synchronized void setSocket(Socket socket) {
        this.socket = socket;
    }

    public synchronized void cancel() {
        //close all resources here
        try {
            if (socket != null) {
                socket.close();
            }
        } catch (IOException ignored) {

        }
    }

    public RunnableFuture<T> newTask() {
        return new FutureTask<T>(this) {
            public boolean cancel(boolean mayInterruptIfRunning) {
                //close all resources here by using proper SocketTask method
                //call super-class method in finally block
                try {
                    SocketTask.this.cancel();
                } finally {
                    super.cancel(mayInterruptIfRunning);
                }
                return false;
            }
        };
    }
}