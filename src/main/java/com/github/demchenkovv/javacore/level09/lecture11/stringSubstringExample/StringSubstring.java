package com.github.demchenkovv.javacore.level09.lecture11.stringSubstringExample;

public class StringSubstring {
    public static void main(String[] args) {

        char[] cbuf = {'H', 'e', 'l', 'l', 'o', ' ', 'W', 'o', 'r', 'l', 'd', '!'};

        int off = 2;
        int len = 7;

        String substring1 = new String(cbuf).substring(off, len);       // llo W
        String substring2 = new String(cbuf).substring(off, off + len);   // llo Wor
        String str1 = new String(cbuf, off, len);           // llo Wor
        String str2 = new String(cbuf, off, off + len);       // llo World

        System.out.println("substring1: " + substring1);
        System.out.println("substring2: " + substring2);
        System.out.println("str1: " + str1);
        System.out.println("str2: " + str2);

    }
}
