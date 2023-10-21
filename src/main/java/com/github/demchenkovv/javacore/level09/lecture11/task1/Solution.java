package com.github.demchenkovv.javacore.level09.lecture11.task1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import static com.github.demchenkovv.javacore.level09.lecture11.task1.Solution.Type.*;

/* 
Отслеживаем изменения
*/

public class Solution {
    public static List<LineItem> lines = new ArrayList<LineItem>();

    public static void main(String[] args) throws IOException {
        String file1;
        String file2;
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            file1 = bufferedReader.readLine();
            file2 = bufferedReader.readLine();
        }

        // Считаем все строки из файлов в отдельные списки для их сравнения
        List<String> list1 = getAllLineFromFile(file1);
        List<String> list2 = getAllLineFromFile(file2);

        // Пока списки не пустые
        // сравниваем строки из списка1 (файл1) и списка2 (файл2)
        while (list1.size() > 0 && list2.size() > 0)
            // Если строка[0] из списка1 == строке[0] из списка2, то
            // добавляем любую строку в lines с типом SAME (одинаковые)
            // удаляем строки из двух списка1 и списка2
            if (list1.get(0).equals(list2.get(0))) {
                lines.add(new LineItem(SAME, list1.get(0)));
                list1.remove(list1.get(0));
                list2.remove(list2.get(0));

                // Иначе если строка[0] из списка1 != строке[1] из списка2, то
                // значит строка[0] из списка2 была добавлена
                // добавляем строку в lines с типом ADDED
                // из списка2 удаляем строку[0]
            } else if (list1.get(0).equals(list2.get(1))) {
                lines.add(new LineItem(ADDED, list2.get(0)));
                list2.remove(list2.get(0));

                // Иначе добавляем строку[0] из списка1 и удаляем её
            } else {
                lines.add(new LineItem(REMOVED, list1.get(0)));
                list1.remove(list1.get(0));
            }

        // если в одном из списков остались элементы, то смотрим:
        // - если остались в первом, значит их удалили
        // - если остались во втором, значит их добавили
        if (list1.size() > 0) {
            lines.add(new LineItem(REMOVED, list1.get(0)));
        } else if (list2.size() > 0) {
            lines.add(new LineItem(ADDED, list2.get(0)));
        }

        for (LineItem item : lines) {
            System.out.println(item.type + " " + item.line);
        }
    }

    public static List<String> getAllLineFromFile(String filePath) throws IOException {
        List<String> result = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            while (reader.ready()) {
                String currentLine = reader.readLine();
                result.add(currentLine);
            }
        }
        return result;
    }

    public static enum Type {
        ADDED,        //добавлена новая строка
        REMOVED,      //удалена строка
        SAME          //без изменений
    }

    public static class LineItem {
        public Type type;
        public String line;

        public LineItem(Type type, String line) {
            this.type = type;
            this.line = line;
        }
    }
}
