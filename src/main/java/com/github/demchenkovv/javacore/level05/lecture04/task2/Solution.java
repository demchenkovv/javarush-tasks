package com.github.demchenkovv.javacore.level05.lecture04.task2;

public class Solution {
    public static void main(String[] args) {
        printMatrix(2, 3, "8");
    }

    public static void printMatrix(int m) {   }

    public static void printMatrix(int m, int n) {   }
    public static void printMatrix(int m, int n, String value) {
        System.out.println("Заполняем объектами String");
        printMatrix(m, n, (Object) value);
    }
    public static void printMatrix(byte m, byte n, String value) {   }
    public static void printMatrix(short m, short n, String value) {   }
    public static void printMatrix(boolean m, boolean n, String value) {   }

    public static void printMatrix(float m, float n, String value) {   }

    public static void printMatrix(int m, int n, Object value) {
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(value);
            }
            System.out.println();
        }
    }
}


/*
ООП - Перегрузка
Перегрузи метод printMatrix() 8 различными способами, чтобы в итоге у тебя получилось 10 различных методов printMatrix().


Requirements:
1. В классе Solution должны быть реализованы 10 методов printMatrix() с различными аргументами.
2. Класс Solution должен быть public.
3. Все методы класса Solution должны быть статическими.
4. Все методы класса Solution должны быть публичными.
 */
