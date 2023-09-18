package com.github.demchenkovv.javasyntaxzero.level15.lecture01.ioFileInputStreamDemo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Пример программы, которая копирует очень большой файл. Его нельзя весь считать в память с помощью метода readAllBytes().
 * В этом примере мы использовали два класса: FileInputStream — наследник InputStream для чтения данных из файла,
 * и класс FileOutputStream — наследник OutputStream для записи данных в файл. О втором классе расскажем немного позднее.
 * Еще один интересный момент — это переменная real. Когда из файла будет читаться последний блок данных, легко может оказаться,
 * что его длина меньше 64Кб. Поэтому в output нужно тоже записать не весь буфер, а только его часть: первые real байт.
 * Именно это и делается в методе write().
 */
public class FileCopy {
    public static void main(String[] args) {
        String src = "c:\\projects\\log.txt";
        String dest = "c:\\projects\\copy.txt";

        try (FileInputStream input = new FileInputStream(src);
             FileOutputStream output = new FileOutputStream(dest)) {
            byte[] buffer = new byte[65536]; // 64Kb
            while (input.available() > 0) {
                int real = input.read(buffer);
                output.write(buffer, 0, real);
            }
        } catch (FileNotFoundException ex) {
            System.out.println("FileCopy#main() / FileNotFoundException: Файл не найден.");
        } catch (IOException ex) {
            System.out.println("FileCopy#main() / IOException: Неверный формат данных");
        }
    }
}

/*
int read() - Читает один байт из потока
int read(byte[] buffer) - Читает массив байт из потока
byte[] readAllBytes() - Читает все байты из потока
long skip(long n) - Пропускает n байт в потоке (читает и выкидывает)
int available() - Проверяет, сколько байт еще осталось в потоке
void close() - Закрывает поток
 */