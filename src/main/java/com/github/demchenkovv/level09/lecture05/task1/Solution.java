package com.github.demchenkovv.level09.lecture05.task1;

/*
StringTokenizer
*/

import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) {
        String packagePath = "java.util.stream";
        String[] tokens = getTokens(packagePath, "\\.");
        System.out.println(Arrays.toString(tokens));
    }

    public static String[] getTokens(String query, String delimiter) {
        StringTokenizer st = new StringTokenizer(query, delimiter);
        String[] res = new String[st.countTokens()];
        int count = 0;
        while(st.hasMoreTokens()) {
            res[count] = st.nextToken();
            count++;
        }
        return res;
    }
}

/*
Используя StringTokenizer раздели query на части по разделителю delimiter.

Пример:
getTokens("java.util.stream", "\\.")
возвращает массив строк
{"java", "util", "stream"}

Hint: решить задачу поможет метод countTokens().

Требования:
•	Нужно, чтобы метод getTokens(String, String) использовал StringTokenizer.
•	Нужно, чтобы метод getTokens(String, String) возвращал массив типа String, заполненный согласно условию задачи.
 */