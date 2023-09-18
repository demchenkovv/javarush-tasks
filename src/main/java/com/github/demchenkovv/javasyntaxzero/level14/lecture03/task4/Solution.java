package com.github.demchenkovv.javasyntaxzero.level14.lecture03.task4;

import java.io.FileNotFoundException;
import java.nio.file.FileSystemException;

/*
Распаковка исключений
*/

public class Solution {

    public static final String FAILED_TO_READ = "Не удалось прочесть файл.";
    public static final String FAILED_TO_WRITE = "Не удалось записать в файл.";

    public static FileManager fileManager = new FileManager();

    public static void main(String[] args) {
        try {
            fileManager.copyFile("book.txt", "book_final_copy.txt");
            fileManager.copyFile("book_final_copy.txt", "book_last_copy.txt");
        } catch (RuntimeException ex) {
            Throwable cause = ex.getCause();
            if (cause instanceof FileNotFoundException) {
                System.out.println(FAILED_TO_READ);
            } else if (cause instanceof FileSystemException) {
                System.out.println(FAILED_TO_WRITE);
            }
        }
    }
}

/*
В методе main перехвати RuntimeException. Определи, какое исключение в нем сохранено.
Если это FileNotFoundException, выведи в консоли сообщение: "Не удалось прочесть файл.", а если FileSystemException — "Не удалось записать в файл.".

Требования:
•	В методе main должно перехватываться RuntimeException.
•	Нужно вывести "Не удалось прочесть файл.", если в RuntimeException упаковано FileNotFoundException.
•	Нужно вывести "Не удалось записать в файл.", если в RuntimeException упаковано FileSystemException.
•	Класс FileManager не изменяй.
 */