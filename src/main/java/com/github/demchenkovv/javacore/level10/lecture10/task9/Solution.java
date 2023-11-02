package com.github.demchenkovv.javacore.level10.lecture10.task9;

import java.io.*;
import java.util.LinkedList;
import java.util.List;

/* 
Знакомство с графами
*/

/**
 * https://www.geeksforgeeks.org/object-graph-java-serialization/
 */

public class Solution implements Serializable {
    int node;
    List<Solution> edges = new LinkedList<>();

    @Override
    public String toString() {
        return "Solution{" +
               "node=" + node +
               ", edges=" + edges +
               '}';
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Solution s1 = new Solution();
        Solution s2 = new Solution();
        Solution s3 = new Solution();

        s1.node = 10;
        s2.node = 20;
        s3.node = 30;

        s1.edges.add(s2);
        s1.edges.add(s3);

        System.out.println(s1);

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(baos);
        oos.writeObject(s1);
        oos.close();

        ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
        ObjectInputStream ois = new ObjectInputStream(bais);
        Solution readSolution = (Solution) ois.readObject();
        ois.close();

        System.out.println(readSolution);
    }
}
