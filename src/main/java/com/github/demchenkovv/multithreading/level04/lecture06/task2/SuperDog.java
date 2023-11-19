package com.github.demchenkovv.multithreading.level04.lecture06.task2;

import java.text.SimpleDateFormat;

public abstract class SuperDog {
    protected String getSuperQuotes() {
        //some logic here
        return " *** ";
    }

    protected SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy EEE");
}
