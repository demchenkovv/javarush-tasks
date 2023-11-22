package com.github.demchenkovv.multithreading.level04.lecture06.nestedclassdemo.demo2;

/* Локальные классы */
// Локальные классы создаются в блоках инициализации и в статических блоках java кода. Но чаще всего
// они используются внутри методов. Они могут обращаться только к финальным полям обрамляющего класса
// и аргументам метода. Его нельзя создать за пределами блока кода, в котором он описан.
// Локальный класс не может быть private, public, protected или static.

public class OuterClassForLocal {
    final int k = 222;

    public void someMethod(final int k, int i) {
        class LocalClass {
            public void printArg() {
                System.out.println("LocalClass.printArg(field--> " + OuterClassForLocal.this.k + " | " + k + " <--arg)");
            }
        }
        new LocalClass().printArg();
    }
}
