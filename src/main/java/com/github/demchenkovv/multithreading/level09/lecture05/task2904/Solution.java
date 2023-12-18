package com.github.demchenkovv.multithreading.level09.lecture05.task2904;

/* 
Особенности автобоксинга
*/

public class Solution {
    private Integer[] array = new Integer[]{1, 2, 3, 4};

    public static void main(String[] args) {
        Number value1 = new Solution().getValueByIndex(5); //-1.0, class java.lang.Double expected
        Number value2 = new Solution().getValueByIndex(2); //3, class java.lang.Integer expected

        System.out.println(value1 + ", " + value1.getClass().toString());
        System.out.println(value2 + ", " + value2.getClass().toString());
    }

    Number getValueByIndex(int index) {
        if (index >= 0 && index < array.length) {
            return array[index];
        } else {
            return new Double(-1);
        }
    }
}

// return index >= 0 && index < array.length ? array[index] : new Double(-1);
// Пример через тернарный оператор ВСЕГДА вернет Double. Так как второй и третий аргументы являются
// обёртками над разными примитивными типами, компилятор разворачивает их и приводит к
// более точному типу (в данном случае Double). А уже после выполнения тернарного оператора
// для присваивания снова выполняется боксинг. Статья на эту тему:
// https://javarush.com/groups/posts/1424-findbugs-pomogaet-uznatjh-java-luchshe

// Через тенарный оператор сработает если скастовать Double к Number, который является
// менее значимым типом, чем Integer. В этом случае наш int = 3 так и останется интом,
// а внутри Number объекта -1.0 останется информация, что он Double