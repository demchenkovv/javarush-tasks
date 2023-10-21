package com.github.demchenkovv.javacore.level09.lecture11.task3;

/*
Знакомство с тегами
*/

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.parser.Parser;
import org.jsoup.select.Elements;

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        String inputFile;
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            inputFile = reader.readLine();
        }
        String fullString = "";
        try (BufferedReader fileReader = new BufferedReader(new FileReader(inputFile))) {
            while (fileReader.ready()) {
                fullString += fileReader.readLine();
            }
        }
        Document document = Jsoup.parse(fullString, "", Parser.xmlParser());
        Elements elements = document.select(args[0]);
        for (Element e : elements) {
            System.out.println(e);
        }
    }
}

//public class Solution {
//    public static void main(String[] args) throws IOException {
//        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader reader = new BufferedReader(new FileReader(rd.readLine()));
//        StringBuilder stringBuilder = new StringBuilder();
//        String line;
//
//        while ((line = reader.readLine()) != null){
//            stringBuilder.append(line);
//        }
//        rd.close();
//        reader.close();
//
//        Document document = Jsoup.parse(stringBuilder.toString(), "", Parser.xmlParser());
//        Elements elem = document.select(args[0]);
//        for (Element elements : elem){
//            System.out.println(elements);
//        }
//    }
//}
