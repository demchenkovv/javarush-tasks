package com.github.demchenkovv.multithreading.level04.lecture06.nestedclassdemo.demo1;

public class NestedClassDemo {

    void method1() {
    }

    void method2() {
    }
}

// нормальный класс
class A {

    // статический вложенный класс
    static class B {
    }

    // внутренний класс
    class C {
    }

    void f() {
        // локальный внутренний класс
        class D {
        }
    }

    void g() {

        // анонимный класс
        NestedClassDemo bref = new NestedClassDemo() {
            void method1() {
            }
        };
    }
}