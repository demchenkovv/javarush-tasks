package com.github.demchenkovv.javacore.level03.lecture11.InputOutputDemo;

public enum FilePaths {

    INPUT_BYTE("src/main/java/com/github/demchenkovv/javacore/level03/lecture11/InputOutputDemo/input_byte.txt"),
    INPUT_CHAR("src/main/java/com/github/demchenkovv/javacore/level03/lecture11/InputOutputDemo/input_char.txt"),
    OUTPUT_DATA("src/main/java/com/github/demchenkovv/javacore/level03/lecture11/InputOutputDemo/output_data.txt");

    public final String path;

    FilePaths(String path) {
        this.path = path;
    }
}
