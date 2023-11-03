package com.github.demchenkovv.multithreading.level01.lecture02.task2;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/* 
Сравниваем модификаторы
*/

/**
 * <a href="https://javarush.com/groups/posts/2698-reflection-api-kak-rabotaet-metod-getmodifiers-v-klasse-class">
 * Reflection API. Как работает метод getModifiers() в классе Class</a>
 */
public class Solution {
    public static void main(String[] args) {
        int classModifiers = Solution.class.getModifiers();
        System.out.println(isModifierSet(classModifiers, Modifier.PUBLIC));   //true
        System.out.println(isModifierSet(classModifiers, Modifier.STATIC));   //false

        int methodModifiers = getMainMethod().getModifiers();
        System.out.println(isModifierSet(methodModifiers, Modifier.STATIC));      //true
    }

    public static boolean isModifierSet(int allModifiers, int specificModifier) {
//        System.out.println(Integer.toBinaryString(allModifiers));
//        System.out.println(Integer.toBinaryString(specificModifier));
        return (allModifiers & specificModifier) > 0;
    }

    private static Method getMainMethod() {
        Method[] methods = Solution.class.getDeclaredMethods();
        for (Method method : methods) {
            if (method.getName().equalsIgnoreCase("main"))
                return method;
        }
        return null;
    }
}
