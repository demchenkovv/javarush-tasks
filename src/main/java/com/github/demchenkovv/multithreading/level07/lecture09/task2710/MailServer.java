package com.github.demchenkovv.multithreading.level07.lecture09.task2710;

public class MailServer implements Runnable {
    private Mail mail;

    public MailServer(Mail mail) {
        this.mail = mail;
    }

    @Override
    public void run() {
        long startTime = System.currentTimeMillis();
        try {
            // Заставляет текущий поток ждать, пока его не разбудят. В нашем случае
            // мьютекс mail будет отдан (захвачен) потоку (потоком) класса Person,
            // и оттуда же поступит уведомление (notify) о пробуждении.
            synchronized (mail) {
                mail.wait();
            }
            String name = Thread.currentThread().getName();
            long endTime = System.currentTimeMillis();
            System.out.format("%s MailServer received: [%s] in %d ms after start", name, mail.getText(), (endTime - startTime));
        } catch (InterruptedException ignored) {
        }
    }
}
