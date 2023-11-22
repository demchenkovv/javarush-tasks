package com.github.demchenkovv.multithreading.level04.lecture06.nestedclassdemo.demo2;

public class Main {
    public static void main(String[] args) {
        String string = "Мама мыла раму";

        /* I. Вложенные статические классы (Nested) */
        //Вызов методов вложенного класса
        OuterClassForNested.StaticNestedClass.printString(string);
        //Создание экземпляра вложенного класса
        OuterClassForNested.StaticNestedClass nested = new OuterClassForNested.StaticNestedClass();
        nested.printReverseString(string);
        //Обращение к приватным полям внешнего класса через метод внутреннего класса
        OuterClassForNested.StaticNestedClass.printSecret();


        /* II. Внутренние нестатические классы (Inner) */
        OuterClassForInner.InnerMemberClass inner = new OuterClassForInner().new InnerMemberClass();
        inner.printArray(new OuterClassForInner().genArray());


        /* III. Локальные классы (Local) */
        new OuterClassForLocal().someMethod(321, 123);


        /* IV. Анонимные классы (Anonymous) */
        AnonymousClassDemo.methodForDemoAnonClass();
    }
}