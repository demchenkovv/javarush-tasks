package com.github.demchenkovv.level11.lecture03.task2;

/*
Утильный калькулятор
*/

public class Solution {
    public static final String EQUAL = " = ";

    public static void main(String[] args) {
        int a = 45;
        int b = 15;

        Solution.Calculator.add(a, b);
        Solution.Calculator.subtract(a, b);
        Solution.Calculator.multiply(a, b);
        Solution.Calculator.divide(a, b);
    }

    static class Calculator {
        public static void add(int a, int b) {
            System.out.println(a + " + " + b + EQUAL + (a + b));
        }

        public static void subtract(int a, int b) {
            System.out.println(a + " - " + b + EQUAL + (a - b));
        }

        public static void multiply(int a, int b) {
            System.out.println(a + " * " + b + EQUAL + (a * b));
        }

        public static void divide(int a, int b) {
            System.out.println(a + " / " + b + EQUAL + (a / b));
        }
    }
}

/*
Давай проведем рефакторинг кода: вынесем отдельно утильные методы.
Для этого создай внутренний статический (вложенный) класс Calculator
и перенеси в него методы add, subtract, multiply и divide.
Не забудь подкорректировать их вызовы.

Требования:
•	В классе Solution нужно создать вложенный (static nested) класс Calculator.
•	Методы add, subtract, multiply и divide нужно перенести в класс Calculator.
•	В методе main должны быть вызваны методы add, subtract, multiply и divide класса Calculator.
 */