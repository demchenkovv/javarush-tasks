package com.github.demchenkovv.javacore.level10.lecture10.bindingExample.example1;

/** https://javarush.com/groups/posts/439-razlichija-mezhdu-rannim-i-pozdnim-svjazihvaniem-v-java */

public class Main {
    public static void main(String[] args) {

        // Пример статического и динамического связывания в Java
        Insurance current = new CarInsurance();

        // Динамическое связывание на основе объекта (позднее связывание)
        int premium = current.premium();

        // Статическое связывание на основе класса (ранее связывание)
        // Метод category() статический, а статический метод переопределить нельзя.
        // В классе CarInsurance свой метод category() не подозревающий о методе category() из класса Insurance.
        String category = current.category();

        System.out.println("premium : " + premium);
        System.out.println("category : " + category);
    }
}

class Insurance {
    public static final int LOW = 100;

    public int premium() {
        return LOW;
    }

    public static String category() {
        return "Insurance";
    }
}

class CarInsurance extends Insurance {
    public static final int HIGH = 200;

    public int premium() {
        return HIGH;
    }

    public static String category() {
        return "Car Insurance";
    }
}
