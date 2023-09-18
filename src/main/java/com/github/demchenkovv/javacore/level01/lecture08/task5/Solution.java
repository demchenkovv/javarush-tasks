package com.github.demchenkovv.javacore.level01.lecture08.task5;

/*
Не забываем инкапсулировать
*/

public class Solution {
    public static void main(String[] args) {
    }

    public class Cat {
        private String name;
        private int age;
        private int weight;
        private int speed;

        public Cat(String name, int age, int weight) {

        }

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }

        public void setWeight(int weight) {
            this.weight = weight;
        }

        public void setSpeed(int speed) {
            this.speed = speed;
        }
    }
}

/*
Посмотри внимательно на методы и добавь недостающие поля.

Требования:
•	В классе Cat должно быть поле типа String с именем name.
•	В классе Cat должно быть поле типа int с именем age.
•	В классе Cat должно быть поле типа int с именем weight.
•	В классе Cat должно быть поле типа int с именем speed.
•	В классе Cat должны быть 4 поля.
•	Все поля класса Cat должны быть private.
 */