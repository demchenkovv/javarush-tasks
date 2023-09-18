package com.github.demchenkovv.javasyntaxzero.level18.lecture01.methodReferencesExample;

public class MethodReferencesExample {
    //конструктор класса
    public MethodReferencesExample() {
        System.out.println("Создан объект класса MethodReferencesExample");
    }

    //статический метод
    public static void staticMethod() {
        System.out.println("Вызван статический метод класса MethodReferencesExample");
    }

    //обычный метод
    public void instanceMethod() {
        System.out.println("Вызван метод объекта");
    }

    public static void main(String[] args) {

        //вызов статического метода класса
        MethodReferencesExample.staticMethod();
        //создание объекта
        MethodReferencesExample classObject = new MethodReferencesExample();
        //вызов метода объекта
        classObject.instanceMethod();

        System.out.println("");

        //передача ссылки на статический метод класса
        FunctionalInterfaceExample interfaceObject1 = MethodReferencesExample::staticMethod;
        interfaceObject1.interfaceMethod();
        //передача ссылки на конструктор
        FunctionalInterfaceExample interfaceObject2 = MethodReferencesExample::new;
        interfaceObject2.interfaceMethod();
        //передача ссылки на метод объекта
        FunctionalInterfaceExample interfaceObject3 = classObject::instanceMethod;
        interfaceObject3.interfaceMethod();
    }
}
