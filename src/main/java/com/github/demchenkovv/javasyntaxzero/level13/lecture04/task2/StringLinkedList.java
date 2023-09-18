package com.github.demchenkovv.javasyntaxzero.level13.lecture04.task2;

import java.util.Iterator;

public class StringLinkedList {
    private Node first = new Node();
    private Node last = new Node();

    public void add(String value) {
        if (first.next == null) {
            Node node = new Node();
            node.value = value;
            first.next = node;
        }
        if (last.prev == null) {
            last.prev = first.next;
            return;
        }

        Node node = new Node();
        node.value = value;

        Node lastNode = last.prev;
        lastNode.next = node;
        node.prev = lastNode;
        last.prev = node;
    }

    public String get(int index) {
        //напишите тут ваш код
        if (index < 0)
            return null;
        Node current = first;
        for (int i = 0; i <= index; i++) {
            if (current == null) {
                return null;
            }
            current = current.next;
        }
        return current.value;
    }

    public static class Node {
        private Node prev;
        private String value;
        private Node next;
    }
}