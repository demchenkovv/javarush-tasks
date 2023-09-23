package com.github.demchenkovv.javacore.level03.lecture11.task11;

import java.io.*;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/*
Сортировка четных чисел из файла
*/

public class Solution {
    public static void main(String[] args) {

//        String testFile =
//                Path.of("src/main/java/com/github/demchenkovv/javacore/level03/lecture11/task11/test.txt")
//                        .normalize().toAbsolutePath().toString();

        try (Scanner scanner = new Scanner(System.in);
             FileInputStream fis = new FileInputStream(scanner.nextLine());
//             FileInputStream fis = new FileInputStream(testFile);
             InputStreamReader isr = new InputStreamReader(fis);
             BufferedReader bufferedReader = new BufferedReader(isr)) {

            bufferedReader.lines()
                    .map(Integer::parseInt)
                    .filter(x -> x % 2 == 0)
                    .sorted()
                    .forEach(System.out::println);

        } catch (Exception ex){
            ex.printStackTrace();
        }
    }
}
// Альтернативное решение
//public class Solution {
//    public static void main(String[] args) throws Exception {
//        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//        String sourceFileName = reader.readLine();
//        Scanner scanner = new Scanner(new FileInputStream(sourceFileName));
//
//        List<Integer> data = new ArrayList<>();
//        while (scanner.hasNext()) {
//            int value = scanner.nextInt();
//            if (value % 2 == 0) data.add(value);
//        }
//
//        Collections.sort(data);
//        for (Integer value : data) {
//            System.out.println(value);
//        }
//
//        scanner.close();
//    }
//}


/*
Сортировка четных чисел из файла
В этой задаче тебе нужно:
Ввести имя файла с консоли.
Прочитать из него набор чисел.
Вывести в консоли только четные, отсортированные по возрастанию.

Пример ввода:
5
8
-2
11
3
-5
2
10

Пример вывода:
-2
2
8
10


Requirements:
1. Программа должна считывать данные с консоли.
2. Программа должна создавать FileInputStream для введенной с консоли строки.
3. Программа должна выводить данные на экран.
4. Программа должна вывести на экран все четные числа, считанные из файла, отсортированные по возрастанию.
5. Программа должна закрывать поток чтения из файла — FileInputStream.
 */