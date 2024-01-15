package com.github.demchenkovv.collections.level03.lecture05.task3301;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

import java.io.IOException;
import java.io.StringWriter;
import java.util.ArrayList;

/* 
Первая сериализация в JSON
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        Cat cat = new Cat();
        cat.name = "Murka";
        cat.age = 5;
        cat.weight = 3;

        Dog dog = new Dog();
        dog.name = "Killer";
        dog.age = 8;
        dog.owner = "Bill Jeferson";

        ArrayList<Pet> pets = new ArrayList<>();
        pets.add(cat);
        pets.add(dog);

        StringWriter writer = new StringWriter();
        convertToJSON(writer, pets);
        System.out.println(writer.toString());
        //[{"name":"Murka","age":5,"weight":3},{"name":"Killer","age":8,"owner":"Bill Jeferson"}]
    }

    public static void convertToJSON(StringWriter writer, Object object) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        ObjectWriter prettyPrinter = mapper.writerWithDefaultPrettyPrinter(); // для отформатированного вывода в консоль
        prettyPrinter.writeValue(writer, object);
    }

    // К объектам, которые сериализуются/десериализуются в JSON есть несколько требований:
    // 1) поля должны быть видимые: или public или иметь getter’ы и setter’ы;
    // 2) должен быть конструктор по умолчанию (без параметров).
    // @JsonAutoDetect - помечает класс как готовый к сериализации в JSON.
    @JsonAutoDetect
    public static class Pet {
        public String name;

        public Pet() {
        }
    }

    @JsonAutoDetect
    public static class Cat extends Pet {
        public int age;
        public int weight;

        public Cat() {
        }
    }

    @JsonAutoDetect
    public static class Dog extends Pet {
        public int age;
        public String owner;

        public Dog() {
        }
    }
}
