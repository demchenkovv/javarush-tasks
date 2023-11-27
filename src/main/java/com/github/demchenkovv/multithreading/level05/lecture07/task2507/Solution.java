package com.github.demchenkovv.multithreading.level05.lecture07.task2507;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

/* 
Работать в поте лица!
*/

/** Работа с непрерываемыми блокировками. <p>
 * Класс Solution управляет одиночным соединением сокета, осуществляя синхронное чтение из сокета.
 * Для упрощения разрыва пользовательского соединения или завершения работы сервера, класс ReaderThread
 * переопределяет метод interrupt, используя его как для доставки стандартного прерывания, так и для закрытия
 * нижележащего сокета; таким образом, прерывание экземпляра ReaderThread приводит к остановке того, что он
 * делает, независимо от того, заблокирован ли он в вызове метода read или в прерываемом блокирующем методе */
public class Solution extends Thread {
    private static final int BUFFER_SIZE = 2000;    //2000 bytes
    private final Socket socket;
    private final InputStream in;

    public Solution(Socket socket) throws IOException {
        this.socket = socket;
        this.in = socket.getInputStream();
    }

    /** Инкапсулирование нестандартной отмены в потоке путем переопределения метода interrupt */
    @Override
    public void interrupt() {
        //implement logic here
        try {
            // закрытие этого сокета также приведет к закрытию входного и выходного потоков сокета (см. .\readme.txt)
            socket.close();
        } catch (IOException ignored) {

        } finally {
            super.interrupt();
        }
    }

    public void run() {
        try {
            byte[] buf = new byte[BUFFER_SIZE];
            while (true) {
                int count = in.read(buf);
                if (count < 0) {
                    break;
                } else {
                    if (count > 0) {
                        //process buffer here
                    }
                }
            }
        } catch (IOException ignored) {
        }
    }

    public static void main(String[] args) {
    }
}
