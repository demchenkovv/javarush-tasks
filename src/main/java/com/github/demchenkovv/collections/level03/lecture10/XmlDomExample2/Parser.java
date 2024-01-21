package com.github.demchenkovv.collections.level03.lecture10.XmlDomExample2;

import com.github.demchenkovv.collections.level03.lecture10.XmlDomExample2.model.People;
import com.github.demchenkovv.collections.level03.lecture10.XmlDomExample2.model.Root;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Parser {
    private static final String TAG_NAME_MAIN = "name";
    private static final String TAG_PEOPLE = "people";
    private static final String TAG_ELEMENT = "element";
    private static final String TAG_NAME = "name";
    private static final String TAG_AGE = "age";
    private final File xmlFile;

    public Parser(String xmlFile) {
        this.xmlFile = new File(xmlFile);
    }

    public Root parse() {
        Root root = new Root();
        Document document = null;
        try {
            document = buildDocument();
        } catch (Exception e) {
            System.out.println("Open parsing error " + e.toString());
            return null;
        }

        // Получаем корневой элемент и его дочерние элементы
        Node rootNode = document.getFirstChild();
        NodeList rootChilds = rootNode.getChildNodes();

        String mainName = null;
        // Содержимое тега <people> </people>
        Node peopleNode = null;

        // Пробегаемся по дочерним элементам корневого тега
        for (int i = 0; i < rootChilds.getLength(); i++) {
            if (rootChilds.item(i).getNodeType() != Node.ELEMENT_NODE) { // избавляемся лишнего вывода
                continue;
            }

            switch (rootChilds.item(i).getNodeName()) {
                case TAG_NAME_MAIN: {
                    mainName = rootChilds.item(i).getTextContent();
                    break;
                }
                case TAG_PEOPLE: {
                    peopleNode = rootChilds.item(i);
                    break;
                }
            }
        }

        if (peopleNode == null) {
            return null;
        }

        List<People> peopleList = parsePeopleTag(peopleNode);

        root.setName(mainName); // Записали имя тега
        root.setPeople(peopleList); // Положили все element в объект root

//        root.getPeople().stream()
//                .filter(people -> people.getAge() == 20)
//                .forEach(System.out::println);

        System.out.println("Root: " + root);
        return root;
    }

    // Возвращает: новый объект DOM Document.
    private Document buildDocument() throws Exception {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        return factory.newDocumentBuilder().parse(xmlFile);
    }

    // Парсим элементы с тегом <people>
    private List<People> parsePeopleTag(Node peopleNode) {
        List<People> peopleList = new ArrayList<>();
        NodeList peopleChilds = peopleNode.getChildNodes(); // берем внутренние элементы тега <people>
        for (int i = 0; i < peopleChilds.getLength(); i++) {
            if (peopleChilds.item(i).getNodeType() != Node.ELEMENT_NODE) { // избавляемся лишнего вывода
                continue;
            }
            if (!peopleChilds.item(i).getNodeName().equals(TAG_ELEMENT)) {
                continue;
            }

            People people = parseElementTag(peopleChilds.item(i));

            peopleList.add(people);
        }
        return peopleList;
    }

    // Парсим элементы с тегом <element>
    private People parseElementTag(Node elementNode) {
        // Парсим значения name и age элементов element
        String name = "";
        int age = 0;

        NodeList elementChilds = elementNode.getChildNodes();
        for (int j = 0; j < elementChilds.getLength(); j++) {
            if (elementChilds.item(j).getNodeType() != Node.ELEMENT_NODE) { // избавляемся лишнего вывода
                continue;
            }
            switch (elementChilds.item(j).getNodeName()) {
                case TAG_NAME: {
                    name = elementChilds.item(j).getTextContent();
                    break;
                }
                case TAG_AGE: {
                    age = Integer.parseInt(elementChilds.item(j).getTextContent());
                    break;
                }
            }
        }

        People people = new People(name, age);
        return people;
    }
}
