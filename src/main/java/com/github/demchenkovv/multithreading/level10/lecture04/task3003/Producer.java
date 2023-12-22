package com.github.demchenkovv.multithreading.level10.lecture04.task3003;

import java.util.concurrent.TransferQueue;

/**
 * TransferQueue - эта очередь позволяет нам создавать программы
 * по шаблону producer-consumer (производитель-потребитель) и координировать
 * передачу сообщений от производителей к потребителям.
 * <p>
 * Реализация фактически аналогична BlockingQueue - но дает нам новую
 * возможность реализовать форму обратного действия. Это означает, что, когда
 * производитель отправляет сообщение потребителю с помощью метода transfer(),
 * производитель будет оставаться заблокированным до тех пор, пока сообщение
 * не будет потреблено.
 */
public class Producer implements Runnable {
    private final TransferQueue<ShareItem> queue;

    public Producer(TransferQueue<ShareItem> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 9; i++) {

            // Если нить прервана, выйти из run()
            if (Thread.currentThread().isInterrupted()) {
                return;
            }

            System.out.format("Элемент 'ShareItem-%d' добавлен\n", i);

            // Немедленное размещение элемента в очереди при наличии свободного места;
            // метод вернет true при успешном завершении операции, в противном случае вернет false.
            queue.offer(new ShareItem("ShareItem-" + i, i));
            try {
                Thread.sleep(100);
            } catch (InterruptedException ignored) {

            }

            // Возвращает true, если есть хотя бы один consumer (потребитель), ожидающий получения элемента через
            // BlockingQueue.take или timed poll. Возвращаемое значение представляет собой текущее состояние дел.
            if (queue.hasWaitingConsumer()) {
                System.out.format("Consumer в ожидании!\n");
            }
        }
    }
}
