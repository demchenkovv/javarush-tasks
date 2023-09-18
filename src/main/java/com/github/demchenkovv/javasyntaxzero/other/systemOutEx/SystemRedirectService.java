package com.github.demchenkovv.javasyntaxzero.other.systemOutEx;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;

/**
 * Например, мы хотим считывать данные из консоли, и записывать их в текстовый файл.
 * Можно ли как-то реализовать такую логику, не используя дополнительные классы ридеров и райтеров,
 * а просто пользуясь System.out?
 * <p>
 * Можно! (<a href="https://javarush.com/groups/posts/2140-praktika-rabotih-s-klassami-buffreredreader-i-inputstreamreader">Подмена System.out</a>)
 */
public class SystemRedirectService {

    public static void main(String arr[]) throws FileNotFoundException {
        PrintStream filePrintStream = new PrintStream(new File("C:\\Users\\Username\\Desktop\\test.txt"));

       /*Сохраним текущее значение System.out в отдельную переменную, чтобы потом
       можно было переключиться обратно на вывод в консоль*/
        PrintStream console = System.out;

        // Присваиваем System.out новое значение
        System.setOut(filePrintStream);
        System.out.println("Эта строка будет записана в текстовый файл");

        // Возвращаем System.out старое значение
        System.setOut(console);
        System.out.println("А эта строка - в консоль!");
    }
}
