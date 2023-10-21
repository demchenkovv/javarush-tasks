package com.github.demchenkovv.javacore.level09.lecture11.jsoupexample;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;

/**
 * Парсинг html библиотекой jsoup
 * https://javarush.com/groups/posts/2767-parsing-html-bibliotekoy-jsoup-
 */

@SuppressWarnings("all")
public class JSoupExample1 {
    public static void main(String[] args)
            throws IOException {

        /** Шаг 1. Получить объект Document.*/
        // Это представление нашей html страницы.

        // Вариант 1: Подключиться к серверу
        // User Agent является идентификатором, который сообщается посещаемому сайту. На многих сайтах он является важнейшим критерием для антиспам фильтра.
        // Referrer содержит URL источника запроса.
        Document doc = Jsoup.connect("https://yandex.ru/")
                .userAgent("Chrome/4.0.249.0 Safari/532.5")
                .referrer("http://www.google.com")
                .get();

//        // Вариант 2: Из файла
//        File file = new File("src/main/java/com/github/demchenkovv/javacore/level09/lecture11/jsoup_example/hhExample.html");
//        Document fileDocument = Jsoup.parse(file, "UTF-8", "hh.ru");

        // Вариант 3: Из строки
        String html =
                "<html>                                                                       " +
                "    <head>                                                                   " +
                "        <title href=\"hh.ru/vacancy?home\">                                  " +
                "            Работа в Москве, поиск персонала и публикация вакансий - hh.ru   " +
                "        </title>                                                             " +
                "    </head>                                                                  " +
                "    <body>                                                                   " +
                "        <div class=\"header main\">                                          " +
                "            <h1>Работа найдется для каждого</h1>                             " +
                "            <div>Поиск вакансий</div>                                        " +
                "        </div>                                                               " +
                "        <div class=\"content\">                                              " +
                "            <div>Вакансии дня</div>                                          " +
                "            <div id=\"123\">Компании дня</div>                               " +
                "            <div>Работа из дома</div>                                        " +
                "        </div>                                                               " +
                "    </body>                                                                  " +
                "</html>                                                                      ";
        Document httpDocument = Jsoup.parse(html, "hh.ru");


        /** Шаг 2. Получение тега*/
        // Основная задача при парсинге - получить нужный тег при помощи метода select.
        // Получить теги h1
        Elements h1 = httpDocument.select("h1");

        // Получить теги title.
        // Знак > выбирает теги title вложенные в тег head
        Elements titleElem = httpDocument.select("head > title");

        // Получить теги div вложенные в body
        Elements divs = httpDocument.select("body > div");

        // Получить первый тег div вложенный в body.
        Elements firstDiv = httpDocument.select("body > div:nth-child(1)");

        /** Получать тег по порядковому номеру плохой способ, потому что его положение на сайте может поменяться.
         * Лучше определить тег по абсолютным параметрам. Такими параметрами являются атрибуты class и id */
        // Получить тег div c классом "content", вложенный в body
        Elements contentElem = httpDocument.select("body > div.content");

        // Получить теги c id "123"
        Elements idElem = httpDocument.select("#123");

        // Получить теги div c классом "header" и "main", вложенные в body,  но без тегов h1
        Elements divHeader = httpDocument.select("body > div.header.main :not(h1)");
        System.out.println(divHeader);

        /** Методы Elements */
        // Когда мы получили список Elements можно извлечь данные из него.
        // Обычно селектором ищется один тег, т.е. у Elements должен быть размер 1.

//        elements.size(); // количество найденных тегов
//        elements.get(0); // получить первый тег из списка найденных
//        elements.text(); // текст вложенный в тег
//        elements.attr("href"); // значение атрибута "href"
//        elements.outerHtml(); // строковое представление тега
    }
}
