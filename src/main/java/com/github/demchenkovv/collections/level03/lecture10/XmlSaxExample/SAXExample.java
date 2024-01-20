package com.github.demchenkovv.collections.level03.lecture10.XmlSaxExample;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


/**
 * <a href="https://javarush.com/groups/posts/650-konkurs-osnovih-xml-dlja-java-programmista---chastjh-31-iz-3---sax">Основы XML для Java программиста – Часть 3.1 из 3 - SAX</a>
 */
public class SAXExample {
    private static List<Employee> employees = new ArrayList<>();
    private static boolean isFound; // task 3

    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
        // Создание фабрики и образца парсера
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser();

        // Экземпляр нашего обработчика
//        SimpleXMLHandler handler = new SimpleXMLHandler();          // task 1
//        AdvancedXMLHandler handler = new AdvancedXMLHandler();      // task 2
        SearchingXMLHandler handler = new SearchingXMLHandler("connection");    // task 3

//        File dataXmlFile = new File("src/main/java/com/github/demchenkovv/collections/level03/lecture10/XmlSaxExample/data1.xml"); // task 1
//        File dataXmlFile = new File("src/main/java/com/github/demchenkovv/collections/level03/lecture10/XmlSaxExample/data2.xml"); // task 2
        File dataXmlFile = new File("src/main/java/com/github/demchenkovv/collections/level03/lecture10/XmlSaxExample/data3.xml"); // task 3

        // В методе parse вы должны передать путь к xml файлу и обработчик
        parser.parse(dataXmlFile, handler);

        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }

//    /* Task 1. Простой хорошо структурированный xml файл */
//    private static class SimpleXMLHandler extends DefaultHandler {
//        @Override
//        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
//            if (qName.equals("employee")) {
//                String name = attributes.getValue("name");
//                String job = attributes.getValue("job");
//                employees.add(new Employee(name, job));
//            }
//        }
//    }


//    /* Task 2. Задача хорошо продемонстрирует, каким образом плохо структурированный XML файл может приводить к усложнению написания кода. */
//    private static class AdvancedXMLHandler extends DefaultHandler {
//        private String name;
//        private String job;
//        private String lastElementName;
//
//        @Override
//        public void startDocument() throws SAXException {
//            System.out.println("Starting to parse XML.");
//        }
//
//        @Override
//        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
//            lastElementName = qName;
//        }
//
//        @Override
//        public void characters(char[] ch, int start, int length) throws SAXException {
//            String currentElement = new String(ch, start, length);
//            currentElement = currentElement.replace("\n", "").trim();
//
//            if (!currentElement.isEmpty()) {
//                switch (lastElementName) {
//                    case "name": name = currentElement; break;
//                    case "job" : job = currentElement; break;
//                }
//            }
//        }
//
//        @Override
//        public void endElement(String uri, String localName, String qName) throws SAXException {
//            if ((name != null && !name.isEmpty()) && (job != null && !job.isEmpty()) ) {
//                employees.add(new Employee(name, job));
//                name = "";
//                job = "";
//            }
//        }
//
//        @Override
//        public void endDocument() throws SAXException {
//            System.out.println("XML parsing completed.");
//        }
//    }

    /* Task 3. Дан элемент element, вывести имена и атрибуты всех внутренних элементов, если элемент не найден — вывести это. */
    private static class SearchingXMLHandler extends DefaultHandler {
        private String element;
        private boolean isEntered;

        public SearchingXMLHandler(String element) {
            this.element = element;
        }

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            if (qName.equals(element)) {
                isEntered = true;
                isFound = true;
            }
            if (isEntered) {
                System.out.println(String.format("Найден элемент <%s>, его атрибуты:", qName));

                int length = attributes.getLength();
                for (int i = 0; i < length; i++) {
                    System.out.println(String.format("Имя атрибута: %s, его значение: %s", attributes.getQName(i), attributes.getValue(i)));
                }
            }
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            if (qName.equals(element)) isEntered = false;
        }
    }
}


//    // Методы обработчика и их описание
//    private static class XMLHandler extends DefaultHandler {
//        @Override
//        public void startDocument() throws SAXException {
//            // Тут будет логика реакции на начало документа
//        }
//
//        @Override
//        public void endDocument() throws SAXException {
//            // Тут будет логика реакции на конец документа
//        }
//
//        @Override
//        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
//            // Тут будет логика реакции на начало элемента
//            // uri — это пространство, в котором находится элемент
//            // localName — это имя элемента без префикса
//            // qName — это имя элемента с префиксом (если он есть, иначе просто имя элемента).
//            /* uri и localName всегда пустые, если мы не подключили в фабрике обработку пространств.
//            Это делается методом фабрики setNamespaceAware(true). Тогда мы сможем получать
//            пространство (uri) и элементы с префиксами перед ними (localName). */
//        }
//
//        @Override
//        public void endElement(String uri, String localName, String qName) throws SAXException {
//            // Тут будет логика реакции на конец элемента
//        }
//
//        @Override
//        public void characters(char[] ch, int start, int length) throws SAXException {
//            // Тут будет логика реакции на текст между элементами
//        }
//
//        @Override
//        public void ignorableWhitespace(char[] ch, int start, int length) throws SAXException {
//            // Тут будет логика реакции на пустое пространство внутри элементов (пробелы, переносы строчек и так далее).
//        }