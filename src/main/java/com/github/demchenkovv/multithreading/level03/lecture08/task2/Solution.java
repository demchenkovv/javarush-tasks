package com.github.demchenkovv.multithreading.level03.lecture08.task2;

/* 
Напряги извилины!
*/

public class Solution {
    private String name;

    Solution(String name) {
        this.name = name;
    }

    // Метод getName был с модификатором private.
    // Почему надо было изменить модификатор на public или protected? См. readme.txt
    protected String getName() {
        return name;
    }

    private void sout() {
        new Solution("The Darkside Hacker") {
            void printName() {
                System.out.println(getName());
            }
        }.printName();
    }

    public static void main(String[] args) {
        new Solution("Риша").sout();
    }
}
