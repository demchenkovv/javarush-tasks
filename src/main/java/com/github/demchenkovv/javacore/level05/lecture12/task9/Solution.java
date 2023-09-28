package com.github.demchenkovv.javacore.level05.lecture12.task9;

/*
Порядок загрузки переменных
*/

public class Solution {

    // Шаг 1 - статик блок (1 из 2)
    static {
        init();
    }

    // Шаг 4 - анонимный блок
    {
        System.out.println("Non-static block");
        printAllFields(this);
    }

    // Шаг 5 - переменные класса
    public int i = 6;

    public String name = "First name";

    // Шаг 2 - статик блок (2 из 2)
    static {
        System.out.println("Static block");
    }

    // Шаг 6 - конструктор
    public Solution() {
        System.out.println("Solution constructor");
        printAllFields(this);
    }

    public static void init() {
        System.out.println("static void init()");
    }

    // Шаг 3 - статик метод main
    public static void main(String[] args) {
        System.out.println("public static void main");
        Solution s = new Solution();
    }

    public static void printAllFields(Solution obj) {
        System.out.println("static void printAllFields");
        System.out.println(obj.i);
        System.out.println(obj.name);
    }
}


/*
Порядок загрузки переменных
Разберись, что и в какой последовательности инициализируется в этой программе, а затем:
Поставь брейкпойнты и используй дебаггер.
Исправь порядок инициализации данных так, чтобы результат был следующим:

    static void init()
    Static block
    public static void main
    Non-static block
    static void printAllFields
    0
    null
    Solution constructor
    static void printAllFields
    6
    First name

Requirements:
1. Программа должна выводить данные на экран.
2. Вывод на экран должен соответствовать условию задачи.
3. Результатом работы статического инициализатора класса Solution должен быть вывод на экран строк "static void init()" и "Static block".
4. Программа не должна считывать данные с клавиатуры.
 */