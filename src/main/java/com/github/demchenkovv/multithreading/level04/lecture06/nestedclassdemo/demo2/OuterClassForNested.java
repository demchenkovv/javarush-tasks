package com.github.demchenkovv.multithreading.level04.lecture06.nestedclassdemo.demo2;

/* Объявление вложенного класса */
// Вложенные статические классы имеют доступ только к статическим полям и методам содержащего их класса.
// Для создания экземпляра не требуется объект внешнего класса.
// Вложенные статические классы в основном используются для группировки.
// Пример из кода компилируется в два класса OuterClass$InnerStaticClass.class и OuterClass.class.

public class OuterClassForNested {
    private static String secret = "secret string";

    //Объявление вложенного класса
    public static class StaticNestedClass {
        static void printString(String str) {
            System.out.println(str);
        }

        void printReverseString(String str) {
            StringBuilder sb = new StringBuilder(str);
            System.out.println(sb.reverse());
        }

        static void printSecret() {
            System.out.println(secret);
        }
    }
}
