package com.github.demchenkovv.javacore.level08.lecture11.stringFormatExample;

public class StringFormatExample {
    public static void main(String[] args) {
        String str = "Тестовая запись для демонстрации форматирования";
        // Задать ширину поля и максимальное количество символов:
        // Выравнивание текста по ЛЕВОМУ краю: ширина поля -15, макс. кол-во символов 7
        String s1 = String.format("%-15.7s", str);
        // Выравнивание текста по ПРАВОМУ краю: ширина поля 10, макс. кол-во символов 7
        String s2 = String.format("%10.7s", str);

        System.out.println("|" + s1 + "|");
        System.out.println("|" + s2 + "|");

        // ----
        String s3 = "Hello";
        String s4 = "World";
        String s5 = s3 + System.lineSeparator() + s4;
        // Альтернативный вариант lineSeparator
//        String s5 = s3 + System.getProperty("line.separator") + s4;
        System.out.println(s5);

        System.out.println(System.getProperty("os.name"));
    }
}
