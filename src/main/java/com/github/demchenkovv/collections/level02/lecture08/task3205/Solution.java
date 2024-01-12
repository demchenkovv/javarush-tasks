package com.github.demchenkovv.collections.level02.lecture08.task3205;

/*
Создание прокси-объекта
*/

import java.lang.reflect.Proxy;

/**
 * <a href="https://javarush.com/groups/posts/2281-dinamicheskie-proksi">Динамические прокси (Dynamic Proxies) в Java</a>
 */
public class Solution {
    public static void main(String[] args) {
        SomeInterfaceWithMethods obj = getProxy();
        obj.stringMethodWithoutArgs();
        obj.voidMethodWithIntArg(1);

        /* expected output
        stringMethodWithoutArgs in
        inside stringMethodWithoutArgs
        stringMethodWithoutArgs out
        voidMethodWithIntArg in
        inside voidMethodWithIntArg
        inside voidMethodWithoutArgs
        voidMethodWithIntArg out
        */
    }

    public static SomeInterfaceWithMethods getProxy() {

        // Создаем оригинальный объект
        SomeInterfaceWithMethodsImpl obj = new SomeInterfaceWithMethodsImpl();

        // Получаем загрузчик класса у оригинального объекта
        ClassLoader classLoader = obj.getClass().getClassLoader();

        // Получаем все интерфейсы, которые реализует оригинальный объект
        Class<?>[] interfaces = obj.getClass().getInterfaces();

        // Создаем объект нашего обработчика
        CustomInvocationHandler handler = new CustomInvocationHandler(obj);

        // Создаем прокси нашего объекта obj
        SomeInterfaceWithMethods proxyObj = (SomeInterfaceWithMethods) Proxy.newProxyInstance(classLoader, interfaces, handler);

        return proxyObj;
    }
}
