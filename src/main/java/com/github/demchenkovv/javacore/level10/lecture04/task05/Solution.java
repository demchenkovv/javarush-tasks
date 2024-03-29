package com.github.demchenkovv.javacore.level10.lecture04.task05;

/*
Как сериализовать что-то свое?
*/

import java.io.Serializable;

public class Solution {
    public static class Object implements Serializable {
        public String string1;
        public String string2;
    }

    public static int stringCount;

    public static class String implements Serializable {
        private final int number;

        public String() {
            number = ++stringCount;
        }

        public void print() {
            System.out.println("string #" + number);
        }
    }

    public static void main(String[] args) {

    }
}
