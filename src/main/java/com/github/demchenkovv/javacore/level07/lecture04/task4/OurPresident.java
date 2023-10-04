package com.github.demchenkovv.javacore.level07.lecture04.task4;

public class OurPresident {
    private static OurPresident president;

    static {
        synchronized (OurPresident.class) {
            if (president == null) {
                president = new OurPresident();
            } else {
                president = getOurPresident();
            }
        }
    }

    private OurPresident() {
    }

    public static OurPresident getOurPresident() {
        return president;
    }
}
