package com.github.demchenkovv.javacore.level08.lecture11.task3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/*
Прайсы 2
*/

public class Solution {
    public static List<String> products = new ArrayList<>();
    public static String dataFilePath;

    public static void main(String[] args) throws IOException {
        if (args.length == 0) {
            return;
        }
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        dataFilePath = bufferedReader.readLine();
        bufferedReader.close();
        if (args[0].equals("-u")) {
            updateProduct(args);
            writeToFile();
        } else if (args[0].equals("-d")) {
            deleteProduct(args);
            writeToFile();
        }
    }

    private static void updateProduct(String[] args) throws IOException {
        String updateId = args[1];
        try (BufferedReader reader = new BufferedReader(new FileReader(dataFilePath))) {
            while (reader.ready()) {
                String line = reader.readLine();
                if (!line.substring(0, 8).trim().equals(updateId)) {
                    products.add(line);
                } else {
                    String fullNameProduct = String.format(Locale.ROOT, "%-8s%-30.30s%-8.2f%-4.4s",
                            updateId, args[2], Double.parseDouble(args[3]), Integer.valueOf(args[4]));
                    products.add(fullNameProduct);
                }
            }
        }
    }

    private static void deleteProduct(String[] args) throws IOException {
        String removeId = args[1];
        try (BufferedReader reader = new BufferedReader(new FileReader(dataFilePath))) {
            while (reader.ready()) {
                String str = reader.readLine();
                if (!str.substring(0, 8).trim().equals(removeId)) {
                    products.add(str);
                }
            }
        }
    }

    private static void writeToFile() throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(dataFilePath));
        for (String s : products) {
            // можно еще так ... + System.getProperty("line.separator"));
            writer.write(s + System.lineSeparator());
        }
        writer.close();
    }
}