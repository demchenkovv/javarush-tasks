package com.github.demchenkovv.javacore.level09.lecture03.task2;

import java.io.IOException;

public interface AmigoStringWriter {
    void flush() throws IOException;

    void writeString(String s) throws IOException;

    void close() throws IOException;
}
