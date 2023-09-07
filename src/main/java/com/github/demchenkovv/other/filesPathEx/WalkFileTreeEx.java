package com.github.demchenkovv.other.filesPathEx;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.List;

/**
 * Рассмотрим проход по дереву файлов.
 * <p> Файловая структура в современных операционных системах чаще всего имеет вид дерева:
 * у него есть корень и есть ветки, от которых могут отделяться другие ветки и т.д.
 * <p> Теперь представь, что у нас есть задача: зная корневой каталог, мы должны пройтись
 * по нему, заглянуть в папки всех уровней и найти в них файлы с нужным нам содержимым.
 * <br> Мы будем искать файлы, содержащие строку «This is the file we need!»
 * <p> Нашим корневым каталогом будет папка «testFolder», которая лежит в папке с проектом.
 * <br> Внутри testFolder лежат папки level1, level2 и файл FileWeNeed1.txt;
 * <br> Внутри level1 лежит папка level1-1, а там файл FileWeNeed2.txt;
 * <br> Внутри level2 лежит папка level2-1, внутри еще папка level2-1-1, внутри файл FileWeNeed3.txt.
 * <p> 3 файла с нужным нам содержимым мы специально обозначим понятными названиями —
 * FileWeNeed1.txt, FileWeNeed2.txt, FileWeNeed3.txt. Именно их нам и нужно найти по-содержимому с помощью Java.
 * <p> На помощь приходит очень мощный метод для обхода дерева файлов — Files.walkFileTree().
 *
 * <p> FileVisitor — это специальный интерфейс, в котором описаны все методы для обхода дерева файлов.
 * В частности, мы поместим туда логику считывания содержимого файла и проверки, содержит ли он нужный нам текст.
 *
 * <p> Если тебе нужна более сложная логика обхода, стоит написать свою реализацию FileVisitor. Там понадобится реализовать еще 3 метода:
 * <ul> preVisitDirectory() — логика, которую надо выполнять перед входом в папку;
 * <br> visitFileFailed() — что делать, если вход в файл невозможен (нет доступа, или другие причины);
 * <br> postVisitDirectory() — логика, которую надо выполнять после захода в папку.</ul>
 */


public class WalkFileTreeEx extends SimpleFileVisitor<Path> {

    public static void main(String[] args) throws IOException {
        Path path = Paths.get("src/main/java/com/github/demchenkovv/other/filesPathEx/testFolder");
        Files.walkFileTree(path, new WalkFileTreeEx());
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        List<String> lines = Files.readAllLines(file);
        for (String s : lines) {
            if (s.contains("This is the file we need!")) {
                System.out.println("Нужный файл обнаружен!");
                System.out.println(file.toAbsolutePath());
                break;
            }
        }

        // Здесь мы просто описываем что должна делать программа после того, как выполнен вход в файл, и все необходимые операции совершены.
        // В нашем случае необходимо продолжать обход дерева, поэтому мы выбираем вариант CONTINUE.
        return FileVisitResult.CONTINUE;

        // Но у нас, например, могла быть и другая задача: найти не все файлы, которые содержат «This is the file we need»,
        // а только один такой файл. После этого работу программы нужно завершить. В этом случае наш код выглядел бы точно так же, но вместо break; было бы:
        // return FileVisitResult.TERMINATE;
    }
}
