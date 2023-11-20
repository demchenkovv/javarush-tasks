package com.github.demchenkovv.multithreading.level04.lecture09.task1;

import java.util.LinkedList;
import java.util.List;

/* 
Рефакторинг, анонимные классы
*/

public class Solution {
    public static List<Iterator> iterators = new LinkedList<>();

    private int countItems;

    // Иметь класс LocalIterator не требуется.
    // Необходимо перенести только логику, т.е. инкремент и sout.
    // Нестатический блок позволяет выполнить это условие, а именно:
    // инкрементировать переменную и вывести её на консоль.
    public Iterator getIterator(final String name) {
        return new Iterator() {
            {
                countItems++;
                System.out.println(name + " item " + countItems);
            }

            @Override
            public Iterator next() {
                return getIterator(name);
            }
        };
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        Iterator iterator = solution.getIterator("iterator");
        for (int i = 1; i < 5; i++) {
            iterators.add(iterator.next());
        }
    }
}