package com.github.demchenkovv.collections.level01.lecture02.task3102;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/* 
Находим все файлы
*/

public class Solution {

    // Нерекурсивный способ получения всех файлов в каталоге и его подкаталогах в Java.
    // Вы всегда можете заменить рекурсивное решение итеративным, используя стек (для DFS) или очередь (для BFS)
    public static List<String> getFileTree(String root) throws IOException {
        List<String> result = new ArrayList<>();

        // Корневая директория
        File file = new File(root);

        // LIFO - Last In First Out
        Stack<File> stack = new Stack<>();

        // Первым элементом в стеке будет корневая директория (root)
        stack.push(file);

        while (!stack.isEmpty()) {

            // Извлекаем и удаляем элемент из стека
            File child = stack.pop();

            // Если элемент является директорией, то каждый
            // элемент директории кладем (push) в стек
            if (child.isDirectory()) {
                for (File f : child.listFiles()) {
                    stack.push(f);
                }

            // Иначе если элемент является файлом, то
            // добавляем его в результирующий список
            } else if (child.isFile()) {
                result.add(child.getAbsolutePath());
                System.out.println(child);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String path = "src/main/java/com/github/demchenkovv/collections/level01/lecture02/task3102/test";
        try {
            List<String> filePaths = getFileTree(path);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
