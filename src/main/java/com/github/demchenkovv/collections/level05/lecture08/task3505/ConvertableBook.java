package com.github.demchenkovv.collections.level05.lecture08.task3505;

public class ConvertableBook implements Convertable<String> {
    private String name;

    public ConvertableBook(String name) {
        this.name = name;
    }

    @Override
    public String getKey() {
        return name;
    }

    @Override
    public String toString() {
        return "ConvertableBook{" +
               "name='" + name + '\'' +
               '}';
    }
}