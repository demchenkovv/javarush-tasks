package com.github.demchenkovv.collections.level04.lecture08.task3408;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.WeakHashMap;

/*
Комментарии к методу V getByKey(K key, Class<V> clazz) .

1. Метод getConstructor() класса Class в Java используется для получения открытого конструктора класса
с заданными параметрами.

Он принимает список параметров конструктора (типы Class) в качестве аргументов и возвращает объект типа
Constructor, который представляет собой ссылку на запрашиваемый конструктор.

Метод getConstructor() часто используется вместе с методами newInstance() для создания нового экземпляра
класса с помощью рефлексии.

Он позволяет получить доступ к конструктору даже в том случае, если конструктор не является открытым.
Таким образом, это полезный метод для создания объектов через рефлексию в тех случаях, когда невозможно
или неудобно использовать стандартные методы создания экземпляров класса.

2. Метод newInstance класса Constructor в Java нужен для создания новых экземпляров класса, используя конструктор.
Этот метод используется, когда вы не знаете конкретного класса заранее и хотите создать его динамически (во время выполнения программы).

В качестве параметров методу newInstance передается массив объектов типа Object, которые являются аргументами конструктора.
Эти аргументы должны соответствовать типам параметров конструктора.
 */


/*
Комментарии к методу boolean put(V obj):

Метод invoke класса Method вызывает реализацию метода интерфейса или экземпляра класса.
Первый аргумент метода invoke - это сам объект, а второй аргумент - аргументы метода.
В данном случае у метода K getKey() нет аргументов, поэтому мы ничего не передаем.
Метод invoke всегда возвращает значение типа Object, которое является результатом вызванного метода.
Если метод не возвращает значение (как в случае с void), то возвращается null.
*/

public class Cache<K, V> {
    private Map<K, V> cache = new WeakHashMap();
    private Method methodRef;

    public V getByKey(K key, Class<V> clazz) throws Exception {
        if (!cache.containsKey(key)) {
            Constructor<V> constructor = clazz.getConstructor(key.getClass()); // получаем конструктор класса V с параметрами K
            V value = constructor.newInstance(key); // создаем объект класса V с передачей аргумента K key конструктору
            cache.put(key, value);
        }
        return cache.get(key);
    }

    public boolean put(V obj) {
        String methodName = "getKey";
        Method methodReference;
        try {
            // получить ссылку на метод по имени метода
            methodReference = obj.getClass().getDeclaredMethod(methodName);

            // открыть доступ к приватным методам
            methodReference.setAccessible(true);

            // вызываем метод и получаем возвращаемый методом объект
            K key = (K) methodReference.invoke(obj); //
            cache.put(key, obj);
            return cache.containsKey(key);
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return false;
    }

    public int size() {
        return cache.size();
    }
}