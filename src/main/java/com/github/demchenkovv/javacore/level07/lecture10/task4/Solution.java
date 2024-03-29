package com.github.demchenkovv.javacore.level07.lecture10.task4;

import java.util.*;
import java.util.function.UnaryOperator;

/*
Общий список
*/

/**
 * Как вариант, можно использовать делегирование Alt + Insert -> Delegate Methods...
 */

public class Solution implements java.util.List<Long> {
    private ArrayList<Long> original = new ArrayList<Long>();

    @Override
    public synchronized  <T> T[] toArray(T[] a) {
        return original.toArray(a);
    }

    @Override
    public synchronized void replaceAll(UnaryOperator operator) {
        original.replaceAll(operator);
    }

    @Override
    public synchronized void sort(Comparator c) {
        original.sort(c);
    }

    @Override
    public synchronized Spliterator spliterator() {
        return original.spliterator();
    }

    @Override
    public synchronized int size() {
        return original.size();
    }

    @Override
    public synchronized boolean isEmpty() {
        return original.isEmpty();
    }

    @Override
    public synchronized boolean contains(Object o) {
        return original.contains(o);
    }

    @Override
    public synchronized Iterator iterator() {
        return original.iterator();
    }

    @Override
    public synchronized Object[] toArray() {
        return original.toArray();
    }

    @Override
    public synchronized boolean add(Long aLong) {
        return original.add(aLong);
    }

    @Override
    public synchronized boolean remove(Object o) {
        return original.remove(o);
    }

    @Override
    public synchronized boolean containsAll(Collection c) {
        return original.containsAll(c);
    }

    @Override
    public synchronized boolean addAll(Collection c) {
        return original.addAll(c);
    }

    public synchronized boolean addAll(int index, Collection c) {
        return original.addAll(index, c);
    }

    @Override
    public synchronized boolean removeAll(Collection c) {
        return original.removeAll(c);
    }

    @Override
    public synchronized boolean retainAll(Collection c) {
        return original.retainAll(c);
    }

    @Override
    public synchronized void clear() {
        original.clear();
    }

    @Override
    public synchronized Long get(int index) {
        return original.get(index);
    }

    @Override
    public synchronized Long set(int index, Long element) {
        return original.set(index, element);
    }

    @Override
    public synchronized void add(int index, Long element) {
        original.add(index, element);
    }

    @Override
    public synchronized Long remove(int index) {
        return original.remove(index);
    }

    @Override
    public synchronized int indexOf(Object o) {
        return original.indexOf(o);
    }

    @Override
    public synchronized int lastIndexOf(Object o) {
        return original.lastIndexOf(o);
    }

    @Override
    public synchronized ListIterator listIterator() {
        return original.listIterator();
    }

    @Override
    public synchronized ListIterator listIterator(int index) {
        return original.listIterator(index);
    }

    @Override
    public synchronized List subList(int fromIndex, int toIndex) {
        return original.subList(fromIndex, toIndex);
    }

    public static void main(String[] args) {

    }
}
