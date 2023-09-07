package com.github.demchenkovv.other.filesPathEx;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import static java.nio.charset.StandardCharsets.UTF_8;

public class FilesEx2 {
    public static void main(String[] args) throws IOException {

        List<String> lines = Files.readAllLines(Paths.get("src/main/java/com/github/demchenkovv/other/filesPathEx/pushkin.txt"), UTF_8);

        for (String s : lines) {
            System.out.println(s);
        }
        System.out.println("\n");

        // Если стоит задача: найти в файле все строки, которые начинаются со слова «Как», привести их к UPPER CASE
        // и вывести в консоль, можно воспользоваться Stream API.
        List<String> result = lines.stream()
                .filter(line -> line.startsWith("Как"))
                .map(String::toUpperCase)
                .toList();

        result.forEach(System.out::println);
    }
}