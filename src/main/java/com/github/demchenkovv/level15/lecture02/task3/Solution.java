package com.github.demchenkovv.level15.lecture02.task3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.Scanner;

/*
Еще раз читаем из консоли
*/

public class Solution {
    public static void main(String[] args) {
        try (InputStream stream = System.in;
             InputStreamReader reader = new InputStreamReader(stream);
             Scanner scanner = new Scanner(reader)) {
            String line = scanner.nextLine();
            char[] chars = line.toCharArray();
            Set<Character> characters = new HashSet<>();
            for (char aChar : chars) {
                if (Character.isAlphabetic(aChar)) {
                    characters.add(Character.toLowerCase(aChar));
                }
            }
            System.out.println(characters);
        } catch (IOException e) {
            System.out.println("Something went wrong : " + e);
        }
    }
}

/*
Программа считывает из консоли строку и выводит список букв, из которых состоит введенная строка.
Не меняя функциональности программы, перепиши код с использованием Scanner для чтения из консоли.

Требования:
•	Программа должна считать из консоли строку и вывести на экран список букв, из которых состоит введенная строка.
•	Для чтения из консоли в программе должен быть использован Scanner вместо BufferedReader.
 */