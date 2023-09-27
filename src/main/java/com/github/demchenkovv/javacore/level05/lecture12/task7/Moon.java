package com.github.demchenkovv.javacore.level05.lecture12.task7;

public final class Moon implements Planet {

    private static Moon instance = null;

    private Moon() {
    }

    public static Moon getInstance() {
        if (instance == null) {
            instance = new Moon();
        }
        return instance;
    }
}
