package com.github.demchenkovv.javacore.level03.lecture11.task3;

import java.io.*;
import java.nio.file.Path;
import java.util.Scanner;

/*
Чтение файла
*/

/**
 * <a href=https://stackoverflow.com/questions/38343729/why-does-read-read-one-byte-at-a-time-if-char-is-2-bytes>Why does read() read one byte at a time if char is 2 bytes?</a>
 */

// Решение через потоки байтов
public class Solution {
    public static void main(String[] args) throws Exception {

        Path path = Path.of("src/main/java/com/github/demchenkovv/javacore/level03/lecture11/task3/text.txt")
                .normalize()
                .toAbsolutePath();

        try (Scanner scanner = new Scanner(System.in);
//             FileInputStream inputStream = new FileInputStream(scanner.nextLine());
             FileInputStream inputStream = new FileInputStream(path.toString());
             OutputStream outputStream = new BufferedOutputStream(System.out)) {

            int length = inputStream.available(); // кол-во возможных прочитанных байт (инфо для дебагера)
            byte[] buffer = new byte[10];       // буфер из 10 байтов
            int r = inputStream.read(buffer);   // Считывает данные длиной до b байт из этого входного потока в массив байт. Этот метод блокируется до тех пор, пока не будут доступны какие-либо входные данные. -1 означает, что информации больше нет.
            while (r != -1) {                   // если  inputStream.read() вернет -1, значит больше читать нечего
                outputStream.write(buffer, 0, r); // buffer – данные. off – начальное смещение в данных. len – количество байт для записи.
                r = inputStream.read(buffer);


//            while (bufferedReader.ready()) { // Сообщает, готов ли этот поток к чтению. Буферизованный символьный поток готов, если буфер не пуст или если готов базовый символьный поток.
//                String s = bufferedReader.readLine(); // Считывает строку текста.
//                System.out.println(s);

            }
        }
    }
}

/*
Решение с JavaRush

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String sourceFileName = reader.readLine();
        FileInputStream fileInputStream = new FileInputStream(sourceFileName);

        Scanner scanner = new Scanner(fileInputStream);
        StringBuilder builder = new StringBuilder();

        while (scanner.hasNextLine()) {
            builder.append(scanner.nextLine()).append("\n");
        }

        System.out.print(builder.toString());

        scanner.close();
        reader.close();
    }
}
 */

/*
Альтернативное (подробное) решение.

public class Solution {
    public static void main(String[] args) throws IOException {

        Scanner scanner = null;
        FileInputStream inputStream = null;
        BufferedReader bufferedReader = null;
        try {
            scanner = new Scanner(System.in);
            inputStream = new FileInputStream(scanner.nextLine());
            bufferedReader = new BufferedReader(new InputStreamReader(inputStream));


            while (bufferedReader.ready()) { // Сообщает, готов ли этот поток к чтению. Буферизованный символьный поток готов, если буфер не пуст или если готов базовый символьный поток.
                String s = bufferedReader.readLine(); // Считывает строку текста.
                System.out.println(s);
            }
        } finally {
            scanner.close();
            inputStream.close();
            bufferedReader.close();
        }
    }
}
 */

/*
Чтение файла
В этой задаче тебе нужно:
Считать с консоли путь к файлу.
Вывести в консоли (на экран) содержимое файла.
Освободить ресурсы. Закрыть поток чтения с файла и поток ввода с клавиатуры.

Requirements:
1. Программа должна считывать c консоли путь к файлу.
2. Программа должна выводить на экран содержимое файла.
3. Поток чтения из файла (FileInputStream) должен быть закрыт.
4. BufferedReader также должен быть закрыт.
 */