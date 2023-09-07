package com.github.demchenkovv.level15.lecture03.task3;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;

/*
Задом наперед
*/

public class Solution {
    public static ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    public static PrintStream stream = new PrintStream(outputStream);

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        printSomething(scanner.nextLine());
        String result = outputStream.toString();
        //напишите тут ваш код

        outputStream.reset();                                       // весь накопленный в данный момент вывод в outputStream отбрасывается
        StringBuilder stringBuilder = new StringBuilder(result);    // поместить предыдущий результат в билдер
        String reverse = stringBuilder.reverse().toString();        // развернуть строку
        printSomething(reverse);                                    // записать перевернутую строку в outputStream
        System.out.println(outputStream.toString());                // вывод в консоль
    }

    public static void printSomething(String str) {
        stream.print(str);
    }
}
