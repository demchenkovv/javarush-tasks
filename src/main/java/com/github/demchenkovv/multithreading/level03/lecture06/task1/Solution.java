package com.github.demchenkovv.multithreading.level03.lecture06.task1;

/* 
Как выбрать нужное?
*/

public class Solution {
    public static final String TEST = "test";

    public static class TEST {
        @Override
        public String toString() {
            return "test class";
        }
    }

    static Object obj;

    public static void main(String[] args) {
        obj = new Solution.TEST();
        System.out.println(obj);
    }
}
