package com.github.demchenkovv.multithreading.level02.lecture12.tokenizerVsSplit;

import java.util.StringTokenizer;

// split() ищет по паттерну "ne", в то время как
// tokenizer ищет "[ne]" (одну из этих букв)

public class TokenizerVsSplit {
    public static void main(String[] args) {
        String s = "Good news everyone!";
        getSplitMethod(s);
        System.out.println("-------------------");
        getStringTokenizerDemo(s);
    }

    public static void getSplitMethod(String s) {
        System.out.println("Split method result: ");
        StringTokenizer tokenizer = new StringTokenizer(s, "ne");
        while (tokenizer.hasMoreTokens()) {
            String token = tokenizer.nextToken();
            System.out.println(token + " ");
        }
    }

    public static void getStringTokenizerDemo(String s) {
        System.out.println("StringTokenizer result: ");
        String[] split = s.split("ne");
        for (String str : split) {
            System.out.println(str + " ");
        }
    }

}
