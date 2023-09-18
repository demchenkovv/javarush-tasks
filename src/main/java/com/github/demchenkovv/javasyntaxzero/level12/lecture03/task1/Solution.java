package com.github.demchenkovv.javasyntaxzero.level12.lecture03.task1;

public class Solution {

    public static void main(String[] args) {
        CustomStringArrayList arrayList = new CustomStringArrayList();
        for (int i = 0; i < 25; i++) {
            arrayList.add("count" + i);
        }
        System.out.println(arrayList);
    }
}
