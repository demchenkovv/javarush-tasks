package com.github.demchenkovv.javacore.level09.lecture08.task2;

/*
Ридер обертка 2
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream consoleOut = System.out; // 1. сохранили исходный out
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(); // 2. создали динамический массив
        PrintStream stream = new PrintStream(byteArrayOutputStream); // 3. создали свой stream с выводом в массив
        System.setOut(stream); // 4. подменили исходный out на наш c выводом в массив
        testString.printSomething(); // 5. вызвали метод, который вместо вывода в консоль, считал информацию в массив байт
        String result = byteArrayOutputStream.toString().replaceAll("te", "??"); // 6. вывели прочитанную строку
        System.setOut(consoleOut); // 7. вернули исходный out
        System.out.println(result); // 8. вывели в консоль
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("it's a text for testing");
        }
    }
}
