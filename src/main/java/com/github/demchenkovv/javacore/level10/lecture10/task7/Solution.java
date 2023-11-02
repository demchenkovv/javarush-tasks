package com.github.demchenkovv.javacore.level10.lecture10.task7;

import java.io.*;

/* 
Переопределение сериализации в потоке
*/

public class Solution implements Serializable, AutoCloseable {
    private transient FileOutputStream stream;
    private String fileName;

    public Solution(String fileName) throws FileNotFoundException {
        this.stream = new FileOutputStream(fileName);
        this.fileName = fileName;
    }

    public void writeObject(String string) throws IOException {
        stream.write(string.getBytes());
        stream.write("\n".getBytes());
        stream.flush();
    }

    private void writeObject(ObjectOutputStream out) throws IOException {
        out.defaultWriteObject();
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject();
        stream = new FileOutputStream(fileName, true);
    }

    @Override
    public void close() throws Exception {
        System.out.println("Closing everything!");
        stream.close();
    }

    public static void main(String[] args) throws Exception {
        Solution writeSolution = new Solution("src/main/java/com/github/demchenkovv/javacore/level10/lecture10/task7/data.txt");
        writeSolution.writeObject("writeSolution: recording data.");
        writeSolution.writeObject("writeSolution: the flush() method does not close the stream.");
        writeSolution.writeObject("writeSolution: We can write more!\n");
        writeSolution.close();

        String binFile = "src/main/java/com/github/demchenkovv/javacore/level10/lecture10/task7/binFile.bin";
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(binFile));
        oos.writeObject(writeSolution);
        oos.close();

        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(binFile));
        Solution readSolution = (Solution) ois.readObject();
        readSolution.writeObject("readSolution: the object has been restored.");
        readSolution.writeObject("readSolution: we can continue working.");
        readSolution.close();
        ois.close();
    }
}
