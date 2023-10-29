package com.github.demchenkovv.javacore.level10.lecture04.serializationDemo.simpleSerialization;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Home home = new Home("Vishnevaia 1");
        Person igor = new Person("Igor", 2, "Raphael", home);
        Person renat = new Person("Renat", 2, "Raphael", home);

        //Сериализация в файл с помощью класса ObjectOutputStream
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(
                new FileOutputStream("person.out"));
        objectOutputStream.writeObject(igor);
        objectOutputStream.writeObject(renat);
        objectOutputStream.close();

        // Восстановление из файла с помощью класса ObjectInputStream
        ObjectInputStream objectInputStream = new ObjectInputStream(
                new FileInputStream("person.out"));
        Person igorRestored = (Person) objectInputStream.readObject();
        Person renatRestored = (Person) objectInputStream.readObject();
        objectInputStream.close();

        //Сериализация с помощью класса ByteArrayOutputStream
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ObjectOutputStream objectOutputStream2 = new ObjectOutputStream(byteArrayOutputStream);
        objectOutputStream2.writeObject(igor);
        objectOutputStream2.writeObject(renat);
        objectOutputStream2.flush();

        //Восстановление с помощью класса ByteArrayInputStream
        ObjectInputStream objectInputStream2 = new ObjectInputStream(
                new ByteArrayInputStream(byteArrayOutputStream.toByteArray()));
        Person igorRestoredFromByte = (Person) objectInputStream2.readObject();
        Person renatRestoredFromByte = (Person) objectInputStream2.readObject();
        objectInputStream2.close();

        System.out.println("Before Serialize: " + "\n" + igor + "\n" + renat);
        System.out.println("After Restored From Byte: " + "\n" + igorRestoredFromByte + "\n" + renatRestoredFromByte);
        System.out.println("After Restored: " + "\n" + igorRestored + "\n" + renatRestored);
    }
}