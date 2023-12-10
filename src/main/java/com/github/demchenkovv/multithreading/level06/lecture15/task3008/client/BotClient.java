package com.github.demchenkovv.multithreading.level06.lecture15.task3008.client;

import com.github.demchenkovv.multithreading.level06.lecture15.task3008.ConsoleHelper;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;

/**
 * Бот - представление клиента, который автоматически будет отвечать на некоторые команды.
 * Проще всего реализовать бота, который сможет отправлять текущее время или дату, когда его кто-то об этом попросит.
 */
public class BotClient extends Client {

    public static void main(String[] args) {
        BotClient botClient = new BotClient();
        botClient.run();
    }

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

        /**
         * Главный цикл обработки сообщений сервера
         */
        @Override
        protected void clientMainLoop() throws IOException, ClassNotFoundException {
            sendTextMessage("Привет чатику. Я бот. Понимаю команды: дата, день, месяц, год, время, час, минуты, секунды.");
            super.clientMainLoop();
        }

        @Override
        protected void processIncomingMessage(String message) {
            ConsoleHelper.writeMessage(message);
            if (!message.contains(": ")) {
                return;
            }

            String nameSender = message.split(": ")[0];
            String request = message.split(": ")[1].toLowerCase();

            Date date = new GregorianCalendar().getTime();

            Map<String, SimpleDateFormat> formatters = new HashMap<>();
            formatters.put("дата", new SimpleDateFormat("d.MM.YYYY"));
            formatters.put("день", new SimpleDateFormat("d"));
            formatters.put("месяц", new SimpleDateFormat("MMMM"));
            formatters.put("год", new SimpleDateFormat("YYYY"));
            formatters.put("время", new SimpleDateFormat("H:mm:ss"));
            formatters.put("час", new SimpleDateFormat("H"));
            formatters.put("минуты", new SimpleDateFormat("m"));
            formatters.put("секунды", new SimpleDateFormat("s"));

            if (formatters.containsKey(request)) {
                String formattedDate = formatters.get(request).format(date);
                String response = String.format("Информация для %s: %s", nameSender, formattedDate);
                sendTextMessage(response);
            }
        }
    }
}
