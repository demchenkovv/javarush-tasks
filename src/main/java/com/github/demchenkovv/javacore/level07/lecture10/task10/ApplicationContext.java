package com.github.demchenkovv.javacore.level07.lecture10.task10;

import java.util.HashMap;
import java.util.Map;

/*
ApplicationContext
*/

public abstract class ApplicationContext<GenericsBean extends Bean> {
    private Map<String, GenericsBean> container = new HashMap<String, GenericsBean>();
    // Map<Name, some class that implements the Bean interface>


    protected ApplicationContext() {
        parseAllClassesAndInterfaces();
    }

    public synchronized GenericsBean getByName(String name) {
//        synchronized (this) {
        return container.get(name);
//        }
    }

    public synchronized GenericsBean removeByName(String name) {
//        synchronized (this){
        return container.remove(name);
//        }
    }

    protected abstract void parseAllClassesAndInterfaces();

    public static void main(String[] args) {

    }
}
