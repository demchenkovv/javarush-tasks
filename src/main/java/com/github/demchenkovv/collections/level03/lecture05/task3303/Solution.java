package com.github.demchenkovv.collections.level03.lecture05.task3303;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.FileReader;
import java.io.IOException;

/* 
Десериализация JSON объекта
*/

public class Solution {

    public static <T> T convertFromJsonToNormal(String fileName, Class<T> clazz) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(new FileReader(fileName), clazz);
    }

    public static void main(String[] args) throws IOException {
//        // for testing
//        String jsonFile = "myJsonFile.json"; // example: {"name":"Murka","age":3,"weight":7}
//        Cat cat = (Cat) convertFromJsonToNormal(jsonFile, Cat.class);
//        System.out.println(cat);
    }
}

//// for testing
//class Pet {
//    public String name;
//
//    public Pet() {
//    }
//
//    @Override
//    public String toString() {
//        return "Pet{" + "name='" + name + '\'' + '}';
//    }
//}
//
//class Cat extends Pet {
//    public int age;
//    public int weight;
//
//    public Cat() {
//    }
//
//    @Override
//    public String toString() {
//        return "Cat{" + "age=" + age + ", weight=" + weight + '}';
//    }
//}
//
//class Dog extends Pet {
//    public int age;
//    public String owner;
//
//    public Dog() {
//    }
//
//    @Override
//    public String toString() {
//        return "Dog{" + "age=" + age + ", owner='" + owner + '\'' + '}';
//    }
//}
