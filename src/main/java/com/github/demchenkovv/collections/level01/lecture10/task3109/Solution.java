package com.github.demchenkovv.collections.level01.lecture10.task3109;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

/* 
Читаем конфиги
*/

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        Properties properties = solution.getProperties("src/main/java/com/github/demchenkovv/collections/level01/lecture10/task3109/properties.xml");
        properties.list(System.out);

        properties = solution.getProperties("src/main/java/com/github/demchenkovv/collections/level01/lecture10/task3109/properties.txt");
        properties.list(System.out);

        properties = solution.getProperties("src/main/java/com/github/demchenkovv/collections/level01/lecture10/task3109/notExists");
        properties.list(System.out);
    }

    public Properties getProperties(String fileName) {
        File file = new File(fileName);
        Properties properties = new Properties();
        try {
            if (file.getName().endsWith(".xml")) {
                properties.loadFromXML(new FileInputStream(file));
            } else {
                properties.load(new FileReader(file));
            }
        } catch (IOException ex) {
            // return an empty property file
            return properties;
        }
        return properties;
    }
}
