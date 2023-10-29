package com.github.demchenkovv.javacore.level10.lecture04.serializationDemo.simpleSerialization;

import java.io.Serializable;

class Home implements Serializable {
    private String home;

    public Home(String home) {
        this.home = home;
    }

    public String getHome() {
        return home;
    }
}
