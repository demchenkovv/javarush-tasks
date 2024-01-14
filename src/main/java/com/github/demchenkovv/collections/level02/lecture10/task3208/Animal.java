package com.github.demchenkovv.collections.level02.lecture10.task3208;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Animal extends Remote {
    void speak() throws RemoteException;

    void printName() throws RemoteException;
}

