package com.github.demchenkovv.javacore.level10.lecture01.task3;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/* 
Знакомство с properties
*/

/**
 * <p>Класс Properties представляет собой постоянный набор свойств.
 * <p>Свойства могут быть сохранены в потоке или загружены из потока.
 * <p>Каждый ключ и соответствующее ему значение в списке свойств представляют собой строку.
 */
public class Solution {

    public static Map<String, String> runtimeStorage = new HashMap<>();

    // -- Задание: Взять параметры/свойства из мапы и передать их в выходной поток
    // prop.putAll(Map<?, ?> t) - копирует все сопоставления с (указанной карты) в this.
    // prop.store(outputStream, null) - Записывает этот список свойств (пары ключей и элементов)
    // в этой таблице свойств в выходной поток в формате, подходящем для загрузки в таблицу
    // свойств с использованием метода load(InputStream).
    public static void save(OutputStream outputStream) throws Exception {
        Properties prop = new Properties();
        prop.putAll(runtimeStorage);
        prop.store(outputStream, null);
    }

    // -- Задание: Прочитать файл с параметрами/свойствами и загрузить их в мапу
    // load(inputStream) класса Properties - считывает список свойств (пары ключей и элементов)
    // из входного потока байтов.
    public static void load(InputStream inputStream) throws IOException {
        Properties prop = new Properties();
        prop.load(inputStream);
        runtimeStorage.putAll((Map) prop);
//        prop.forEach((k, v) -> runtimeStorage.put((String) k, (String) v));
    }

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             FileInputStream inputStream = new FileInputStream("src/main/java/com/github/demchenkovv/javacore/level10/lecture01/task3/load.properties");
             OutputStream outputStream = new FileOutputStream("src/main/java/com/github/demchenkovv/javacore/level10/lecture01/task3/save.properties")) {
//             FileInputStream inputStream = new FileInputStream(reader.readLine())) {
            load(inputStream);
            save(outputStream);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        System.out.println(runtimeStorage);
    }
}