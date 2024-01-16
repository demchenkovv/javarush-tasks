package com.github.demchenkovv.collections.level03.lecture05.task3304;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.StringWriter;

/* 
Конвертация из одного класса в другой используя JSON Ӏ 3304
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        Second s = (Second) convertOneToAnother(new First(), Second.class);
        First f = (First) convertOneToAnother(new Second(), First.class);
    }

    public static Object convertOneToAnother(Object one, Class resultClassObject) throws IOException {
        String srcClass = one.getClass().getSimpleName().toLowerCase();
        String destClass = resultClassObject.getSimpleName().toLowerCase();
        ObjectMapper mapper = new ObjectMapper();
        StringWriter writer = new StringWriter();
        mapper.writeValue(writer, one);
        String resultStr = writer.toString().replaceFirst(srcClass, destClass);
        return mapper.readValue(resultStr, resultClassObject);

//        // Простая конвертация, как в примере ниже, работать не будет,
//        // поскольку классы не имеют общий суперкласс. Без объявления
//        // общего суперкласса аннотация JsonTypeInfo не будет корректно
//        // работать, потому что для ее использования требуется
//        // указать базовый класс, который будет содержать информацию о
//        // типе объекта. Аннотация JsonTypeInfo используется в Jackson
//        // для сериализации и десериализации полиморфных объектов.
//        ObjectMapper mapper = new ObjectMapper();
//        String jsonString = mapper.writeValueAsString(one);
//        return mapper.readValue(jsonString, resultClassObject);
    }

    @JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "className")
    @JsonSubTypes(@JsonSubTypes.Type(value = First.class, name = "first"))
    public static class First {
        public int i = 5;
        public String name = "first";
    }

    @JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "className")
    @JsonSubTypes(@JsonSubTypes.Type(value = Second.class, name = "second"))
    public static class Second {
        public int i = 10;
        public String name = "second";
    }
}
