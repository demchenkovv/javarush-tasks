package com.github.demchenkovv.javacore.level10.lecture04.task04;

/*
Как сериализовать static?
*/


import java.io.*;

/**
 *  <a href=https://ru.hexlet.io/qna/java/questions/kak-serializovat-staticheskoe-pole-v-java>Как сериализовать статическое поле в Java</a>
 *  <p> Чтобы сериализовать статическое поле нам необходимо написать в сериализуемом классе свою реализацию
 *  методов writeObject и readObject. При этом надо вызвать стандартные методы defaultReadObject() и
 *  defaultWriteObject(), а затем добавить вручную сериализацию статических полей.
 */
public class Solution {
    public static class ClassWithStatic implements Serializable {
        public static String staticString = "This is a static test string";
        public int i;
        public int j;
    }


    public static void main(String[] args) throws IOException, ClassNotFoundException {
//        FileOutputStream fos = new FileOutputStream("src/main/java/com/github/demchenkovv/javacore/level10/lecture04/task04/data.txt");
//        ObjectOutputStream oos = new ObjectOutputStream(fos);
//        ClassWithStatic firstObject = new ClassWithStatic();
//        oos.writeObject(firstObject);
//        oos.close();
//        System.out.println(firstObject);
//
//        FileInputStream fis = new FileInputStream("src/main/java/com/github/demchenkovv/javacore/level10/lecture04/task04/data.txt");
//        ObjectInputStream ois = new ObjectInputStream(fis);
//        ClassWithStatic secondObject = (ClassWithStatic) ois.readObject();
//        ois.close();
//        System.out.println(secondObject);
    }

    private void writeObject(ObjectOutputStream out) throws IOException {
        out.defaultWriteObject();
        out.writeObject(ClassWithStatic.staticString);
    }

    private void readObject(ObjectInputStream in) throws ClassNotFoundException, IOException {
        in.defaultReadObject();
        ClassWithStatic.staticString = (String) in.readObject();
    }
}
