package com.github.demchenkovv.collections.level05.lecture10.task3507;

import java.io.*;
import java.lang.reflect.Constructor;
import java.util.HashSet;
import java.util.Set;

/*
ClassLoader - что это такое?
*/

public class Solution {

    public static void main(String[] args) {
        Set<? extends Animal> allAnimals = getAllAnimals(Solution.class.getProtectionDomain().getCodeSource().getLocation().getPath() + Solution.class.getPackage().getName().replaceAll("[.]", "/") + "/data");
        System.out.println(allAnimals);

        /*
        output: Cat
         */
    }

    public static Set<? extends Animal> getAllAnimals(String pathToAnimals) {
        Set<Animal> result = new HashSet<>();

        File[] files = new File(pathToAnimals).listFiles();

        for (File file : files) {
            if (!file.isFile() && !file.getName().endsWith(".class")) {
                continue;
            }

            String binaryName = getBinaryName(file, Solution.class);

            Class clazz = new FileClassLoader().findClass(binaryName, file.getAbsolutePath());

            int criteria = 0;

            Class[] interfaces = clazz.getInterfaces();
            for (Class inter : interfaces) {
                if (inter.getSimpleName().equals("Animal")) {
                    criteria++;
                    break;
                }
            }

            Constructor[] constructors = clazz.getConstructors();
            for (Constructor constructor : constructors) {
                if (constructor.getParameterCount() == 0) {
                    criteria++;
                }
            }

            if (criteria == 2) {
                try {
//                    Animal animal = (Animal) clazz.newInstance(); // deprecated
                    Animal animal = (Animal) clazz.getDeclaredConstructor().newInstance();
                    result.add(animal);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        }
        return result;
    }

    /**
     * Возвращает двоичное имя класса, используя текущий путь к файлу класса
     * и имя пакета вызывающего класса.
     *
     * @param file  Файл класса
     * @param clazz Класс для получения имени пакета
     * @return Бинарное имя класса
     */
    private static String getBinaryName(File file, Class clazz) {
        String dotDirectory = file.getAbsolutePath().replace(File.separator, ".");
        String packageName = Solution.class.getPackage().getName();
        String binaryName = dotDirectory.substring(dotDirectory.indexOf(packageName)).replace(".class", "");
        return binaryName;
    }

    /*
    1. https://stackoverflow.com/questions/55855435/given-only-the-full-path-to-a-class-file-how-can-i-load-its-class-object
    2. https://docs.oracle.com/javase/8/docs/api/java/lang/ClassLoader.html
    3. https://docs.oracle.com/javase/8/docs/api/java/lang/ClassLoader.html#defineClass-java.lang.String-byte:A-int-int-
     */
    public static class FileClassLoader extends ClassLoader {

        /**
         * Находит класс с указанным двоичным именем, например, java.lang.String.
         * Поэтому важно передать уже готовое двоичное имя класса или преобразовать его
         * внутри метода и передать первым аргументов в метод defineClass супер-класса.
         */
        @Override
        public Class findClass(String binaryName, String path) {
            byte[] b = loadClassData(path);
            return defineClass(binaryName, b, 0, b.length);
        }

        /**
         * Загрузить данные класса из файла
         */
        private byte[] loadClassData(String pathToFile) {
            byte[] buffer;
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            try (BufferedInputStream reader = new BufferedInputStream(new FileInputStream(pathToFile))) {
                int nextValue;
                while ((nextValue = reader.read()) != -1) {
                    baos.write(nextValue);
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            buffer = baos.toByteArray();
            return buffer;
        }
    }
}
