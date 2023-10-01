package com.github.demchenkovv.javacore.level06.lecture13.task2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MyThread5 extends Thread {

    @Override
    public void run() {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(isr);

        int sum = 0;
        String line;
        try {
            while (!(line = reader.readLine()).equals("N")) {
                sum += Integer.parseInt(line);
            }
            reader.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        System.out.println(sum);
    }
}
