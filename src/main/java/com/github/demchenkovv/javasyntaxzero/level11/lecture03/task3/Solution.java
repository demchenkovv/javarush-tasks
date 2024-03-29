package com.github.demchenkovv.javasyntaxzero.level11.lecture03.task3;

/*
Объекты внутренних и вложенных классов
*/

/**
 * Создание объекта вложенного НЕСТАТИЧЕСКОГО класса из другого класса!
 *
 * Как известно, нестатический внутренний класс должен быть связан с объектом класса-родителя.
 * Если у вас есть такой объект, конструктор внутреннего класса вызывается следующим образом.
 */

public class Solution {
    public static void main(String[] args) {

        // создание объекта вложенного нестатического класса из другого класса
        Outer outer = new Outer();
        Outer.Inner oi = outer.new Inner();
//        Outer.Inner oiv2 = new Outer().new Inner(); // так тоже можно

        // создание объекта вложенного статического класса
        Outer.Nested on = new Outer.Nested();
    }
}

/*
В классе Outer есть внутренний (Inner) и вложенный (Nested) классы.
В методе main класса Solution создай по одному объекту каждого из них.

Требования:
•	В методе main класса Solution должен быть создан объект класса Inner.
•	В методе main класса Solution должен быть создан объект класса Nested.
•	Класс Outer изменять нельзя.
 */