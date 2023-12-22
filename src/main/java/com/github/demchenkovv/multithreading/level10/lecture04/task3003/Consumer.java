package com.github.demchenkovv.multithreading.level10.lecture04.task3003;

import java.util.concurrent.TransferQueue;

public class Consumer implements Runnable {
    private final TransferQueue<ShareItem> queue;

    public Consumer(TransferQueue<ShareItem> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(450);
            while (!Thread.currentThread().isInterrupted()) {
                ShareItem element = queue.take();
                System.out.format("Processing %s\n", element.toString());
            }
        } catch (InterruptedException ignored) {

        }
    }
}
