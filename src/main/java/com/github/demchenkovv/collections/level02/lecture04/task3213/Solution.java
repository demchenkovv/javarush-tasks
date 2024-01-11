package com.github.demchenkovv.collections.level02.lecture04.task3213;

import java.io.IOException;
import java.io.StringReader;

/* 
Шифр Цезаря
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        StringReader reader = new StringReader("Khoor#Dpljr#&C,₷B'3");
        System.out.println(decode(reader, -3));  //Hello Amigo #@)₴?$0
    }

    public static String decode(StringReader reader, int key) {
        if (reader == null) {
            return "";
        }

        StringBuilder result = new StringBuilder();
        try {
            char[] buffer = new char[128];
            int len;
            while ((len = reader.read(buffer)) != -1) {
                for (int i = 0; i < len; i++) {
                    result.append((char) (buffer[i] + key));
                }
            }
        } catch (Exception ex) {
            return "";
        }
        return result.toString();
    }
}
