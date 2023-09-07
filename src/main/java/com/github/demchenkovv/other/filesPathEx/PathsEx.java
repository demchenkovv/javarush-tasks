package com.github.demchenkovv.other.filesPathEx;

import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Paths — это совсем простой класс с единственным статическим методом get().
 * Его создали исключительно для того, чтобы из переданной строки или URI получить объект типа Path.
 */
public class PathsEx {

    public static void main(String[] args) {

        Path testFilePath = Paths.get("C:\\Users\\Username\\Desktop\\testFile.txt");
    }
}