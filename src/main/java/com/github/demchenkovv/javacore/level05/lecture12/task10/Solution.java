package com.github.demchenkovv.javacore.level05.lecture12.task10;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/*
Файл в статическом блоке
*/

public class Solution {
    public static List<String> lines = new ArrayList<String>();

    static {
        try (FileReader fileReader = new FileReader(Statics.FILE_NAME);
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {

            while (bufferedReader.ready()) {
                String s = bufferedReader.readLine();
                lines.add(s);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        System.out.println(lines);
    }
}


/*
Файл в статическом блоке
Для решения этой задачи:
Инициализируй переменную Statics.FILE_NAME полным путем к файлу с данными, который содержит несколько строк.
В статическом блоке считай из файла с именем Statics.FILE_NAME все строки и добавь их по отдельности в List lines.

Requirements:
1. Константа FILE_NAME не должна быть пустой.
2. В статическом блоке все строки из файла с именем FILE_NAME должны быть добавлены по отдельности в список lines.
3. Поле FILE_NAME НЕ должно быть final.
4. Класс Solution должен содержать список lines.
 */