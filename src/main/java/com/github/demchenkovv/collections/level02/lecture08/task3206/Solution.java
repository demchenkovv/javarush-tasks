package com.github.demchenkovv.collections.level02.lecture08.task3206;

/*
Дженерики для создания прокси-объекта
*/

import java.lang.reflect.Proxy;

public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        test(solution.getProxy(Item.class));                        //true false false
        test(solution.getProxy(Item.class, Small.class));           //true false true
        test(solution.getProxy(Item.class, Big.class, Small.class));//true true true
        test(solution.getProxy(Big.class, Small.class));            //true true true т.к. Big наследуется от Item
        test(solution.getProxy(Big.class));                         //true true false т.к. Big наследуется от Item
    }


    private static void test(Object proxy) {
        boolean isItem = proxy instanceof Item;
        boolean isBig = proxy instanceof Big;
        boolean isSmall = proxy instanceof Small;

        System.out.format("%b %b %b\n", isItem, isBig, isSmall);
    }

    // Используем дженерики, где T представляет собой тип данных,
    // наследуемый от интерфейса Item
    public <T extends Item> T getProxy(Class<T> item, Class... objects) {
        ClassLoader classLoader = this.getClass().getClassLoader();

        // Создаем массив с длиной количества классов доп. интерфейсов + 1
        // для помещения класса возвращаемого типа (первый параметр) и
        // классов дополнительных интерфейсов (второй параметр).
        // Копируем классы дополнительных интерфейсов в общий массив интерфейсов.
        Class<?>[] interfaces = new Class[objects.length + 1];
        interfaces[0] = item;
        System.arraycopy(objects, 0, interfaces, 1, objects.length);

        ItemInvocationHandler handler = new ItemInvocationHandler();

        T proxy = (T) Proxy.newProxyInstance(classLoader, interfaces, handler);

        return proxy;
    }
}
