package com.github.demchenkovv.javacore.level05.lecture12.task7;

public final class Sun implements Planet {

    private static Sun instance = null;

    private Sun() {
    }

    public static Sun getInstance() {
        if (instance == null) {
            instance = new Sun();
        }
        return instance;
    }
}
