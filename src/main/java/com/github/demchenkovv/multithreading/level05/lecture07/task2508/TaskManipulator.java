package com.github.demchenkovv.multithreading.level05.lecture07.task2508;

public class TaskManipulator implements Runnable, CustomThreadManipulator {
    private Thread thread;

    @Override
    public void run() {
        // Вариант 1.
        // Вызвать interrupt в блоке catch, тем самым вернуть статус прерывания снова в true, чтобы while смог
        // обнаружить и прервать нужный поток. Или в блоке catch прописать break для прерывания внешнего цикла.
        while (!Thread.currentThread().isInterrupted()) {
            System.out.println(Thread.currentThread().getName());
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
//                Thread.currentThread().interrupt();
                break;
            }
        }

//        // Вариант 2.
//        // Обернуть весь цикл в try-catch, тогда при выбрасывании исключения, <..весь последующий исполняемый
//        // код..>, а в нашем случае цикл, будет прерываться (выходим из блока try).
//        try {
//            while (!Thread.currentThread().isInterrupted()) {
//                System.out.println(Thread.currentThread().getName());
//                Thread.sleep(100);
//            }
//        } catch (InterruptedException ex) {
//            // дополнительная логика не требуется, выходим из блока try-catch
//        }
    }

    @Override
    public void start(String threadName) {
        thread = new Thread(this, threadName);
        thread.start();
    }

    @Override
    public void stop() {
        thread.interrupt();
    }
}
