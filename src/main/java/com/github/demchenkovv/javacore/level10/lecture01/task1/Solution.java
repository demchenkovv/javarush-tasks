package com.github.demchenkovv.javacore.level10.lecture01.task1;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/* 
Читаем и пишем в файл: Human
*/

public class Solution {
    public static void main(String[] args) {
        //исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try {
            String your_file_name = "src/main/java/com/github/demchenkovv/javacore/level10/lecture01/task1/data.txt";
            OutputStream outputStream = new FileOutputStream(your_file_name);
            InputStream inputStream = new FileInputStream(your_file_name);

            Human ivanov = new Human("Ivanov",
                    new Asset("home", 999_999.99),
                    new Asset("car", 2999.99));
            ivanov.save(outputStream);
            outputStream.flush();

            Human somePerson = new Human();
            somePerson.load(inputStream);
            inputStream.close();
            //check here that ivanov equals to somePerson - проверьте тут, что ivanov и somePerson равны
            System.out.println(ivanov.equals(somePerson));

        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with my file");
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with save/load method");
        }
    }

    public static class Human {
        public String name;
        public List<Asset> assets = new ArrayList<>();

        public Human() {
        }

        public Human(String name, Asset... assets) {
            this.name = name;
            if (assets != null) {
                this.assets.addAll(Arrays.asList(assets));
            }
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Human human = (Human) o;

            if (name != null ? !name.equals(human.name) : human.name != null) return false;
            return assets != null ? assets.equals(human.assets) : human.assets == null;
        }

        @Override
        public int hashCode() {
            int result = name != null ? name.hashCode() : 0;
            result = 31 * result + (assets != null ? assets.hashCode() : 0);
            return result;
        }

        public void save(OutputStream outputStream) throws Exception {
            // PrintStream в данном случае пишет в файл, указанный в outputStream
            try (PrintStream printStream = new PrintStream(outputStream)) {
                String isNamePresent = this.name != null ? "yes" : "no";
                printStream.println(isNamePresent);
                printStream.flush();
                if (this.name != null) {
                    printStream.println(name);
                }

                String isAssetPresent = this.assets.size() > 0 ? "yes" : "no";
                printStream.println(isAssetPresent);
                outputStream.flush();
                if (isAssetPresent.equals("yes")) {
                    for (Asset asset : this.assets) {
                        printStream.println(asset.getName());
                        printStream.println(asset.getPrice());
                    }
                }
            }
        }

        public void load(InputStream inputStream) throws Exception {
            try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream))) {
                String isNamePresent = bufferedReader.readLine();
                if (isNamePresent.equals("yes")) {
                    this.name = bufferedReader.readLine();
                }

                String isAssetPresent = bufferedReader.readLine();
                if (isAssetPresent.equals("yes")) {
                    while (bufferedReader.ready()) {
                        String assetName = bufferedReader.readLine();
                        double assetPrice = Double.parseDouble(bufferedReader.readLine());
                        this.assets.add(new Asset(assetName, assetPrice));
                    }
                }
            }
        }
    }
}
//          // Решение JR
//         public void save(OutputStream outputStream) throws Exception {
//            //implement this method - реализуйте этот метод
//            PrintWriter printWriter = new PrintWriter(outputStream);
//            printWriter.println(this.name);
//            if (this.assets.size() > 0) {
//                for (Asset current : this.assets) {
//                    printWriter.println(current.getName());
//                    printWriter.println(current.getPrice());
//                }
//            }
//            printWriter.close();
//        }
//
//        public void load(InputStream inputStream) throws Exception {
//            //implement this method - реализуйте этот метод
//            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
//
//            this.name = reader.readLine();
//            while (reader.ready()) {
//                String assetName = reader.readLine();
//                double assetPrice = Double.parseDouble(reader.readLine());
//                this.assets.add(new Asset(assetName, assetPrice));
//            }
//            reader.close();
//        }
