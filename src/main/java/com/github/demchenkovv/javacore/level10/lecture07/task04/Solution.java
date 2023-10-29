package com.github.demchenkovv.javacore.level10.lecture07.task04;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

/* 
Serializable Solution
*/

public class Solution implements Serializable {

    private transient final String pattern = "dd MMMM yyyy, EEEE";
    private transient Date currentDate;
    private transient int temperature;
    String string;

    public Solution(int temperature) {
        this.currentDate = new Date();
        this.temperature = temperature;

        string = "Today is %s, and the current temperature is %s C";
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        this.string = String.format(string, format.format(currentDate), temperature);
    }

    @Override
    public String toString() {
        return this.string;
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
//        System.out.println(new Solution(4));

        Solution savedObject = new Solution(25);
        File temp = File.createTempFile("task2014", ".tmp");
        try (OutputStream os = new FileOutputStream(temp);
             ObjectOutputStream oos = new ObjectOutputStream(os)) {
            oos.writeObject(savedObject);
        }
        System.out.println(savedObject.toString());

        Solution loadedObject = new Solution(10);
        try (InputStream is = new FileInputStream(temp);
             ObjectInputStream ois = new ObjectInputStream(is)) {
            loadedObject = (Solution) ois.readObject();
        }

        System.out.println(loadedObject.toString());
    }
}
