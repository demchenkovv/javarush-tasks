package com.github.demchenkovv.multithreading.level06.lecture15.task3008.client;

import java.io.IOException;

/**
 * Бот - представление клиента, который автоматически будет отвечать на некоторые команды.
 * Проще всего реализовать бота, который сможет отправлять текущее время или дату, когда его кто-то об этом попросит.
 */
public class BotClient extends Client {

    @Override
    protected String getUserName() throws IOException {
        return "date_bot_" + (int) (Math.random() * 100);
    }

    @Override
    protected boolean shouldSendTextFromConsole() {
        return false;
    }

    @Override
    protected SocketThread getSocketThread() {
        return new BotSocketThread();
    }

    /**
     * Inner class отвечает за поток, устанавливающий сокетное соединение и читающий сообщения сервера.
     */
    public class BotSocketThread extends SocketThread {
    }

    public static void main(String[] args) {
        BotClient botClient = new BotClient();
        botClient.run();
    }
}
