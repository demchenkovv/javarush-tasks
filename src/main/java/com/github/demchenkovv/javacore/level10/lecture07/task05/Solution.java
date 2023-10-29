package com.github.demchenkovv.javacore.level10.lecture07.task05;

import java.io.*;

/* 
Переопределение сериализации
*/

public class Solution implements Serializable, Runnable {
    private transient Thread runner;
    private int speed;

    public Solution(int speed) {
        this.speed = speed;
        runner = new Thread(this);
        runner.start();
    }

    public void run() {
        // do something here, doesn't matter what
        System.out.println("My speed = " + speed);
    }

    /**
     * Переопределяем сериализацию.
     * Для этого необходимо объявить методы:
     * private void writeObject(ObjectOutputStream out) throws IOException
     * private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException
     * Теперь сериализация/десериализация пойдет по нашему сценарию :)
     */
    private void writeObject(ObjectOutputStream out) throws IOException {
        out.defaultWriteObject();
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject();
        runner = new Thread(this);
        runner.start();
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Solution solutionToWrite = new Solution(5);
        File temp = File.createTempFile("task2015", ".tmp");
        try (OutputStream os = new FileOutputStream(temp);
             ObjectOutputStream oos = new ObjectOutputStream(os)) {
            oos.writeObject(solutionToWrite);
        }

        Solution solutionToRead = new Solution(10);
        try (InputStream is = new FileInputStream(temp);
             ObjectInputStream ois = new ObjectInputStream(is)) {
            solutionToRead = (Solution) ois.readObject();
        }
    }
}
