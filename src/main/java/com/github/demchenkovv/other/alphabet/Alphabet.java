package com.github.demchenkovv.other.alphabet;

/*
Как быстро вывести английский алфавит - вывести каждый символ по его числовому значению
 */
public class Alphabet {
    public static void main(String[] args) {
        for (int i = 65; i < 65 + 26; i++) { // A == 65, B == 66 ... Z = 90
            System.out.format("%c", i);
        }
    }
}
