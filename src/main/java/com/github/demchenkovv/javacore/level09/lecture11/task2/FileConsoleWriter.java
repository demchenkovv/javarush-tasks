package com.github.demchenkovv.javacore.level09.lecture11.task2;

import java.io.File;
import java.io.FileDescriptor;
import java.io.FileWriter;
import java.io.IOException;

public class FileConsoleWriter {
    private FileWriter fileWriter;

    public FileConsoleWriter(File file) throws IOException {
        this.fileWriter = new FileWriter(file);
    }

    public FileConsoleWriter(File file, boolean append) throws IOException {
        this.fileWriter = new FileWriter(file, append);
    }

    public FileConsoleWriter(FileDescriptor fd) throws IOException {
        this.fileWriter = new FileWriter(fd);
    }

    public FileConsoleWriter(String fileName) throws IOException {
        this.fileWriter = new FileWriter(fileName);
    }

    public FileConsoleWriter(String fileName, boolean append) throws IOException {
        this.fileWriter = new FileWriter(fileName, append);
    }

    public void write(char[] cbuf, int off, int len) throws IOException {
        String s = new String(cbuf).substring(off, off + len);
//        String s2 = new String(cbuf, off, len);
        System.out.println(s);
        fileWriter.write(cbuf, off, len);
    }

    public void write(int c) throws IOException {
        System.out.printf("%c", c);
        fileWriter.write(c);
    }

    public void write(String str) throws IOException {
        System.out.printf("%s", str);
        fileWriter.write(str);
    }

    public void write(String str, int off, int len) throws IOException {
        System.out.printf("%s", str.substring(off, off + len));
        fileWriter.write(str, off, len);
    }

    public void write(char[] cbuf) throws IOException {
        for (char c : cbuf) {
            System.out.printf("%c", c);
        }
        fileWriter.write(cbuf);
    }

    public void close() throws IOException {
        fileWriter.close();
    }

    public static void main(String[] args) throws IOException {

    }
}