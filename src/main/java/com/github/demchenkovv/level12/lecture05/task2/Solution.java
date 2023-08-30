package com.github.demchenkovv.level12.lecture05.task2;

import java.util.ArrayList;
/*
Двойные фигурные скобки
*/

public class Solution {

    public static void main(String[] args) {
        var strings = new ArrayList<String>()
        {{
            add("Так");
            add("тоже");
            add("можно");
            add("делать");
            add("!");
        }};
    }
}

/*
В методе main создается список ArrayList<String>, присваивается переменной var strings и заполняется пятью элементами.
Нужно переписать код, не изменяя логику, используя двойные фигурные скобки.

Требования:
Список strings должен заполняться пятью элементами в двойных фигурных скобках.
 */