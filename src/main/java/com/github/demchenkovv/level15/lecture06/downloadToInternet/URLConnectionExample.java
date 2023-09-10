package com.github.demchenkovv.level15.lecture06.downloadToInternet;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * <p> Сначала мы устанавливаем стабильное двустороннее соединение с помощью метода URLConnection openConnection().
 * <br> Затем получаем поток для отправки данных с помощью метода connection.getOutputStream() и отправляем данные серверу.
 * <br> Затем получаем поток для чтения данных с помощью метода connection.getInputStream() и начинаем читать из него данные. </p>
 * <p>
 * <br> Строго говоря, мы должны все потоки обернуть в try-with-resources для безопасной работы.
 * <br> А еще не помешало бы обернуть голые InputStream и OutputStream во что-нибудь более удобное.
 * <br> Например, в PrintStream и BufferedReader.</p>
 */
public class URLConnectionExample {
    public static void main(String[] args)
            throws IOException {

        // Пример № 1
        String imageUrl = "https://www.google.com/images/branding/googlelogo/1x/googlelogo_color_272x92dp.png";
        URL url = new URL(imageUrl);
        try (InputStream input = url.openStream()) {
            Path path = Path.of("src/main/java/com/github/demchenkovv/level15/lecture06/downloadToInternet/GoogleLogo.png")
                    .toAbsolutePath()
                    .normalize();
            Files.copy(input, path);
        }

//        // Шаблон
//        URL url = new URL("https://javarush.com");  // Создаем объект URL с путем к странице
//        URLConnection connection = url.openConnection(); // Создаем двустороннее соединение
//
//        OutputStream output = connection.getOutputStream(); // Получаем поток вывода
//        output.write(1); // Выводим в него данные
//
//        InputStream input = connection.getInputStream(); // Получаем поток ввода
//        int data = input.read(); // Читаем из него данные


        // Пример № 2
//        URL url = new URL("https://javarush.com");
//        URLConnection connection = url.openConnection();
//
//        // отправляем данные
//        try (OutputStream output = connection.getOutputStream();
//             PrintStream sender = new PrintStream(output)) {
//            sender.println("Привет");
//        }
//
//        // читаем данные
//        try (InputStream input = connection.getInputStream();
//             BufferedReader reader = new BufferedReader(new InputStreamReader(input))) {
//            while (reader.ready())
//                System.out.println(reader.readLine());
//        }
    }
}
