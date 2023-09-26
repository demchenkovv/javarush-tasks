package com.github.demchenkovv.javacore.level04.lecture08.task6;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
MovieFactory
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        try (InputStreamReader inputStreamReader = new InputStreamReader(System.in);
             BufferedReader bufferedReader = new BufferedReader(inputStreamReader)) {

            String key = bufferedReader.readLine();
            Movie movie = null;
            while (true) {
                if (!key.matches("soapOpera|cartoon|thriller")) {
                    MovieFactory.getMovie(key);
                    break;
                }
                movie = MovieFactory.getMovie(key);
                System.out.println(movie.getClass().getSimpleName());
                key = bufferedReader.readLine();
            }

//            while ((key = reader.readLine()) != null) {
//                Movie movie = MovieFactory.getMovie(key);
//                if (movie == null) {
//                    return;
//                }
//                System.out.println(movie.getClass().getSimpleName());
//            }
        }
    }

    static class MovieFactory {

        static Movie getMovie(String key) {
            Movie movie = null;

            if ("soapOpera".equals(key)) {
                movie = new SoapOpera();
            } else if ("cartoon".equals(key)) {
                movie = new Cartoon();
            } else if ("thriller".equals(key)) {
                movie = new Thriller();
            }

            return movie;
        }
    }

    static abstract class Movie {
    }

    static class SoapOpera extends Movie {
    }

    static class Cartoon extends Movie {

    }

    static class Thriller extends Movie {
    }
}


/*
MovieFactory
У нас есть кинофабрика, но она работает не в полную силу.
Давай расширим ее функционал по аналогии с тем, что уже есть, и добавим чтение с консоли.
Вот что тебе нужно сделать для успешного решения:
1. Разобраться, что программа умеет делать.
2. Все классы должны быть внутри класса Solution.
3. Добавить классы Cartoon, Thriller.
4. Разобраться, как мы получаем объект класса SoapOpera по ключу "soapOpera".
5. Аналогично получению объекта SoapOpera сделать:
    - добавить в MovieFactory.getMovie получение объекта Cartoon для ключа "cartoon".
    - добавить в MovieFactory.getMovie получение объекта Thriller для ключа "thriller".
6. Считать с консоли несколько ключей (строк).
Важно: ввод заканчивается, как только вводится строка не совпадающая с одной из: "cartoon", "thriller", "soapOpera".

7. Создать переменную movie типа Movie и для каждой введенной строки (ключа):
получить объект используя MovieFactory.getMovie и присвоить его переменной movie.
вывести на экран movie.getClass().getSimpleName().

Requirements:
1. Классы Cartoon и Thriller должны быть статическими и существовать внутри класса Solution.
2. Метод MovieFactory.getMovie должен возвращать объект типа Cartoon при передаче ему строки "cartoon" в качестве параметра.
3. Метод MovieFactory.getMovie должен возвращать объект типа Thriller при передаче ему строки "thriller" в качестве параметра.
4. Метод main должен считывать строки с клавиатуры.
5. Метод main должен прекращать считывать строки с клавиатуры, если была введена некорректная строка (не "cartoon", не "thriller" или не "soapOpera").
6. Для каждой введенной строки (в том числе для некорректной) необходимо вызвать метод MovieFactory.getMovie().
7. Для всех введенных корректных строк необходимо вывести на экран простые имена (movie.getClass().getSimpleName()) типов объектов, возвращаемых методом MovieFactory.getMovie().
 */