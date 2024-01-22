package com.github.demchenkovv.collections.level03.lecture10.XmlDomExample1;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

/*
 Материал по DOM: https://javarush.com/groups/posts/656-konkurs-osnovih-xml-dlja-java-programmista---chastjh-31-iz-3---dom
- Task 1: нам нужно достать информацию о всех сотрудниках и вывести её в консоль из XML файла data1.xml;
- Task 2: вводится с консоли имя элемента, про который нужно вывести информацию обо всех элементах внутри его и
их атрибутах с XML файла data3.xml;
- Task 3: из XML файла data4.xml, где сохранена информация про студентов, профессоров и сотрудников, нужно считать
информацию и вывести её в консоль.
 */

public class Main {
    private final static String TASK_1 = "src/main/java/com/github/demchenkovv/collections/level03/lecture10/XmlDomExample1/data/data1.xml";
    private final static String TASK_2 = "src/main/java/com/github/demchenkovv/collections/level03/lecture10/XmlDomExample1/data/data3.xml";
    private final static String TASK_3 = "src/main/java/com/github/demchenkovv/collections/level03/lecture10/XmlDomExample1/data/data4.xml";

    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException {
        Parser parser1 = new Parser(TASK_1);
        parser1.parseAndPrintEmployees();
        System.out.println("----------------\n");

        Parser parser2 = new Parser(TASK_2);
        parser2.printElementsAndAttributes();
        System.out.println("----------------\n");

//
//        Parser parser3 = new Parser(TASK_3);
//        parser3.printInfoStudentsProfessorsStaff();
    }
}
