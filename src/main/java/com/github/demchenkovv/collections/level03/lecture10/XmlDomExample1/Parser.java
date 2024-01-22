package com.github.demchenkovv.collections.level03.lecture10.XmlDomExample1;

import com.github.demchenkovv.collections.level03.lecture10.XmlDomExample1.model.*;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/*
У каждого Node есть следующие полезные методы для извлечения информации:
getNodeName – получить имя узла.
getNodeValue – получить значение узла.
getNodeType – получить тип узла.
getParentNode – получить узел, внутри которого находится данный узел.
getChildNodes – получить все производные узлы (узлы, которые внутри данного узла).
getAttributes – получить все атрибуты узла.
getOwnerDocument – получить документ этого узла.
getFirstChild/getLastChild – получить первый/последний производный узел.
getLocalName – полезно при обработке пространств имён, чтобы получить имя без префикса.
getTextContent – возвращает весь текст внутри элемента и всех элементов внутри данного элемента, включая переносы строчек и пробелы.
*/

public class Parser {
    private final String pathToXMLFile;

    public Parser(String pathToXMLFile) {
        this.pathToXMLFile = pathToXMLFile;
    }

    private Document buildDocument() {
        // Получение фабрики, чтобы после получить билдер документов.
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

        Document document;
        try {
            // Получили из фабрики билдер, который парсит XML, создает структуру Document в виде иерархического дерева.
            DocumentBuilder documentBuilder = factory.newDocumentBuilder();

            // Получаем DOM Document. Запарсили XML, создав структуру Document.
            // Теперь у нас есть доступ ко всем элементам, каким нам нужно.
            document = documentBuilder.parse(pathToXMLFile);

        } catch (Exception ex) {
            System.out.println("DocumentBuilder error occurred during parsing.");
            return null;
        }
        return document;
    }

    // Task 1
    public void parseAndPrintEmployees() {
        List<Employee> employeeList = new ArrayList<>(); // task1: Список для сотрудников из XML файла


        // Получаем DOM Document
        Document document = buildDocument();

        // Получение списка всех элементов employee внутри корневого элемента (getDocumentElement возвращает ROOT элемент XML файла).
        NodeList employeeElements = document.getDocumentElement().getElementsByTagName("employee");

        if (employeeElements.getLength() == 0) {
            return;
        }

        for (int i = 0; i < employeeElements.getLength(); i++) {
            Node employee = employeeElements.item(i);

            // Получение атрибутов каждого элемента
            NamedNodeMap attributes = employee.getAttributes();

            // Атрибут - тоже Node, потому нам нужно получить значение атрибута с помощью метода getNodeValue()
            String name = attributes.getNamedItem("name").getNodeValue();
            String job = attributes.getNamedItem("job").getNodeValue();

            // Добавление сотрудника.
            employeeList.add(new Employee(name, job));
        }

        for (Employee employee : employeeList) {
            System.out.println(employee);
        }
    }

    // Task 2
    public void printElementsAndAttributes() {
        Document document = buildDocument();
        String elementName = "";
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.print("Введите имя элемента: ");
            elementName = reader.readLine();
        } catch (IOException ex) {
            System.out.println("Error reading from console.");
            return;
        }

        // Получение списка элементов, однако для удобства будем рассматривать
        // только первое совпадение в документе. Так же заметьте, что мы ищем
        // элемент внутри документа, а не рут элемента. Это сделано для того,
        // чтобы рут элемент тоже искался.
        NodeList matchedElementsList = document.getElementsByTagName(elementName);

        // Даже если элемента нет, всегда будет возвращаться список, просто он будет пустым.
        // Потому, чтобы утверждать, что элемента нет в файле, достаточно проверить размер списка.
        if (matchedElementsList.getLength() == 0) {
            System.out.println("Тег '" + elementName + "' не был найден в файле.");
            return;
        }

        Node foundedElement = matchedElementsList.item(0);
        System.out.println("Элемент '" + elementName + "' найден!");

