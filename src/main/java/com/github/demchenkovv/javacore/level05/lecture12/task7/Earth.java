package com.github.demchenkovv.javacore.level05.lecture12.task7;

public final class Earth implements Planet {

    private static Earth instance = null;

    private Earth() {
    }

    public static Earth getInstance() {
        if (Earth.instance == null) {
            instance = new Earth();
        }
        return instance;
    }
}