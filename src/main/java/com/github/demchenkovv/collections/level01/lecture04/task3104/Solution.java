package com.github.demchenkovv.collections.level01.lecture04.task3104;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;

/* 
Поиск скрытых файлов
*/

// Класс Solution наследуется от класса SimpleFileVisitor типизированный Path.
// SimpleFileVisitor является реализацией интерфейса FileVisitor.
public class Solution extends SimpleFileVisitor<Path> {

    // main method is not involved in testing
    public static void main(String[] args) throws IOException {

        // FileVisitOption — enum множество, определяющее, стоит ли программе при обходе
        // следовать по символьным ссылкам (в этом случае указывается значение FileVisitOption.FOLLOW_LINKS).
        EnumSet<FileVisitOption> options = EnumSet.of(FileVisitOption.FOLLOW_LINKS);
        final Solution solution = new Solution();

        Path dir = Paths.get("src/main/java/com/github/demchenkovv/collections/level01/lecture04/task3104/test").toAbsolutePath();
        Files.walkFileTree(dir, options, 20, solution);

        Path dir2 = Paths.get("C:\\some\\incorrect\\path").toAbsolutePath();
        Files.walkFileTree(dir2, options, 20, solution);

        List<String> result = solution.getArchived();
        System.out.println("All archived files:");
        for (String path : result) {
            System.out.println("\t" + path);
        }

        List<String> failed = solution.getFailed();
        System.out.println("All failed files:");
        for (String path : failed) {
            System.out.println("\t" + path);
        }
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        String fileName = file.getFileName().toString();
        if (fileName.endsWith(".zip") || fileName.endsWith(".rar")) {
            archived.add(file.toString());
        }
        return super.visitFile(file, attrs);
    }

    @Override
    public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
        failed.add(file.toString());
        return FileVisitResult.SKIP_SUBTREE;
    }


    private List<String> archived = new ArrayList<>();

    public List<String> getArchived() {
        return archived;
    }

    private List<String> failed = new ArrayList<>();

    public List<String> getFailed() {
        return failed;
    }
}
