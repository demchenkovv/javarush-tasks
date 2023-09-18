package com.github.demchenkovv.javasyntaxzero.level08.lecture05.task2;

/*
Реализуй методы:
1. setFlag(int number, int flagPos) — устанавливает значение "1" биту под индексом flagPos числа number и возвращает новое значение.
2. resetFlag(int number, int flagPos) — устанавливает значение "0" биту под индексом flagPos числа number и возвращает новое значение.
3. checkFlag(int number, int flagPos) — проверяет значение бита под индексом flagPos числа number и возвращает true, если значение "1" и false, если "0".

Требования:
•	Реализуй метод setFlag(int, int) согласно условию.
•	Реализуй метод resetFlag(int, int) согласно условию.
•	Реализуй метод checkFlag(int, int) согласно условию.
 */

public class Solution {
    public static int setFlag(int number, int flagPos) {
        return number | (1 << flagPos);
    }

    public static int resetFlag(int number, int flagPos) {
        return number & ~(1 << flagPos);
    }

    public static boolean checkFlag(int number, int flagPos) {
        return (number & (1 << flagPos)) == (1 << flagPos);
    }
}