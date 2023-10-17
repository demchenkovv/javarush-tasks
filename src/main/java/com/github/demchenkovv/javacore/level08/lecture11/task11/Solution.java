package com.github.demchenkovv.javacore.level08.lecture11.task11;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
Нити и байты
*/

public class Solution {
    public static Map<String, Integer> resultMap = new HashMap<String, Integer>();

    public static void main(String[] args) throws IOException {
        List<String> filePaths = new ArrayList<>();
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            String filePath;
            while (!(filePath = bufferedReader.readLine()).equals("exit")) {
                filePaths.add(filePath);
            }
        }

//        // Если объявить start() в конструкторе, то решение не принимает валидатор
//        filePaths.forEach(ReadThread::new);
        for (String s : filePaths) {
            new ReadThread(s).start();
        }
        resultMap.forEach((x, y) -> System.out.println(x + " : " + y));
    }

    public static class ReadThread extends Thread {
        private final String fileName;

        public ReadThread(String fileName) {
            this.fileName = fileName;
//            start();
        }

        @Override
        public void run() {
            try (BufferedInputStream fis = new BufferedInputStream(new FileInputStream(fileName))) {
                int[] bytesArray = new int[256];
                while (fis.available() > 0) {
                    bytesArray[fis.read()]++;
                }
                int maxValue = 0;
                for (int current : bytesArray) {
                    if (current > maxValue) {
                        maxValue = current;
                    }
                }
                // Просто для инфо: применение в этой задаче synchronized избыточно,
                // поскольку мы не меняем значения, а только добавляем их
//                synchronized (resultMap) {
                    for (int i = 0; i < bytesArray.length; i++) {
                        if (bytesArray[i] == maxValue) {
                            resultMap.put(fileName, i);
                            break;
                        }
                    }
//                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
