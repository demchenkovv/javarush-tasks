package com.github.demchenkovv.javacore.level09.lecture03.task4;

import java.io.IOException;

public interface PersonScanner {
    Person read() throws IOException;

    void close() throws IOException;
}
