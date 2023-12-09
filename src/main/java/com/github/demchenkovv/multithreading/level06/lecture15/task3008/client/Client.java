package com.github.demchenkovv.multithreading.level06.lecture15.task3008.client;

import com.github.demchenkovv.multithreading.level06.lecture15.task3008.Connection;
import com.github.demchenkovv.multithreading.level06.lecture15.task3008.ConsoleHelper;
import com.github.demchenkovv.multithreading.level06.lecture15.task3008.Message;
import com.github.demchenkovv.multithreading.level06.lecture15.task3008.MessageType;

import java.io.IOException;
import java.net.Socket;

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

    public void run() {
        SocketThread socketThread = getSocketThread();
        // поток-демон: при выходе из программы вспомогательный поток автоматически прервется
        socketThread.setDaemon(true);
        socketThread.start();
        try {
            synchronized (this) {
                //  Обычно вызывают wait() и notify() на общем объекте, который используется для синхронизации между потоками, а не на самом потоке (Thread)
                this.wait();
            }
        } catch (InterruptedException ex) {
            ConsoleHelper.writeMessage("Возникла непредвиденная ошибка на стороне клиента.");
            return;
        }
        if (clientConnected) {
            ConsoleHelper.writeMessage("Соединение установлено. Для выхода наберите команду 'exit'.");
        } else {
            ConsoleHelper.writeMessage("Произошла ошибка во время работы клиента.");
        }
        // Считывать сообщения с консоли пока клиент подключен
        while (clientConnected) {
            String consoleMessage = ConsoleHelper.readString();
            if (consoleMessage.equals("exit")) {
//                clientConnected = false;
                break;
            }
            if (shouldSendTextFromConsole()) {
                sendTextMessage(consoleMessage);
            }
        }
    }

    /**
     * Запрос ввода адреса сервера у пользователя и вернуть введенное значение.
     */
    protected String getServerAddress() throws IOException {
        ConsoleHelper.writeMessage("Введите адрес сервера:");
        return ConsoleHelper.readString();
    }

    /**
     * Запрос ввода порта сервера у пользователя и вернуть введенное значение.
     */
    protected int getServerPort() throws IOException {
        ConsoleHelper.writeMessage("Введите порт сервера:");
        return ConsoleHelper.readInt();
    }

    /**
     * Запрос ввода имени пользователя и вернуть введенное значение.
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

        public void run() {
            try {
                String address = getServerAddress();
                int port = getServerPort();
                Socket socket = new Socket(address, port);
                connection = new Connection(socket);
                clientHandshake(); // познакомили клиента с сервером
                clientMainLoop(); // запустили основной цикл обработки сообщений сервера
            } catch (IOException | ClassNotFoundException e) {
                notifyConnectionStatusChanged(false);
            }
        }

        /**
         * Представить клиента серверу
         */
        protected void clientHandshake() throws IOException, ClassNotFoundException {
            while (true) {
                MessageType messageType = connection.receive().getType();
                if (messageType == MessageType.NAME_REQUEST) {
                    connection.send(new Message(MessageType.USER_NAME, getUserName()));
                } else if (messageType == MessageType.NAME_ACCEPTED) {
                    notifyConnectionStatusChanged(true);
                    return;
                } else {
                    throw new IOException("Unexpected MessageType");
                }
            }
        }

        /**
         * Главный цикл обработки сообщений сервера
         */
        protected void clientMainLoop() throws IOException, ClassNotFoundException {
            while (true) {
                Message message = connection.receive();
                if (message == null) {
                    throw new IOException("Unexpected MessageType");
                }

                MessageType messageType = message.getType();
                String data = message.getData();

                if (messageType == MessageType.TEXT) {
                    processIncomingMessage(data);
                } else if (messageType == MessageType.USER_ADDED) {
                    informAboutAddingNewUser(data);
                } else if (messageType == MessageType.USER_REMOVED) {
                    informAboutDeletingNewUser(data);
                } else {
                    throw new IOException("Unexpected MessageType");
                }
            }
        }

        // Выводит текст message в консоль
        protected void processIncomingMessage(String message) {
            ConsoleHelper.writeMessage(message);
        }

        // Выводит в консоль информацию о том, что участник с именем userName присоединился к чату.
        protected void informAboutAddingNewUser(String userName) {
            ConsoleHelper.writeMessage("Участник с именем " + userName + " присоединился к чату.");
        }

        // Выводит в консоль, что участник с именем userName покинул чат
        protected void informAboutDeletingNewUser(String userName) {
            ConsoleHelper.writeMessage("Участник с именем " + userName + " покинул чат.");
        }

        /**
         * Пробудить основной поток внешнего класса
         */
        protected void notifyConnectionStatusChanged(boolean clientConnected) {
            // Устанавливает значение поля clientConnected внешнего объекта Client в соответствии с переданным параметром.
            Client.this.clientConnected = clientConnected;
            // Оповещает (пробуждает ожидающий) основной поток класса Client.
            // PS: Вне синхронизированного блока у вас нет гарантии очерёдности событий, происходящих в разных потоках.
            synchronized (Client.this) {
                Client.this.notify();
            }
        }
    }

    public static void main(String[] args) {
        Client client = new Client();
        client.run();
    }
}
