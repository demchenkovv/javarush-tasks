package com.github.demchenkovv.level17.lecture04.task1;

/*
Минимальное и максимальное
*/

public class MinMaxUtil {

    // В два метода
//    public static int min (Integer ... num) {
//        return Collections.min(Arrays.asList(num));
//    }

//    public static int min(Integer... num) {
//        return Collections.max(Arrays.asList(num));
//    }
    public static int min(int a, int b) {
        return Math.min(a, b);
    }

    public static int min(int a, int b, int c) {
        return min(c, min(a, b));
    }

    public static int min(int a, int b, int c, int d) {
        return min(d, min(a, b, c));
    }

    public static int min(int a, int b, int c, int d, int e) {
        return min(e, min(a, b, c, d));
    }

    public static int max(int a, int b) {
        return Math.max(a, b);
    }

    public static int max(int a, int b, int c) {
        return max(c, max(a, b));
    }

    public static int max(int a, int b, int c, int d) {
        return max(d, max(a, b, c));
    }

    public static int max(int a, int b, int c, int d, int e) {
        return max(e, max(a, b, c, d));
    }
}

// Тоже как вариант
//public static int min(int a, int b) {
//    return Math.min(a, b);
//}
//
//    public static int min(int a, int b, int c) {
//        return Math.min(a, Math.min(b, c));
//    }
//
//    public static int min(int a, int b, int c, int d) {
//        return Math.min(a, Math.min(b, Math.min(c, d)));
//    }
//
//    public static int min(int a, int b, int c, int d, int e) {
//        return Math.min(a, Math.min(b, Math.min(c, Math.min(d, e))));
//    }
//
//    public static int max(int a, int b) {
//        return Math.max(a, b);
//    }
//
//    public static int max(int a, int b, int c) {
//        return Math.max(a, Math.max(b, c));
//    }
//
//    public static int max(int a, int b, int c, int d) {
//        return Math.max(a, Math.max(b, Math.max(c, d)));
//    }
//
//    public static int max(int a, int b, int c, int d, int e) {
//        return Math.max(a, Math.max(b, Math.max(c, Math.max(d, e))));
//    }
//}


/*
В этой задаче тебе предстоит создать универсальный инструмент для поиска минимальных и максимальных чисел.
В классе MinMaxUtil создай публичные статические методы min() и max(), которые в качестве аргументов принимают
целочисленные (тип int) значения и возвращают минимальное и максимальное из них соответственно.

Каждый из методов должен быть перегружен так, чтобы была возможность вызвать метод с
двумя, тремя, четырьмя и пятью параметрами.
В общем, необходимо создать 8 методов, — 4 для min() и 4 для max().
Все аргументы методов должны быть типа int.

Требования:
•	В классе MinMaxUtil должно быть создано 4 перегруженных метода min() в соответствии с условием задания.
•	В классе MinMaxUtil должно быть создано 4 перегруженных метода max() в соответствии с условием задания.
•	Методы min() должны возвращать минимальное из переданных чисел.
•	Методы max() должны возвращать максимальное из переданных чисел.
 */