package com.github.demchenkovv.javacore.level05.lecture09.task1;

import java.util.HashMap;
import java.util.Map;

/*
Статики-1
*/

public class Solution {
    public static Map<Double, String> labels = new HashMap<Double, String>();

    static {
        labels.put(1.0, "One");
        labels.put(2.718, "E");
        labels.put(3.14159, "PI");
        labels.put(4D, "With D");
        labels.put(5.0, "Five.dot.zero");
    }

    public static void main(String[] args) {
        System.out.println(labels);
    }
}


/*
Статики-1
В статическом блоке инициализируй labels пятью различными парами ключ-значение.


Requirements:
1. В классе Solution должен быть только один метод — main().
2. В классе Solution должно быть объявлено статическое поле labels типа Map.
3. Поле labels должно быть заполнено 5 различными парами ключ-значение в статическом блоке.
4. Метод main должен выводить содержимое labels на экран.
 */