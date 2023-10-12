package com.github.demchenkovv.javacore.level08.lecture08.task2;

/*
Расширяем AmigoOutputStream
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class QuestionFileOutputStream implements AmigoOutputStream {
    private AmigoOutputStream amigoOutputStream;
    private BufferedReader bufferedReader;

    public QuestionFileOutputStream(AmigoOutputStream amigoOutputStream) {
        this.amigoOutputStream = amigoOutputStream;
    }

    @Override
    public void flush() throws IOException {
        amigoOutputStream.flush();
    }

    @Override
    public void write(int b) throws IOException {
        amigoOutputStream.write(0);
    }

    @Override
    public void write(byte[] b) throws IOException {
        amigoOutputStream.write(new byte[1]);
    }

    @Override
    public void write(byte[] b, int off, int len) throws IOException {
        amigoOutputStream.write(new byte[1], 0, 1);
    }

    @Override
    public void close() throws IOException {
        System.out.println("Вы действительно хотите закрыть поток? Д/Н");
        bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        if (bufferedReader.readLine().equals("Д")) {
            bufferedReader.close();
            amigoOutputStream.close();
        }
    }
}

