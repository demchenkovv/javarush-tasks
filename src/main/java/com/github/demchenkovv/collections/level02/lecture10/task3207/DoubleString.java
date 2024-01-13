package com.github.demchenkovv.collections.level02.lecture10.task3207;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface DoubleString extends Remote {
    String doubleString(String str) throws RemoteException;
}