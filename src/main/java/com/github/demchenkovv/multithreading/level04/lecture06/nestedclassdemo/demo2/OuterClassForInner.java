package com.github.demchenkovv.multithreading.level04.lecture06.nestedclassdemo.demo2;

/* Объявление внутреннего нестатического класса */
// Данному виду внутренних классов требуется экземпляр внешнего класса.
// Он имеет доступ ко всем полям и методам экземпляра внешнего класса, в том числе приватным.
// Также он может обращаться к статическим методам и полям обрамляющего класса.
// Во внутренних классах-членах нельзя объявлять статические поля, статические методы и перечисления.

public class OuterClassForInner {
    int k = 10;
    static int i = 20;

    public class InnerMemberClass {
        public <T extends Number> void printArray(T[] arr) {
            for (T t : arr) {
                System.out.print(t.toString() + " ");
            }
            System.out.println();
            staticMethod();
            System.out.println("Outer fields: " + k + " " + i);
        }
    }

    public Integer[] genArray() {
        Integer[] arrInt = new Integer[]{10, 20, 30, 40, 90, 80, 70};
        return arrInt;
    }

    public static void staticMethod() {
        System.out.println("i'm static");
    }
}
