package com.github.demchenkovv.multithreading.level02.lecture09.task1;

import java.io.*;
import java.util.*;

/* 
Обращенные слова
*/

public class Solution {
    public static List<Pair> result = new LinkedList<>();

    // Решение JR.
    public static void main(String[] args) throws Exception {
        long a = System.currentTimeMillis();

        // src/main/java/com/github/demchenkovv/multithreading/level02/lecture09/task1/input.txt
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader fileReader = new BufferedReader(new FileReader(bufferedReader.readLine()));
        bufferedReader.close();
        Set<String> unverified = new HashSet<>();
        while (fileReader.ready()) {
            String[] data = fileReader.readLine().split(" ");
            for (String word : data) {
                StringBuilder stringBuilder = new StringBuilder(word);
                stringBuilder.reverse();
                String reversedWord = stringBuilder.toString();
                if (unverified.contains(reversedWord)) {
                    unverified.remove(reversedWord);
                    Pair pair = new Pair();
                    pair.first = word;
                    pair.second = reversedWord;
                    result.add(pair);
                } else {
                    unverified.add(word);
                }
            }
        }

        long b = System.currentTimeMillis();
        System.out.println("memory " + (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) / (8 * 1024));
        System.out.println("time = " + (b - a) / 1000);

        System.out.println(result);
    }

//    // Мое решение - не использовать (низкая производительность на больших объемах данных)
//    public static void main(String[] args) throws IOException {
//
//        long a = System.currentTimeMillis();
//
//        String s = "src/main/java/com/github/demchenkovv/multithreading/level02/lecture09/task1/input.txt";
//        try (
////                BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
//             BufferedReader fileReader = new BufferedReader(new FileReader(s))) {
//            List<String> words = new ArrayList<>();
//            while (fileReader.ready()) {
//                String[] splitLine = fileReader.readLine().split(" ");
//                Collections.addAll(words, splitLine);
//            }
//            for (int i = 0; i < words.size() - 1; i++) {
//                String word = words.get(i);
//                for (int j = i + 1; j < words.size(); j++) {
//                    StringBuilder sb = new StringBuilder(words.get(j));
//                    String reverseWord = sb.reverse().toString();
//                    if (word.equals(reverseWord)) {
//                        Pair pair = new Pair();
//                        pair.first = word;
//                        pair.second = words.get(j);
//                        result.add(pair);
//                        words.remove(j);
//                        break;
//                    }
//                }
//            }
//            long b = System.currentTimeMillis();
//            System.out.println("memory " + (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) / (8 * 1024));
//            System.out.println("time = " + (b - a) / 1000);
//
//            // System.out.println(result);
//        }
//    }

    public static class Pair {
        String first;
        String second;

        public Pair() {
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Pair pair = (Pair) o;

            if (first != null ? !first.equals(pair.first) : pair.first != null) return false;
            return second != null ? second.equals(pair.second) : pair.second == null;

        }

        @Override
        public int hashCode() {
            int result = first != null ? first.hashCode() : 0;
            result = 31 * result + (second != null ? second.hashCode() : 0);
            return result;
        }

        @Override
        public String toString() {
            return first == null && second == null ? "" :
                    first == null ? second :
                            second == null ? first :
                                    first.compareTo(second) < 0 ? first + " " + second : second + " " + first;
        }
    }
}