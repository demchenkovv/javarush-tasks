package com.github.demchenkovv.collections.level06.lecture06.task3602;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/*
Найти класс по описанию
*/

/*
public Class<?>[] getDeclaredClasses()
Возвращает массив объектов Class, в котором содержатся все классы и интерфейсы, объявленные
в качестве членов класса, представленного данным объектом Class. Сюда входят публичные,
защищенные, имеющие доступ по умолчанию (пакетный) и приватные классы и интерфейсы, объявленные
классом, но исключаются унаследованные классы и интерфейсы. Этот метод возвращает массив длины 0,
если в классе не объявлены классы или интерфейсы в качестве членов, или если этот объект Class
представляет примитивный тип, класс массива или void.
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println(getExpectedClass());
    }

    public static Class getExpectedClass() {
        Class<?>[] declaredClasses = Collections.class.getDeclaredClasses();
        for (Class clazz : declaredClasses) {

            // Получить модификаторы класса
            int modifiers = clazz.getModifiers();

            // Проверить на модификаторы доступа: по условию должен быть приватным статическим классом
            // и является ли класс или интерфейс, который мы передаем в качестве аргумента в параметры,
            // дочерним, предком, или тем же самым классом.
            if (Modifier.isPrivate(modifiers) && Modifier.isStatic(modifiers) && List.class.isAssignableFrom(clazz)) {
                try {
                    // Получаем конструктор и делаем его доступным, чтобы мы могли
                    // использовать его, даже если он объявлен как приватный:
                    Constructor constructor = clazz.getDeclaredConstructor();
                    constructor.setAccessible(true);

                    // Через полученный конструктор создаем экземпляр класса.
                    List object = (List) constructor.newInstance();

                    // Получаем нужный метод по имени и делаем его доступным, чтобы мы могли
                    // использовать его, даже если он объявлен как приватный.
                    // Метод принимает параметры (name - имя метода, parameterTypes - массив параметров),
                    // с которыми данный метод работает. В нашем случае это метод get, который работает
                    // с целочисленными значениями (индексами)
                    Method method = clazz.getDeclaredMethod("get", int.class);
                    method.setAccessible(true);

                    // Вызываем метод (может выбросить InvocationTargetException):
                    method.invoke(object, 0);

                    // Если метод, который вызывается с помощью рефлексии, бросает исключение, то
                    // оно будет обернуто InvocationTargetException. Это происходит, потому что
                    // вызывающий код не знает об исключении, которое может быть выброшено в вызываемом методе.
                } catch (InvocationTargetException exception) {
                    if (Objects.equals("IndexOutOfBoundsException", exception.getCause().getClass().getSimpleName())) {
                        return clazz;
                    }
                } catch (NoSuchMethodException | InstantiationException |
                         IllegalAccessException ignored) {
//                    ignored.printStackTrace();
                }
            }
        }
        return null;
    }
}