package com.github.demchenkovv.javacore.level09.lecture11.jsoupexample;

import java.io.File;
import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

/**
 * 3 примера как разобрать HTML-файл в Java используя Jsoup
 * https://javarush.com/groups/posts/1086-3-primera-kak-razobratjh-html-fayl-v-java-ispoljhzuja-jsoup
 */

/**
 * Java Program to parse/read HTML documents from File using Jsoup library.
 * Jsoup is an open source library which allows Java developer to parse HTML
 * files and extract elements, manipulate data, change style using DOM, CSS and
 * JQuery like method.
 *
 * @author Javin Paul
 */
public class JSoupExample2 {

    public static void main(String args[]) {

        // Parse HTML String using JSoup library
        System.out.println("JSoup Example 1: Parse HTML String using JSoup library");
        String HTMLSTring = "<!DOCTYPE html>"
                            + "<html>"
                            + "<head>"
                            + "<title>JSoup Example</title>"
                            + "</head>"
                            + "<body>"
                            + "<table><tr><td><h1>HelloWorld</h1></tr>"
                            + "</table>"
                            + "</body>"
                            + "</html>";

        Document html = Jsoup.parse(HTMLSTring);
        String title = html.title();
        String h1 = html.body().getElementsByTag("h1").text();

        System.out.println("Input HTML String to JSoup :" + HTMLSTring);
        System.out.println("After parsing, Title : " + title);
        System.out.println("Afte parsing, Heading : " + h1);

        // JSoup Example 2 - Reading HTML page from URL
        System.out.println("\n\nJSoup Example 2 - Reading HTML page from URL");
        Document doc;
        try {
            doc = Jsoup.connect("https://google.com/")
                    .userAgent("Chrome/4.0.249.0 Safari/532.5")
                    .referrer("https://www.yandex.ru")
                    .get();
            title = doc.title();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Jsoup Can read HTML page from URL, title : " + title);

        // JSoup Example 3 - Parsing an HTML file in Java
        //Document htmlFile = Jsoup.parse("login.html", "ISO-8859-1"); // wrong
        System.out.println("\n\nJSoup Example 3 - Parsing an HTML file in Java");
        Document htmlFile = null;
        try {
            htmlFile = Jsoup.parse(new File("src/main/java/com/github/demchenkovv/javacore/level09/lecture11/jsoup_example/login.html"), "ISO-8859-1");
        } catch (IOException e) {
            e.printStackTrace();
        } // right
        title = htmlFile.title();
        Element div = htmlFile.getElementById("login");
        String cssClass = div.className(); // getting class form HTML element

        System.out.println("Jsoup can also parse HTML file directly");
        System.out.println("title : " + title);
        System.out.println("class of div tag : " + cssClass);
    }
}