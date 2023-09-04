package com.github.demchenkovv.other.tryCatchDemo;

/**
 * Как только в какой-то строчке кода в блоке try возникнет исключение, код после нее уже не будет выполнен.
 * Выполнение программы сразу “перепрыгнет” в блок catch.
 * В блоке try во второй строчке мы попытались разделить число на 0, в результате чего возникло исключение ArithmeticException.
 * После этого строки 6-10 блока try выполнены уже не будут. Как мы и говорили, программа сразу начала выполнять блок catch.
 */
public class Example1 {
    public static void main(String[] args) {
        try {
            System.out.println("Делим число на ноль");
            System.out.println(366 / 0);        //в этой строчке кода будет выброшено исключение

            System.out.println("Этот");
            System.out.println("код");
            System.out.println("не");
            System.out.println("будет");
            System.out.println("выполнен!");

        } catch (ArithmeticException e) {
            System.out.println("Программа перепрыгнула в блок catch!");
            System.out.println("Ошибка! Нельзя делить на ноль!");
        } finally {
            System.out.println("Блок finally! Обычно здесь освобождают какие-то используемые программой ресурсы");
        }
    }
}

