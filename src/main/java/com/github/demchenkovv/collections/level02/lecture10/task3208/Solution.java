package com.github.demchenkovv.collections.level02.lecture10.task3208;

import java.rmi.AlreadyBoundException;
import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

/* 
RMI-2
*/

public class Solution {
    public static Registry registry;

    // Pretend we're starting an RMI client as the CLIENT_THREAD thread
    public static Thread CLIENT_THREAD = new Thread(new Runnable() {
        @Override
        public void run() {
            try {
                for (String bindingName : registry.list()) {
                    Animal service = (Animal) registry.lookup(bindingName);
                    service.printName();
                    service.speak();
                }
            } catch (RemoteException e) {
                e.printStackTrace();
            } catch (NotBoundException e) {
                e.printStackTrace();
            }
        }
    });

    // Pretend we're starting an RMI server as the SERVER_THREAD thread
    public static Thread SERVER_THREAD = new Thread(new Runnable() {
        @Override
        public void run() {
            try {
                // инициализация реестра расшареных объектов
                registry = LocateRegistry.createRegistry(2099);

                // создание объектов для "заглушек"
                Cat cat = new Cat("Vaska");
                Dog dog = new Dog("Tuzik");

                // создание "заглушки" – приемника удаленных вызовов
                Remote catStub = UnicastRemoteObject.exportObject(cat, 2099);
                Remote dogStub = UnicastRemoteObject.exportObject(dog, 2099);

                // регистрация "заглушки" в реесте
                registry.bind("cat_unic_binding_name", catStub);
                registry.bind("dog_unic_binding_name", dogStub);

            } catch (RemoteException | AlreadyBoundException ex) {
                ex.printStackTrace(System.err);
            }
        }
    });

    public static void main(String[] args) throws InterruptedException {
        // Starting an RMI server thread
        SERVER_THREAD.start();
        Thread.sleep(1000);
        // Start the client
        CLIENT_THREAD.start();
    }
}
