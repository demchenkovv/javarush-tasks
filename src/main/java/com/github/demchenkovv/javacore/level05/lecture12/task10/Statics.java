package com.github.demchenkovv.javacore.level05.lecture12.task10;

import java.nio.file.Path;

public class Statics {
    public static String FILE_NAME =
            Path.of("src/main/java/com/github/demchenkovv/javacore/level05/lecture12/task10/data_file.txt")
                    .normalize().toAbsolutePath().toString();
}
