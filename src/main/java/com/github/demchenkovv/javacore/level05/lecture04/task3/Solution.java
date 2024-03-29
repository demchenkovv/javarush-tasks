package com.github.demchenkovv.javacore.level05.lecture04.task3;

/*
ООП - Перегрузка - убираем лишнее
*/

public class Solution {
    public static void main(String[] args) {
        print(1);
    }

//    public static void print(byte b) {
//        System.out.println("Я буду Java прогером!");
//    }

//    public static void print(double d) {
//        System.out.println("Я буду Java прогером!");
//    }

    public static void print(long l) {
        System.out.println("Я буду Java прогером!");
    }
//
//    public static void print(float f) {
//        System.out.println("Я буду Java прогером!");
//    }
//
//    public static void print(char c) {
//        System.out.println("Я буду Java прогером!");
//    }
}


/*
ООП - Перегрузка - убираем лишнее
Посмотри на реализации метода print() в коде и определи, какой из них будет вызван.
Удали все лишние реализации метода print().


Requirements:
1. В классе Solution кроме метода main должен остаться только один метод print (с правильным параметром).
2. Метод print() должен быть публичным.
3. Метод print() должен быть статическим.
4. Программа должна выводить на экран строку "Я буду Java прогером!".
 */
