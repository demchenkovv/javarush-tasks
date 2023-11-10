package com.github.demchenkovv.multithreading.level02.lecture09.task3;

/*
Составить цепочку слов
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        String[] words;
        try (BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
//             BufferedReader fileReader = new BufferedReader(new FileReader(console.readLine()))) {
             BufferedReader fileReader = new BufferedReader(new FileReader("src/main/java/com/github/demchenkovv/multithreading/level02/lecture09/task3/input.txt"))) {
            words = fileReader.readLine().split(" ");
        }

        StringBuilder result = getLine(words);
        System.out.println(result.toString());
    }

    public static StringBuilder getLine(String... words) {
        if (words.length == 0) {
            return new StringBuilder().append("");
        }
        StringBuilder builder = new StringBuilder();

        List<String> list = new ArrayList<>(Arrays.asList(words));
        Deque<String> deque = new LinkedList<>();
        deque.add(list.get(0));
        list.remove(list.get(0));

        while (list.size() > 0) {
            for (int i = 0; i < list.size(); i++) {
                String current = list.get(i);

                char curFirstChar = getFirstChar(current);
                char curLastChar = getLastChar(current);

                char deqFirstChar = getFirstChar(deque.getFirst());
                char deqLastChar = getLastChar(deque.getLast());

                if (deqLastChar == curFirstChar) {
                    deque.addLast(current);
                    list.remove(current);
                } else if (curLastChar == deqFirstChar) {
                    deque.addFirst(current);
                    list.remove(current);
                }
            }
            char deqFirstChar = getFirstChar(deque.getFirst());
            char deqLastChar = getLastChar(deque.getLast());
            if (deqFirstChar == deqLastChar) {
                deque.addLast(deque.getFirst());
                deque.remove(deque.getFirst());
            }
        }
        deque.forEach(e -> builder.append(e).append(" "));
        return builder;
    }

    public static char getFirstChar(String str) {
        return Character.toLowerCase(str.charAt(0));
    }

    public static char getLastChar(String str) {
        return Character.toLowerCase(str.charAt(str.length() - 1));
    }
}
