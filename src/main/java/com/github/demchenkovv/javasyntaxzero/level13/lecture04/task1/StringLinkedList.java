package com.github.demchenkovv.javasyntaxzero.level13.lecture04.task1;

import java.util.LinkedList;

public class StringLinkedList {
    private Node first = new Node();
    private Node last = new Node();

//    // Альтернативная реализация метода add() с конструктором по умолчанию от авторов
//    public StringLinkedList() {
//        first.next = last;          // Конструктор по умолчанию, в которых ссылки
//        last.prev = first;          // указывают на первый и последний Node без значений
//    }
//
//    // Альтернативная реализация метода add()
//    public void add(String value) {
//        Node node = new Node();     // Создаем новый Node и
//        node.value = value;         // присваиваем значение
//
//        Node lastNode = last.prev;  // Ссылка на последний Node
//        lastNode.next = node;       // Последнему Node присваиваем ссылку на новый Node
//        node.prev = lastNode;       // Новому Node присваиваем ссылку на последний Node
//        last.prev = node;           // Последний Node теперь новый Node
//    }

    public void add(String value) {
        Node nodeAdd = new Node();      // Создаем новый Node и
        nodeAdd.value = value;          // присваиваем значение

        if (last.prev == null) {        // Если ссылки на последний элемент нет, то
            last.prev = nodeAdd;        // последнему и первому Node присваиваем ссылки
            first.next = nodeAdd;       // на новый Node
            nodeAdd.prev = first;       // Новому Node присвоена ссылка на родительский Node first
        } else {
            last.prev.next = nodeAdd;   // Ссылка на следующий Node последнего Node = новый Node
            nodeAdd.prev = last.prev;   // Новому Node присвоена ссылка на последний Node
            last.prev = nodeAdd;        // Последний Node теперь новый Node
        }
    }

    public static class Node {
        private Node prev;
        private String value;
        private Node next;
    }

    public void printAll() {
        Node currentElement = first.next;
        while ((currentElement) != null) {
            System.out.println(currentElement.value);
            currentElement = currentElement.next;
        }
    }
}
