package com.github.demchenkovv.multithreading.level06.lecture15.task3008.client;

import com.github.demchenkovv.multithreading.level06.lecture15.task3008.Connection;
import com.github.demchenkovv.multithreading.level06.lecture15.task3008.ConsoleHelper;
import com.github.demchenkovv.multithreading.level06.lecture15.task3008.Message;
import com.github.demchenkovv.multithreading.level06.lecture15.task3008.MessageType;

import java.io.IOException;

/**
 * Приступим к написанию клиента. <p>
 * Клиент, в начале своей работы, должен запросить у пользователя адрес и порт сервера, подсоединиться к
 * указанному адресу, получить запрос имени от сервера, спросить имя у пользователя, отправить имя пользователя
 * серверу, дождаться принятия имени сервером. <p>
 * После этого клиент может обмениваться текстовыми сообщениями с сервером. Обмен сообщениями будет происходить
 * в двух параллельно работающих потоках. Один будет заниматься чтением из консоли и отправкой прочитанного серверу,
 * а второй поток будет получать данные от сервера и выводить их в консоль.
 */
public class Client {
    protected Connection connection;
    private volatile boolean clientConnected = false; // клиент подсоединен к серверу (true), иначе false

    /**
     * Запрос ввод адреса сервера у пользователя и вернуть введенное значение.
     */
    protected String getServerAddress() throws IOException {
        ConsoleHelper.writeMessage("Введите адрес сервера:");
        return ConsoleHelper.readString();
    }

    /**
     * Запрос ввод порта сервера у пользователя и вернуть введенное значение.
     */
    protected int getServerPort() throws IOException {
        ConsoleHelper.writeMessage("Введите порт сервера:");
        return ConsoleHelper.readInt();
    }

    /**
     * Запрос ввод имя пользователя и вернуть введенное значение.
     */
    protected String getUserName() throws IOException {
        ConsoleHelper.writeMessage("Введите имя пользователя:");
        return ConsoleHelper.readString();
    }

    /**
     * В данной реализации клиента всегда должен возвращать true (мы всегда отправляем текст введенный в консоль).
     * Этот метод может быть переопределен, если мы будем писать какой-нибудь другой клиент, унаследованный от нашего,
     * который не должен отправлять введенный в консоль текст.
     */
    protected boolean shouldSendTextFromConsole() {
        return true;
    }

    /**
     * Создать и вернуть новый объект класса SocketThread.
     */
    protected SocketThread getSocketThread() {
        return new SocketThread();
    }

    /**
     * Создать новое текстовое сообщение, используя переданный текст, и отправить его серверу через соединение connection
     */
    protected void sendTextMessage(String text) {
        try {
            connection.send(new Message(MessageType.TEXT, text));
        } catch (IOException ex) {
            ConsoleHelper.writeMessage("Произошла ошибка при создании и отправки нового сообщения от удаленного адреса " + connection.getRemoteSocketAddress());
            clientConnected = false;
        }
    }

    /**
     * inner class SocketThread отвечает за поток, устанавливающий сокетное соединение и читающий сообщения сервера.
     */
    public class SocketThread extends Thread {
    }
}
