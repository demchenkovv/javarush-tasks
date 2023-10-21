package com.github.demchenkovv.javacore.level09.lecture08.task4;

/*
Решаем пример
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream consoleOut = System.out;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream stream = new PrintStream(byteArrayOutputStream);
        System.setOut(stream);
        testString.printSomething();
        String line = byteArrayOutputStream.toString();
        String[] split = byteArrayOutputStream.toString().split(" ");
        int x = Integer.parseInt(split[0]);
        int y = Integer.parseInt(split[2]);
        int result;
        if (split[1].equals("+")) {
            result = x + y;
        } else if (split[1].equals("-")) {
            result = x - y;
        } else if (split[1].equals("*")) {
            result = x * y;
        } else {
            throw new IllegalArgumentException("Недопустимое действие: " + split[1]);
        }
        System.setOut(consoleOut);
        System.out.println(line + result);
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("3 + 6 = ");
        }
    }
}