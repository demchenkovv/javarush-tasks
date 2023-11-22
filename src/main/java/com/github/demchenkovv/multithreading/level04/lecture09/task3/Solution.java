package com.github.demchenkovv.multithreading.level04.lecture09.task3;

import java.text.ChoiceFormat;
import java.text.Format;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

/* 
Знания - сила!
*/

public class Solution {
    public static void main(String[] args) {
        List<Stock> stocks = getStocks();
        sort(stocks);
        Date actualDate = new Date();
        printStocks(stocks, actualDate);
    }

    public static void printStocks(List<Stock> stocks, Date actualDate) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

        double[] filelimits = {0d, actualDate.getTime()};
        String[] filepart = {"change {4}", "open {2} and last {3}"};

        ChoiceFormat fileform = new ChoiceFormat(filelimits, filepart);
        Format[] testFormats = {null, null, dateFormat, fileform};
        MessageFormat pattform = new MessageFormat("{0}   {1} | {5} {6}");
        pattform.setFormats(testFormats);

        for (Stock stock : stocks) {
            String name = ((String) stock.get("name"));
            String symbol = (String) stock.get("symbol");
            double open = !stock.containsKey("open") ? 0 : ((double) stock.get("open"));
            double last = !stock.containsKey("last") ? 0 : ((double) stock.get("last"));
            double change = !stock.containsKey("change") ? 0 : ((double) stock.get("change"));
            Date date = (Date) stock.get("date");
            Object[] testArgs = {name, symbol, open, last, change, date, date.getTime()};
            System.out.println(pattform.format(testArgs));
        }
    }

    public static void sort(List<Stock> list) {
        list.sort(new Comparator<Stock>() {
            public int compare(Stock stock1, Stock stock2) {
                String name1 = (String) (stock1.get("name"));
                String name2 = (String) (stock2.get("name"));
                return name1.compareTo(name2);
            }
        }.thenComparing((stock1, stock2) -> {
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
            String strDate1 = dateFormat.format((Date) stock1.get("date"));
            String strDate2 = dateFormat.format((Date) stock2.get("date"));
            LocalDate localDate1 = LocalDate.parse(strDate1, DateTimeFormatter.ofPattern("dd-MM-yyyy"));
            LocalDate localDate2 = LocalDate.parse(strDate2, DateTimeFormatter.ofPattern("dd-MM-yyyy"));
            return localDate2.compareTo(localDate1);
        }).thenComparing((stock1, stock2) -> {
            // stock1
            double open1 = !stock1.containsKey("open") ? 0 : ((double) stock1.get("open"));
            double last1 = !stock1.containsKey("last") ? 0 : ((double) stock1.get("last"));
            double change1 = !stock1.containsKey("change") ? 0 : ((double) stock1.get("change"));
            // stock2
            double open2 = !stock2.containsKey("open") ? 0 : ((double) stock2.get("open"));
            double last2 = !stock2.containsKey("last") ? 0 : ((double) stock2.get("last"));
            double change2 = !stock2.containsKey("change") ? 0 : ((double) stock2.get("change"));

            int openLastDiff = Double.compare(last2 - open2, last1 - open1);
            int changeDiff = Double.compare(change2, change1);

            return openLastDiff == 0 ? changeDiff : openLastDiff;
        }));
    }

    public static class Stock extends HashMap<String, Object> {
        public Stock(String name, String symbol, double open, double last) {
            put("name", name);
            put("symbol", symbol);
            put("open", open);
            put("last", last);
            put("date", getRandomDate(java.time.LocalDate.now().getYear() + 1));
        }

        public Stock(String name, String symbol, double change, Date date) {
            put("name", name);
            put("symbol", symbol);
            put("date", date);
            put("change", change);
        }
    }

    public static List<Stock> getStocks() {
        List<Stock> stocks = new ArrayList<>();

        stocks.add(new Stock("Fake Apple Inc.", "AAPL", 125.64, 123.43));
        stocks.add(new Stock("Fake Cisco Systems, Inc.", "CSCO", 25.84, 26.3));
        stocks.add(new Stock("Fake Google Inc.", "GOOG", 516.2, 512.6));
        stocks.add(new Stock("Fake Intel Corporation", "INTC", 21.36, 21.53));
        stocks.add(new Stock("Fake Level 3 Communications, Inc.", "LVLT", 5.55, 5.54));
        stocks.add(new Stock("Fake Microsoft Corporation", "MSFT", 29.56, 29.72));

        stocks.add(new Stock("Fake Nokia Corporation (ADR)", "NOK", .1, getRandomDate()));
        stocks.add(new Stock("Fake Oracle Corporation", "ORCL", .15, getRandomDate()));
        stocks.add(new Stock("Fake Starbucks Corporation", "SBUX", .03, getRandomDate()));
        stocks.add(new Stock("Fake Yahoo! Inc.", "YHOO", .32, getRandomDate()));
        stocks.add(new Stock("Fake Applied Materials, Inc.", "AMAT", .26, getRandomDate()));
        stocks.add(new Stock("Fake Comcast Corporation", "CMCSA", .5, getRandomDate()));
        stocks.add(new Stock("Fake Sirius Satellite", "SIRI", -.03, getRandomDate()));


        return stocks;
    }

    public static Date getRandomDate() {
        return getRandomDate(1970);
    }

    public static Date getRandomDate(int startYear) {
        int year = startYear + (int) (Math.random() * 30);
        int month = (int) (Math.random() * 12);
        int day = (int) (Math.random() * 28);
        GregorianCalendar calendar = new GregorianCalendar(year, month, day);
        return calendar.getTime();
    }
}

