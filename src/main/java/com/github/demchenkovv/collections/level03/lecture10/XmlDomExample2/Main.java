package com.github.demchenkovv.collections.level03.lecture10.XmlDomExample2;

import com.github.demchenkovv.collections.level03.lecture10.XmlDomExample2.model.Root;

/**
 * Парсинг XML в Java методом DOM на практике. Parsing XML Java. <p>
 * https://www.youtube.com/watch?v=ONfqhT_oua4
 * <p> Метод DOM достаточно ресурсоемкий и на больших
 * XML файлах будет работать медленно.
 */
public class Main {

    public static void main(String[] args) {
        String pathToXmlFile = "src/main/java/com/github/demchenkovv/collections/level03/lecture10/XmlDomExample2/test.xml";
        Parser parser = new Parser(pathToXmlFile);
        Root root = parser.parse();
    }
}
