package com.github.demchenkovv.multithreading.level01.lecture10.task3;

public class DBConnectionManager {
    public FakeConnection getFakeConnection() {
        return new FakeConnection();
    }
}
