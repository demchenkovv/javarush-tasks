package com.github.demchenkovv.javacore.level10.lecture10.task2;

import java.io.*;

/* 
Десериализация
*/

public class Solution {
    public A getOriginalObject(ObjectInputStream objectStream) throws IOException, ClassNotFoundException {
        try {
            Object o = objectStream.readObject();
            return (A) o;
        } catch (Exception ex) {
            System.out.println("o == null");
            return null;
        }
    }

    public class A implements Serializable {
    }

    public class B extends A {
        public B() {
            System.out.println("inside B");
        }
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
    }
}

// Решение JR
//     public A getOriginalObject(ObjectInputStream objectStream) {
//        try {
//            return (Solution.A) objectStream.readObject();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return null;
//    }