package com.github.demchenkovv.javasyntaxzero.level09.lecture02.task2;

/*
Кодировка Unicode
*/

public class Solution {
    public static void main(String[] args) {
        char[] symbols = new char[9];
        init(symbols);
        System.out.println(new String(symbols));
    }

    public static void init(char[] symbols) {

        for (int i = 0; i < symbols.length; i++) {
            symbols[i] = switch (i) {
                case 0 : yield '\u00A9';
                case 1 : yield '\u004A';
                case 2 : yield '\u0061';
                case 3 : yield '\u0076';
                case 4 : yield '\u0061';
                case 5 : yield '\u0052';
                case 6 : yield '\u0075';
                case 7 : yield '\u0073';
                case 8 : yield '\u0068';
                default:
                    throw new IllegalStateException("Solution#init(): ERROR! Unexpected value: " + i);
            };
        }
    }
}

/*

В публичный статический метод init(char[]) передается массив символов размером 9, который нужно заполнить следующими символами:
0 - '\u00A9'
1 - '\u004A'
2 - '\u0061'
3 - '\u0076'
4 - '\u0061'
5 - '\u0052'
6 - '\u0075'
7 - '\u0073'
8 - '\u0068'

Чтобы посмотреть результат, запусти метод main().

Требования:

 */