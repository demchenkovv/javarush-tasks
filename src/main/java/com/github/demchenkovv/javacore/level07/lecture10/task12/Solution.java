package com.github.demchenkovv.javacore.level07.lecture10.task12;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Транзакционность
*/

public class Solution {
    public static List<String> allLines = new ArrayList<String>();
    public static List<String> forRemoveLines = new ArrayList<String>();

    public static void main(String[] args) {
        String firstPathToFile;
        String secondPathToFile;

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {

            // Можно так - в две строчки.
//            allLines = Files.readAllLines(Path.of(reader.readLine()));
//            forRemoveLines = Files.readAllLines(Path.of(reader.readLine()));


            // Ниже развернутое решение с импортами, которые идут к задаче
            firstPathToFile = reader.readLine();
            secondPathToFile = reader.readLine();

            reader.close(); // названия файлов считали - поток закрыли

            String resultReadLine;

            BufferedReader fReaderFirst = new BufferedReader(new FileReader(firstPathToFile));
            while ((resultReadLine = fReaderFirst.readLine()) != null) {
                allLines.add(resultReadLine);
            }
            fReaderFirst.close(); // данные из файла1 считали - поток закрыли

            BufferedReader fReaderSecond = new BufferedReader(new FileReader(secondPathToFile));
            while ((resultReadLine = fReaderSecond.readLine()) != null) {
                forRemoveLines.add(resultReadLine);
            }
            fReaderSecond.close(); // данные из файла2 считали - поток закрыли

            new Solution().joinData();

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void joinData() throws CorruptedDataException {
        if (allLines.containsAll(forRemoveLines))
            allLines.removeAll(forRemoveLines);
        else {
            allLines.clear();
            throw new CorruptedDataException();
        }
    }
}
