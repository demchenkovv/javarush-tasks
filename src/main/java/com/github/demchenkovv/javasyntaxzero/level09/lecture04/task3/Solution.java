package com.github.demchenkovv.javasyntaxzero.level09.lecture04.task3;

/*
Обновление пути
*/

public class Solution {
    public static void main(String[] args) {
        String path = "/usr/java/jdk1.8/bin/";
        String jdk13 = "jdk-13";
        System.out.println(changePath(path, jdk13));
    }

    public static String changePath(String path, String jdk) {
        int start = path.indexOf("jdk");
        int finish = path.indexOf("/", start);
        String result = path.substring(0, start) + jdk + path.substring(finish);
        return result;
        // return path.replaceFirst("jdk.+?/", jdk +  "/"); // короткий вариант решения
    }
}

/*
Реализуй метод changePath(String, String) так, чтобы он заменял версию jdk в пути, полученном первым параметром метода, на версию, полученную вторым параметром, и возвращал новый путь.
Версия jdk начинается со строки "jdk" и заканчивается на "/".

Пример:
путь — "/usr/java/jdk1.8/bin/"
версия jdk — "jdk-13"

Метод changePath(путь, версия jdk) должен вернуть путь — "/usr/java/jdk-13/bin/".
Метод main() не принимает участия в тестировании.

Требования:
•	Нужно, чтобы метод changePath(String, String) был реализован согласно услови
 */