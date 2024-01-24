package com.github.demchenkovv.collections.level03.lecture10.task3309;

/*
Комментарий внутри xml
*/

import org.w3c.dom.*;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static String toXmlWithComment(Object obj, String tagName, String comment) throws JAXBException {
        Marshaller marshaller = createMarshaller(obj.getClass());
        Document document = buildDocument();

        if (document == null || marshaller == null) {
            throw new NullPointerException("Возникли проблемы при создании marshaller или document.");
        }

        // Выполняем маршализацию Object в Document (Document наследуется от Node)
        marshaller.marshal(obj, document);

        // document.getDocumentElement() - позволяет получить прямой доступ к дочернему узлу, являющемуся элементом документа.
        // Т.о. получаем root элемент (first)
        Element root = document.getDocumentElement();

        // Получаем все элементы по имени тега
        NodeList nodes = document.getElementsByTagName(tagName);
        for (int i = 0; i < nodes.getLength(); i++) {
            Node node = nodes.item(i);

            // insertBefore(Node что вставляем, перед каким Node вставляем).
            // createComment создает Comment, наследуемый от Node.
            node.getParentNode().insertBefore(document.createComment(comment), node);
        }

        addCDATASection(document, root);

        // еще один метод для конвертации измененного документа DOM в строку
        String result = convertDOMtoXML(document);

        return result;
    }


    // Создание DOM документа
    private static Document buildDocument() {
        Document document = null;
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            document = builder.newDocument();
        } catch (ParserConfigurationException exception) {
            System.out.println("Error#buildDocument(): ошибка создания DOM документа - " + exception.toString());
            return null;
        }
        return document;
    }

    // Создание маршализатора
    private static Marshaller createMarshaller(Class clazz) {
        Marshaller marshaller;
        try {
            JAXBContext context = JAXBContext.newInstance(clazz);
            marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE); // для красивого вывода
        } catch (JAXBException exception) {
            System.out.println("Error#createMarshaller(): ошибка создания Marshaller - " + exception.toString());
            return null;
        }
        return marshaller;
    }

    private static void addCDATASection(Document document, Node node) {
//        Node child;
//        while ((child = node.getFirstChild()) != null) {
        for (Node child = node.getFirstChild(); child != null; ) {

            // Возвращает узел, который следует за этим узлом, иначе null.
            Node nextNode = child.getNextSibling();

            // Значение этого узла зависит от его типа; смотрите таблицу в док-ции. Если для него определено значение null,
            // его установка не имеет никакого эффекта, в том числе, если узел доступен только для чтения.
            if (child.getNodeValue() == null) {

                // getTextContent - возвращаемая строка состоит из текстового содержимого этого узла в зависимости
                // от его типа (см. документацию)
                if (hasCData(child.getTextContent())) {
                    String stringToConvert = child.getTextContent();
                    CDATASection cdataSection = document.createCDATASection(stringToConvert);
                    child.setTextContent("");
                    child.appendChild(cdataSection);
                }
            }
            if (child.hasChildNodes()) {
                addCDATASection(document, child);
            }
            child = nextNode;
        }
    }

    /*
    Вспомогательный метод для проверки наличия запрещенных (специальных) символов:
    "   &quot;
    '   &apos;
    <   &lt;
    >   &gt;
    &   &amp;
    */
    private static boolean hasCData(String textContent) {
        Pattern patter = Pattern.compile("[<>&'\"]");
        Matcher matcher = patter.matcher(textContent);
        return matcher.find();
    }

    // Классы из библиотеки javax.xml.transform служат для преобразования
    // XML-данных из одного представления в другое. Классы:
    // TransformerFactory, Transformer, StreamResult, DOMSource
    private static String convertDOMtoXML(Document documentDom) {

        // отвечает за создание новых Transformer объектов, которые используются
        // для выполнения преобразований XML документов.
        TransformerFactory transformerFactory = TransformerFactory.newInstance();

        // используется для выполнения различных операций над XML документами, таких
        // как создание новых документов, изменение существующих, а также преобразование
        // из одного формата в другой.
        Transformer transformer = null;
        try {
            transformer = transformerFactory.newTransformer();

            // Свойство (INDENT, yes/no) отвечает за отступы
            // и выравнивание вывода информации для улучшения читаемости.
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        } catch (TransformerConfigurationException transConfEx) {
            transConfEx.printStackTrace();
        }

        if (transformer == null) {
            System.out.println("Transformer is null");
            return null;
        }

        StringWriter writer = new StringWriter();

        // используется для получения результатов преобразования в виде потока данных,
        // который может быть записан в файл или отправлен на вывод.
        StreamResult result = new StreamResult(writer);

        // позволяет работать с XML документами в виде дерева узлов, что может быть полезно
        // при ручном изменении структуры документа или при создании сложных преобразований.
        DOMSource domSource = new DOMSource(documentDom);
        try {
            transformer.transform(domSource, result);
        } catch (TransformerException ex) {
            System.out.println("Ошибка преобразования источника XML в результат: transform(Source xmlSource, Result outputTarget).");
        }
        return writer.toString();
    }

    // Проверочный класс
    @XmlRootElement
    @XmlType(name = "first")
    public static class First {


        @XmlElement(name = "second")
        private List<String> seconds = new ArrayList<>();

        {
            seconds.add("some string1");
            seconds.add("some string2");
            seconds.add("some string3");
            seconds.add("a test containing the greater-than '>' and appersand '&' sign");
            seconds.add("<![CDATA[need CDATA because of < and >]]>");
        }

        public List<String> getSeconds() {
            return seconds;
        }

        @Override
        public String toString() {
            return "First{" +
                   "seconds=" + seconds +
                   '}';
        }
    }

    public static void main(String[] args) throws JAXBException {
        First first = new First();
        System.out.println(toXmlWithComment(first, "second", "it's a comment"));
    }
}
