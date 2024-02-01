package com.github.demchenkovv.collections.level05.lecture04.task3501;

/*
Вызов статического метода
*/

public class Solution {

    public static void main(String[] args) {
        Number number = GenericStatic.someStaticMethod(new Integer(3));
        String string = GenericStatic.someStaticMethod(new String("string"));
    }
}