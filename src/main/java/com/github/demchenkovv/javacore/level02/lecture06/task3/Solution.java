package com.github.demchenkovv.javacore.level02.lecture06.task3;

/*
«Исправь код», часть 2
*/

public class Solution {
    public static void main(String[] args) {

    }

    public abstract static class Pet {
        public String getName() {
            return "Я - котенок";
        }

        public abstract Pet getChild();
    }

}


/*
«Исправь код», часть 2
Исправь код, чтобы программа компилировалась.


Requirements:
1. Класс Pet должен быть статическим.
2. Класс Pet должен иметь два метода.
3. Метод getChild() должен быть абстрактным.
4. Класс Pet должен быть объявлен с модификатором,
который запрещает создавать конкретные объекты этого класса.
 */