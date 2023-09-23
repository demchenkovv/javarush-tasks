package com.github.demchenkovv.javacore.level03.lecture11.task4;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.io.Writer;

/*
Писатель в файл с консоли
*/

public class Solution {
    public static void main(String[] args) {

//        String testPath =
//                Path.of("src/main/java/com/github/demchenkovv/javacore/level03/lecture11/task4/result.txt")
//                        .toAbsolutePath().toString();

        try (InputStreamReader inputStream = new InputStreamReader(System.in);
             BufferedReader bufferedReader = new BufferedReader(inputStream);
             Writer writer = new FileWriter(bufferedReader.readLine());
             BufferedWriter bufferedWriter = new BufferedWriter(writer)) {

            String str;
            do {
                str = bufferedReader.readLine();
                bufferedWriter.write(str + "\n");
            } while (!(str.equals("exit")));

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}


/*
Писатель в файл с консоли
В этой задаче тебе нужно:
1. Прочесть с консоли имя файла.
2. Считывать строки с консоли, пока пользователь не введет строку "exit".
3. Записать абсолютно все введенные в п.2 строки в файл: каждую строчку — с новой строки.

Requirements:
1. Программа должна считывать c консоли имя файла.
2. Создай и используй объект типа BufferedWriter.
3. Программа не должна ничего считывать из файловой системы.
4. Программа должна считывать строки с консоли, пока пользователь не введет строку "exit".
5. Программа должна записать все введенные строки (включая "exit", но не включая имя файла) в файл: каждую строчку — с новой строки.
6. Метод main должен закрывать объект типа BufferedWriter после использования.
7. Метод main не должен выводить данные на экран.
 */