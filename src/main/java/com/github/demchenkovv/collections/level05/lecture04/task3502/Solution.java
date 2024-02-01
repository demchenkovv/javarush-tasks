package com.github.demchenkovv.collections.level05.lecture04.task3502;

/*
Знакомство с дженериками
*/

import java.util.ArrayList;
import java.util.List;

public class Solution<T1 extends List<Solution.SomeClass>> {

    public static class SomeClass<T2 extends Number> {

    }

    public static void main(String[] args) {
        Solution<List<SomeClass>> list = new Solution<>(); // ok
        Solution<ArrayList<SomeClass>> arrayList = new Solution<>(); // ok
//        Solution<SomeClass> map = new Solution(); // compilation error

        Solution.SomeClass<Integer> integerSomeClass = new SomeClass(); // ok
        Solution.SomeClass<Double> doubleSomeClass = new SomeClass(); // ok
//        Solution.SomeClass<String> stringSomeClass = new SomeClass(); // compilation error

    }
}