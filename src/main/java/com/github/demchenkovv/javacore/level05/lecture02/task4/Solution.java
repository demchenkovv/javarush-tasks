package com.github.demchenkovv.javacore.level05.lecture02.task4;

import java.util.LinkedList;
import java.util.List;

/*
ООП - книги
*/

public class Solution {
    public static void main(String[] args) {
        List<Book> books = new LinkedList<Book>();
        books.add(new MarkTwainBook("Tom Sawyer"));
        books.add(new AgathaChristieBook("Hercule Poirot"));
        System.out.println(books);
    }

    abstract static class Book {
        private String author;

        public Book(String author) {
            this.author = author;
        }

        public abstract Book getBook();

        public abstract String getTitle();

        private String getOutputByBookType() {
            String agathaChristieOutput = author + ": " + getBook().getTitle() + " is a detective";
            String markTwainOutput = getBook().getTitle() + " was written by " + author;

            String output = author.equals("Mark Twain")
                    ? markTwainOutput
                    : agathaChristieOutput;

            return output;
        }

        public String toString() {
            return getOutputByBookType();
        }

    }

    public static class MarkTwainBook extends Book {

        private String title;

        public MarkTwainBook(String title) {
            super("Mark Twain");
            this.title = title;
        }

        @Override
        public MarkTwainBook getBook() {
            return this;
        }

        @Override
        public String getTitle() {
            return this.title;
        }
    }

    public static class AgathaChristieBook extends Book {

        private String title;

        public AgathaChristieBook(String title) {
            super("Agatha Christie");
            this.title = title;
        }

        @Override
        public AgathaChristieBook getBook() {
            return this;
        }

        @Override
        public String getTitle() {
            return this.title;
        }
    }
}


/*
ООП - книги
Давай напишем программу, которая будет определять жанр книги, или автора, который ее написал.
Для этого:
Создай public static класс MarkTwainBook, который наследуется от Book. Имя автора — [Mark Twain].
Параметр конструктора — название книги (title).
В классе MarkTwainBook реализуй все абстрактные методы.
Для метода getBook измени тип возвращаемого значения на более подходящий.
Создай по аналогии AgathaChristieBook. Имя автора — [Agatha Christie].
В классе Book реализуй тело метода getOutputByBookType() так, чтобы он возвращал:
agathaChristieOutput — для книг Агаты Кристи;
markTwainOutput — для книг Марка Твена.

Requirements:
1. Класс Solution должен содержать public static класс MarkTwainBook.
2. Класс MarkTwainBook должен быть потомком класса Book.
3. В классе MarkTwainBook должен быть корректно реализован конструктор с одним параметром типа String (название книги).
4. Конструктор класса MarkTwainBook должен вызывать конструктор класса предка (Book) с параметром "Mark Twain".
5. Метод getBook в классе MarkTwainBook должен иметь тип возвращаемого значения MarkTwainBook и возвращать текущий объект.
6. Класс Solution должен содержать public static класс AgathaChristieBook.
7. Класс AgathaChristieBook должен быть потомком класса Book.
8. В классе AgathaChristieBook должен быть корректно реализован конструктор с одним параметром типа String (название книги).
9. Конструктор класса AgathaChristieBook должен вызывать конструктор класса предка (Book) с параметром "Agatha Christie".
10. Метод getBook в классе AgathaChristieBook должен иметь тип возвращаемого значения AgathaChristieBook и возвращать текущий объект.
11. Метод getTitle в классах AgathaChristieBook и MarkTwainBook должен возвращать название конкретной книги.
12. Метод getOutputByBookType должен возвращать корректную строку для объектов типа AgathaChristieBook.
13. Метод getOutputByBookType должен возвращать корректную строку для объектов типа MarkTwainBook.
14. В классе MarkTwainBook должно быть создано поле title типа String (название книги).
15. В классе AgathaChristieBook должно быть создано поле title типа String (название книги).
 */