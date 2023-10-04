package com.github.demchenkovv.javacore.level07.lecture04.task5;


public class IMF {

    private static IMF imf;

    private IMF() {
    }

    public static IMF getFund() {
        synchronized (IMF.class) {
            if (imf == null) {
                imf = new IMF();
            }
            return imf;
        }
    }
}
