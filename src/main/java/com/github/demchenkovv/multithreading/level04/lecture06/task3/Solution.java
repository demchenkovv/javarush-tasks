package com.github.demchenkovv.multithreading.level04.lecture06.task3;

import java.util.List;

/* 
Интернет-магазин продажи джинсов
*/

public class Solution {

    public static List<Jeans> allJeans = Util.getAllJeans();

    public static void main(String[] args) {
        for (Jeans jeans : allJeans) {
            System.out.println(jeans);
        }
    }

}
