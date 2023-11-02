package com.github.demchenkovv.javacore.level10.lecture10.task6;

import java.io.*;

/* 
Сериализация под запретом
*/

public class Solution implements Serializable {
    public static class SubSolution extends Solution {

        private void writeObject(ObjectOutputStream outputStream) throws IOException {
            throw new NotSerializableException();
        }

        private void readObject(ObjectInputStream inputStream) throws IOException, ClassNotFoundException {
            throw new NotSerializableException();
        }
    }


    public static void main(String[] args) throws IOException, ClassNotFoundException {
//        SubSolution subSolution = new SubSolution();
//        subSolution.writeObject(new ObjectOutputStream(new FileOutputStream("src/main/java/com/github/demchenkovv/javacore/level10/lecture10/task6/data.bin")));
//        subSolution.readObject(new ObjectInputStream(new FileInputStream("src/main/java/com/github/demchenkovv/javacore/level10/lecture10/task6/data.bin")));
    }
}
