package com.github.demchenkovv.collections.level05.lecture04.task3501;

public class GenericStatic {

    public static <T> T someStaticMethod(Object genericObject) {
        System.out.println(genericObject);
        return (T) genericObject;
    }
}
