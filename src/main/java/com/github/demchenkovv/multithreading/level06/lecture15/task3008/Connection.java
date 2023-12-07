package com.github.demchenkovv.multithreading.level06.lecture15.task3008;

import java.io.Closeable;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.SocketAddress;

/**
 * Connection - класс соединения между клиентом и сервером.
 */
public class Connection implements Closeable {
    private final Socket socket;
    private final ObjectOutputStream out;
    private final ObjectInputStream in;

    public Connection(Socket socket) throws IOException {
        this.socket = socket;
        // Создать объект класса ObjectOutputStream нужно до того, как будет создаваться объект класса ObjectInputStream,
        // иначе может возникнуть взаимная блокировка потоков, которые хотят установить соединение через класс Connection.
        // Более подробно об этом ты можешь прочитать в спецификации класса ObjectInputStream.
        // и здесь https://stackoverflow.com/questions/14110986/new-objectinputstream-blocks
        out = new ObjectOutputStream(socket.getOutputStream());
        in = new ObjectInputStream(socket.getInputStream());
    }

    /**
     * Записать (сериализовать) сообщение message в ObjectOutputStream.
     * Возможна только одним потоком в определенный момент времени.
     */
    public void send(Message message) throws IOException {
        synchronized (out) {
            out.writeObject(message);
        }
    }

    /**
     * Прочитать (десериализовать) данные из ObjectInputStream.
     * Возможна только одним потоком в определенный момент времени.
     */
    public Message receive() throws IOException, ClassNotFoundException {
        synchronized (in) {
            return (Message) in.readObject();
        }
    }

    /**
     * Вернуть удаленный адрес сокетного соединения.
     */
    public SocketAddress getRemoteSocketAddress() {
        return socket.getRemoteSocketAddress();
    }

    public void close() throws IOException {
        in.close();
        out.close();
        socket.close();
    }
}
