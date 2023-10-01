package com.github.demchenkovv.javacore.level06.lecture10.task1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
Считаем секунды
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        InputStreamReader in = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(in);
        //create and run thread
        Stopwatch stopwatch = new Stopwatch();
        stopwatch.start();
        //read a string
        reader.readLine();
        stopwatch.interrupt();
        //close streams
        reader.close();
        in.close();
    }

    public static class Stopwatch extends Thread {
        private int seconds;

        public void run() {
            try {
                //напишите тут ваш код
                while (!Thread.currentThread().isInterrupted()) {
                    seconds += 1;
                    Thread.sleep(1000);
                }
            } catch (InterruptedException e) {
                System.out.println(seconds);
                currentThread().interrupt();
            }
        }
    }
}

/*
Считаем секунды
1. Напиши реализацию метода run в нити Stopwatch (секундомер).
2. Stopwatch должен посчитать количество секунд, которое прошло от создания нити до ввода строки.
3. Выведи количество секунд в консоль.


Requirements:
1. Метод run класса Stopwatch (секундомер) должен содержать цикл.
2. Метод run должен вызывать Thread.sleep(1000).
3. Метод run должен увеличивать значение поля seconds на 1 каждую секунду.
4. После прерывания работы нити Stopwatch (вызова метода interrupt), метод run должен вывести количество секунд (seconds) в консоль.
5. В классе Stopwatch должен быть только один метод run.
 */