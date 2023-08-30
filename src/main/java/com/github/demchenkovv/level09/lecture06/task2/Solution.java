package com.github.demchenkovv.level09.lecture06.task2;

/*
Разворот строки
*/

public class Solution {
    public static void main(String[] args) {
        String string = "Ходит кот задом наперед";
        System.out.println(string);
        System.out.println(reverseString(string));
    }

    public static String reverseString(String string) {
        //напишите тут ваш код
        return new StringBuilder(string).reverse().toString();
    }
}
/*
Используя StringBuilder в методе reverseString(String), разверни строку, полученную как параметр.

Требования:
•	Нужно, чтобы метод reverseString(String) использовал StringBuilder.
•	Нужно, чтобы метод reverseString(String) возвращал развернутую строку.
 */