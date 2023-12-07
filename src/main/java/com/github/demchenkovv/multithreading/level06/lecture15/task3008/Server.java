package com.github.demchenkovv.multithreading.level06.lecture15.task3008;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

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

    private static class Handler extends Thread {

        private Socket socket;

        public Handler(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {

        }
    }
}
