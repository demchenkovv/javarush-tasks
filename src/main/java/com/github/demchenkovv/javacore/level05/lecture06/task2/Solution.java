package com.github.demchenkovv.javacore.level05.lecture06.task2;

/*
Максимально простой код-2
*/

public class Solution {
    public static void main(String[] args) {
        SiamCat simka = new SiamCat("Simka");
        NakedCat nakedSimka = simka.shave();
    }

    public static class NakedCat {
    }

    public static class NormalCat extends NakedCat {
        public NormalCat() {
        }

        public NormalCat(String name) {
            System.out.println("My name is " + name);
        }

        public NakedCat shave() {
            return this;
        }
    }

    public static class SiamCat extends NormalCat {
        public SiamCat(String name) {
            super(name);
        }
    }
}


/*
Максимально простой код-2
Упрости код — удали все конструкторы и вызовы конструкторов суперклассов, которые автоматически добавятся при компиляции.

Взаимосвязь между объектами классов NakedCat и NormalCat, SiamCat — Is-a: http://en.wikipedia.org/wiki/Is-a

Requirements:
1. Класс NormalCat должен быть потомком класса NakedCat.
2. Класс SiamCat должен быть потомком класса NormalCat.
3. Упрости код класса NakedCat.
4. Упрости код класса NormalCat.
 */