package com.github.demchenkovv.multithreading.level06.lecture15.task3008;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Основной класс сервера. Сервер должен поддерживать множество соединений с разными клиентами одновременно.
 * Это можно реализовать с помощью следующего алгоритма: <br>
 * - Сервер создает серверное сокетное соединение. <br>
 * - В цикле ожидает, когда какой-то клиент подключится к сокету. <br>
 * - Создает новый поток-обработчик Handler, в котором будет происходить обмен сообщениями с клиентом. <br>
 * - Ожидает следующее соединение.
 */
public class Server {

    public static void main(String[] args) throws IOException {
        ConsoleHelper.writeMessage("Введите порт сервера:");
        int port = ConsoleHelper.readInt();

        try (ServerSocket serverSocket = new ServerSocket(port);) {
            ConsoleHelper.writeMessage("Чат сервер запущен.");
            while (true) {
                // Прослушивает соединение с этим сокетом и принимает его. Метод блокируется до тех пор, пока не будет установлено соединение.
                Socket clientSocket = serverSocket.accept();
                Server.Handler handler = new Handler(clientSocket);
                handler.start();
            }
        } catch (Exception ex) {
            System.out.println("Server#main(): Произошла ошибка. " + ex.getMessage());
        }
    }

    private static Map<String, Connection> connectionMap = new ConcurrentHashMap<>();

    /**
     * Рассылаем сообщение по всем соединениям
     */
    public static void sendBroadcastMessage(Message message) {
        for (Connection connection : connectionMap.values()) {
            try {
                connection.send(message);
            } catch (IOException ex) {
                ConsoleHelper.writeMessage("Отправить сообщение не удалось.");
            }
        }
    }

    private static class Handler extends Thread {
        private Socket socket;

        public Handler(Socket socket) {
            this.socket = socket;
        }

        /**
         * Этап IV: главный метод, который вызывает все вспомогательные, написанные ранее.
         */
        @Override
        public void run() {
            String connectionMessage = "Установлено новое соединение с удаленным адресом: ";
            ConsoleHelper.writeMessage(connectionMessage + socket.getRemoteSocketAddress());
            String clientName = null;

            // создать Connection, используя поле socket
            try (Connection connection = new Connection(socket)) {
                // знакомство сервера с клиентом, вернуть имя клиента
                clientName = serverHandshake(connection);

                // рассылать всем участникам чата информацию об имени присоединившегося участника
                sendBroadcastMessage(new Message(MessageType.USER_ADDED, clientName));

                // сообщать новому участнику о существующих участниках
                notifyUsers(connection, clientName);

                // запускать главный цикл обработки сообщений сервером
                serverMainLoop(connection, clientName);

            } catch (IOException | ClassNotFoundException ex1) {
                ConsoleHelper.writeMessage("Произошла ошибка при обмене данными с удаленным адресом: " + socket.getRemoteSocketAddress());
            }
            if (clientName != null) {
                connectionMap.remove(clientName);
                sendBroadcastMessage(new Message(MessageType.USER_REMOVED, clientName));
            }
            ConsoleHelper.writeMessage("Соединение с удаленным адресом " + socket.getRemoteSocketAddress() + " закрыто.");
        }

        /**
         * Реализация протокола общения с клиентом.
         * Этап I: знакомство сервера с клиентом
         */
        private String serverHandshake(Connection connection) throws IOException, ClassNotFoundException {
            connection.send(new Message(MessageType.NAME_REQUEST, "Введите имя пользователя."));
            Message receive = connection.receive();
            while (receive.getType() != MessageType.USER_NAME || receive.getData().equals("") || connectionMap.containsKey(receive.getData())) {
                connection.send(new Message(MessageType.NAME_REQUEST, "Неверные данные. Введите имя пользователя."));
                receive = connection.receive();
            }
            connectionMap.put(receive.getData(), connection);
            connection.send(new Message(MessageType.NAME_ACCEPTED));
            ConsoleHelper.writeMessage("Имя пользователя " + receive.getData() + " принято.");
            return receive.getData();
        }

        /**
         * Этап II: отправка клиенту (новому участнику) информации об остальных клиентах (участниках) чата
         */
        private void notifyUsers(Connection connection, String userName) throws IOException {
            for (String name : connectionMap.keySet()) {
                if (!name.equals(userName)) {
                    connection.send(new Message(MessageType.USER_ADDED, name));
                }
            }
        }

        /**
         * Этап III: главный цикл обработки сообщений сервером
         */
        private void serverMainLoop(Connection connection, String userName) throws IOException, ClassNotFoundException {
            while (true) {
                Message message = connection.receive();
                if (message.getType() == MessageType.TEXT) {
                    String formattedMessage = String.format("%s: %s", userName, message.getData());
                    sendBroadcastMessage(new Message(MessageType.TEXT, formattedMessage));
                } else {
                    ConsoleHelper.writeMessage("Получено сообщение от " + socket.getRemoteSocketAddress() + ". Тип сообщения не соответствует протоколу.");
                }
            }
        }
    }
}
