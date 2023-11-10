package com.github.demchenkovv.multithreading.level02.lecture09.task2;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/* 
Формируем WHERE
*/

public class Solution {
    public static void main(String[] args) {
        HashMap<String, String> map = new LinkedHashMap<>();
        map.put("name", "Ivanov");
        map.put("country", "Ukraine");
        map.put("city", "Kiev");
        map.put("age", null);
        System.out.println(getQuery(map));
    }

    public static String getQuery(Map<String, String> params) {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, String> entry : params.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            if (sb.length() == 0 && value != null) {
                sb.append(key + " = '" + value + "'");
            } else if (sb.length() != 0 && value != null) {
                sb.append(" and " + key + " = '" + value + "'");
            }
        }
        return sb.toString();
    }

//     // Решение JR
//     public static String getQuery(Map<String, String> params) {
//        StringBuilder queryBuilder = new StringBuilder();
//        for (String s : params.keySet()) {
//            String value = params.get(s);
//            if (value == null) {
//                continue;
//            }
//            if (queryBuilder.toString().length() != 0) {
//                queryBuilder.append(" and ");
//            }
//            queryBuilder.append(s + " = '" + value + "'");
//        }
//        return queryBuilder.toString();
//    }
}