package com.github.demchenkovv.javacore.level09.lecture11.task12;

/*
Контекстная реклама
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream console = System.out;
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(baos);
        System.setOut(printStream);     // изменили вывод на ByteArrayOutputStream baos
        testString.printSomething();    // считали данные в baos
        System.setOut(console);         // вернули вывод в консоль
        String ad = "JavaRush - курсы Java онлайн";
        String[] splitLines = baos.toString().split(System.lineSeparator());
//        baos.reset();
        for (int i = 0; i < splitLines.length; i++) {
            if (i != 0 && i % 2 == 0) {
                System.out.println(ad);
                System.out.println(splitLines[i]);
            } else {
                System.out.println(splitLines[i]);
            }
        }
    }

//        // Интересное решение от студента JR
//        PrintStream defaultPSout = System.out;
//        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
//        System.setOut(new PrintStream(byteArrayOutputStream) {
//            int count = 1;
//            @Override
//            public void println(String x) {
//                if (count % 3 == 0) {
//                    super.println("JavaRush - курсы Java онлайн");
//                    count = 1;
//                }
//                super.println(x);
//                count++;
//            }
//        });
//        testString.printSomething();
//        System.setOut(defaultPSout);
//        System.out.println(byteArrayOutputStream);


    // Решение JavaRush
//    public static void main(String[] args) {
//        PrintStream defaultPrintStream = System.out;
//        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
//        System.setOut(new PrintStream(byteArrayOutputStream));
//        testString.printSomething();
//        System.setOut(defaultPrintStream);
//        String[] byteArray = byteArrayOutputStream.toString().split("\\n");
//        for (int i = 0; i < byteArray.length; i++) {
//            System.out.println(byteArray[i]);
//            if (i % 2 != 0) {
//                System.out.println("JavaRush - курсы Java онлайн");
//            }
//        }
//    }

    public static class TestString {
        public void printSomething() {
            System.out.println("first");
            System.out.println("second");
            System.out.println("third");
            System.out.println("fourth");
            System.out.println("fifth");
        }
    }
}