        if (foundedElement.hasChildNodes()) {
            printInfoAboutAllChildNodes(foundedElement.getChildNodes());
        } else if (foundedElement.hasAttributes()) {
            System.out.println("Элемент '" + elementName + "' не имеет вложенных (дочерних) узлов.");
            printAttributesOfSingleNode(foundedElement.getAttributes());
        }
    }

    private void printAttributesOfSingleNode(NamedNodeMap attrs) {
        for (int i = 0; i < attrs.getLength(); i++) {
            String attrName = attrs.item(i).getNodeName();
            String attrValue = attrs.item(i).getNodeValue();
            System.out.println(String.format("Имя атрибута: %s, его значение: %s", attrName, attrValue));
        }
    }

    /**
     * Рекурсивный метод, который выводит информацию про все узлы внутри всех узлов.
     *
     * @param nodeList Список узлов.
     */
    private void printInfoAboutAllChildNodes(NodeList nodeList) {
        for (int i = 0; i < nodeList.getLength(); i++) {
            Node node = nodeList.item(i);

            // У элементов есть два вида узлов - текстовая информация или другие элементы.
            // Потому нужно разбираться две ситуации отдельно.
            if (node.getNodeType() == Node.TEXT_NODE) {

                // Фильтрация информации, так как пробелы и переносы строчек нам не нужны. Это не информация.
                String textInformation = node.getNodeValue().replace("\n", "").trim();
                if (!textInformation.isEmpty()) {
                    System.out.println("Внутри элемента найден текст: " + textInformation);
                }

                // Если это элемент, то обрабатываем его как элемент.
            } else if (node.getNodeType() == Node.ELEMENT_NODE) {

                System.out.println("Найден элемент: " + node.getNodeName() + ", его атрибуты:");

                // Получение атрибутов
                NamedNodeMap attr = node.getAttributes();
                for (int j = 0; j < attr.getLength(); j++) {
                    System.out.println(String.format("Имя атрибута: %s, его значение: %s", attr.item(j).getNodeName(), attr.item(j).getNodeValue()));
                }
            }

            // Если у данного элемента еще остались узлы, то вывести всю информацию про все его узлы.
            if (node.hasChildNodes()) {
                printInfoAboutAllChildNodes(node.getChildNodes());
            }
        }
    }

    // Task 3
    public void printInfoStudentsProfessorsStaff() {
        // Коллекция для хранения всех людей
        List<Human> humans = new ArrayList<>();
        String[] searchElements = new String[]{"student", "professor", "member"};

        Document document = buildDocument();

        // Получение всех элементов по имени тега.
        for (int i = 0; i < searchElements.length; i++) {
            NodeList elements = document.getElementsByTagName(searchElements[i]);

            // Проверка на наличие элементов в списке
            if (elements == null || elements.getLength() == 0) {
                return;
            }

            // Получение всех атрибутов элемента
            for (int j = 0; j < elements.getLength(); j++) {
                Node node = elements.item(j);
                NamedNodeMap attrs = node.getAttributes();
                String name = attrs.getNamedItem("name").getNodeValue();

                // В зависимости от типа элемента, нам нужно собрать свою дополнительную
                // информацию про каждый подкласс, а после добавить нужные образцы в коллекцию.
                switch (node.getNodeName()) {
                    case "student": {
                        String course = attrs.getNamedItem("course").getNodeValue();
                        String specialization = attrs.getNamedItem("specialization").getNodeValue();
                        humans.add(new Student(name, course, specialization));
                        break;
                    }
                    case "professor": {
                        String experience = attrs.getNamedItem("experience").getNodeValue();
                        String discipline = attrs.getNamedItem("discipline").getNodeValue();
                        humans.add(new Professor(name, experience, discipline));
                        break;
                    }
                    case "member": {
                        String position = attrs.getNamedItem("position").getNodeValue();
                        humans.add(new Member(name, position));
                        break;
                    }
                }
            }
        }
        humans.forEach(System.out::println);
    }
}
