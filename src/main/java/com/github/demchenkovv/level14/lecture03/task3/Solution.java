package com.github.demchenkovv.level14.lecture03.task3;

import java.io.FileNotFoundException;
import java.nio.file.FileSystemException;

/*
Оборачивание исключений
*/

public class Solution {

    public static void main(String[] args) {
        copyFile("book.txt", "book_final_copy.txt");
        copyFile("book_final_copy.txt", "book_last_copy.txt");
    }

    static void copyFile(String sourceFile, String destinationFile) {
        try {
            FileUtils.readFile(sourceFile);
            FileUtils.writeFile(destinationFile);
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }
}

/*
В методе copyFile перехвати исключения, которые бросают методы readFile и writeFile.
Перехваченные исключения оберни в RuntimeException и пробрось дальше.

Требования:
•	В методе copyFile должны перехватываться FileNotFoundException и FileSystemException.
•	Все перехваченные исключения нужно оборачивать в RuntimeException и пробрасывать дальше.
•	У метода copyFile не должно быть исключений в секции throws.
 */