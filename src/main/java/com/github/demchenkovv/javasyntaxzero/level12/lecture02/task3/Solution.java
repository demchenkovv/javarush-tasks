package com.github.demchenkovv.javasyntaxzero.level12.lecture02.task3;

/*
Сравнение символов
*/

public class Solution {
    public static void main(String[] args) {
        compare('a', 'a');
        compare('a', 'б'); // 1072 1073
        compare('р', 'в');
        compare('ы', 'ы');
    }

    public static void compare(Character first, Character second) {
        if (first.compareTo(second) == 0) {
            System.out.println("равны");
        } else if (first > second) {
            System.out.println("больше");
        } else if (first < second) {
            System.out.println("меньше");
        } else {
            System.out.println("А как такое может быть???");
        }
    }
}


/*
Метод compare(Character, Character) принимает два символа, выводит в консоли результат их сравнения.
Реализуй метод compare(Character, Character), который должен правильно сравнивать символы.
Если код первого символа больше второго, вывести "больше".
Если код первого символа меньше второго, вывести "меньше".
Если код первого символа равен второму, вывести "равны".

Требования:
•	Исправь работу метода compare(Character, Character) с помощью изменения одного условия.
 */