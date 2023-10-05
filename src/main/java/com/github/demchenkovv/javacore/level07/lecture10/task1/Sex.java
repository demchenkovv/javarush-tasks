package com.github.demchenkovv.javacore.level07.lecture10.task1;

public enum Sex {
//    MALE,
//    FEMALE

    MALE("м"),
    FEMALE("ж");

    private String sexTitle;

    Sex(String sexTitle) {
        this.sexTitle = sexTitle;
    }

    public String getSexTitle() {
        return sexTitle;
    }
}
