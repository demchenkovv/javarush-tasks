package com.github.demchenkovv.level12.lecture03.task1;

/*
Создаем свой список
*/

import java.util.Arrays;

public class CustomStringArrayList {

    private int size;
    private int capacity;
    private String[] elements;

    public CustomStringArrayList() {
        capacity = 10;
        size = 0;
        elements = new String[capacity];
    }

    public void add(String element) {
        if (size == capacity) {
            grow();
        }
        elements[size] = element;
        size++;
    }

    private void grow() {
        //напишите тут ваш код
        this.capacity = (int) (capacity * 1.5);
        elements = Arrays.copyOf(elements, capacity);
    }

    // Альтернативное решение № 1 - через побитовый сдвиг >> 1 (деление на 2 один раз)
//    private void grow() {
//        capacity = capacity + (capacity >> 1);
//        elements = Arrays.copyOf(elements, capacity);
//    }

    // Альтернативное решение № 2 (тот же Arrays.copyOf(), но в развернутом виде)
//    private void grow() {
//        capacity = (int) (capacity * 1.5);
//        String[] newElements = new String[capacity];
//        for (int i = 0; i < elements.length; i++) {
//            newElements[i] = elements[i];
//        }
//        elements = newElements;
//    }

    @Override
    public String toString() {
        return "CustomStringArrayList{" +
               "size=" + size +
               ", capacity=" + capacity +
               ", elements=" + Arrays.toString(elements) +
               '}';
    }
}
