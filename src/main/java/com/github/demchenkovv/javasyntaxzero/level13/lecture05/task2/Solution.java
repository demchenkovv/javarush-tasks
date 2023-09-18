package com.github.demchenkovv.javasyntaxzero.level13.lecture05.task2;

public class Solution {

    public static void main(String[] args) {
        //напишите тут ваш код
        JavarushQuest[] javarushQuest = JavarushQuest.values();
        for (JavarushQuest el : javarushQuest)
            System.out.println(el.ordinal());
    }
}

/*
В enum JavarushQuest хранится список квестов.
Твоя задача — получить массив всех элементов в методе main (используй метод values()) и
вывести порядковый номер каждого из них (используй метод ordinal()) с новой строки.

Требования:
•	В методе main получи список всех констант из enum JavarushQuest с помощью метода values().
•	В методе main выведи порядковый номер каждого элемента с новой строки, используя метод ordinal().
 */