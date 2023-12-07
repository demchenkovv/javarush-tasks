package com.github.demchenkovv.multithreading.level06.lecture15.task3008;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * ConsoleHelper - вспомогательный класс, для чтения или записи в консоль.
 */
public class ConsoleHelper {
    private static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    public static void writeMessage(String message) {
        System.out.println(message);
    }

    public static String readString() {
        String message;
        while (true) {
            try {
                message = bufferedReader.readLine();
                break;
            } catch (IOException ex) {
                System.out.println("Произошла ошибка при попытке ввода текста. Попробуйте еще раз.");
            }
        }
        return message;
    }

    public static int readInt() {
        int number;
        while (true) {
            try {
                number = Integer.parseInt(readString());
                break;
            } catch (NumberFormatException ex) {
                System.out.println("Произошла ошибка при попытке ввода числа. Попробуйте еще раз.");
            }
        }
        return number;
    }
}
