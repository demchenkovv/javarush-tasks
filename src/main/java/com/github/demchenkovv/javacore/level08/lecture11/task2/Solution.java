package com.github.demchenkovv.javacore.level08.lecture11.task2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/*
Прайсы
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        if (args.length == 4 && args[0].equals("-c")) {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            String dataFile = bufferedReader.readLine();
            bufferedReader.close();
            try (BufferedReader fileReader = new BufferedReader(new FileReader(dataFile));
                 FileWriter fileWriter = new FileWriter(dataFile, true)) {

                List<Integer> listId = new ArrayList<>();
                while (fileReader.ready()) {
                    listId.add(Integer.parseInt(fileReader.readLine().substring(0, 8).trim()));
                }
                int maxId = listId.stream().max(Integer::compareTo).get();
                String currentId = String.format("%-8d", ++maxId);
                String productName = String.format("%-30.30s", args[1]);
                String price = String.format(Locale.ROOT, "%-8.2f", Double.parseDouble(args[2]));
                String quantity = String.format("%-4d", Integer.parseInt(args[3]));

                String result = "\n" + currentId + productName + price + quantity;
                fileWriter.write(result);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
}

// Альтерантивное решение с JavaRush
// public class Solution {
//    public static class Product {
//        int id;
//        String name;
//        String price;
//        String quantity;
//
//        public Product(int id, String name, String price, String quantity) {
//            this.id = id;
//            this.name = name;
//            this.price = price;
//            this.quantity = quantity;
//        }
//
//        @Override
//        public String toString() {
//            return String.format("%-8d%-30s%-8s%-4s", id, name, price, quantity);
//        }
//    }
//
//    public static void main(String[] args) throws Exception {
//        if (args.length == 0) {
//            return;
//        }
//
//        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//        String fileName = reader.readLine();
//
//        List<Product> products = new ArrayList<>();
//
//        try (BufferedReader fileReader = new BufferedReader(new FileReader(fileName))) {
//            while (fileReader.ready()) {
//                Product product = getProduct(fileReader.readLine());
//                products.add(product);
//            }
//        }
//
//        switch (args[0]) {
//            case "-c":
//                int id = 0;
//                for (Product product : products) {
//                    if (product.id > id) id = product.id;
//                }
//                String name = "";
//                for (int i = 1; i < args.length - 2; i++) {
//                    name += args[i] + " ";
//                }
//                if (name.length() > 30) {
//                    name = name.substring(0, 30);
//                }
//                String price = args[args.length - 2];
//                if (price.length() > 8) {
//                    price = price.substring(0, 8);
//                }
//                String quantity = args[args.length - 1];
//                if (quantity.length() > 4) {
//                    quantity = quantity.substring(0, 4);
//                }
//                Product product = new Product(++id, name.trim(), price, quantity);
//                try (FileWriter fileWriter = new FileWriter(fileName, true)) {
//                    fileWriter.write("\n");
//                    fileWriter.write(product.toString());
//                }
//        }
//    }
//
//    public static Product getProduct(String string) {
//        String id = string.substring(0, 8).trim();
//        String name = string.substring(8, 38).trim();
//        String price = string.substring(38, 46).trim();
//        String quantity = string.substring(46, 50).trim();
//        return new Product(Integer.parseInt(id), name, price, quantity);
//    }
//}