package com.github.demchenkovv.javacore.level03.lecture11.InputOutputDemo;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;

import static com.github.demchenkovv.javacore.level03.lecture11.InputOutputDemo.FilePaths.*;

public class InputOutputDemo {

    public static void main(String[] args) {

//        readAndWriteBytes(); // Считать байты из файла input_byte.txt и записать в файл output_data.txt
//        readAndWriteChars(); // Считать символы из файла input_char.txt и записать в файл output_data.txt
//        encodeBytesToChars(); // Считать поток байтов из файла input_char.txt, преобразовать в поток символов

    }

    /**
     * Считать поток байт (byte) из файла input_byte.txt и записать в файл output_data.txt
     */
    public static void readAndWriteBytes() {
        try (InputStream is = new FileInputStream(INPUT_BYTE.path);
             OutputStream os = new FileOutputStream(OUTPUT_DATA.path)) {
//             OutputStream os = new FileOutputStream(OUTPUT_DATA.path, true)) { // если true, то байты будут записаны в конец файла, а не в начало

            byte[] buffer = new byte[128]; // буфер, в который считываются данные
            int r = is.read(buffer); // читаем данные и записываем за один раз в буфер байт размером не более размера буфера
            while (r != -1) { // если r == -1, значит данные отсутствуют
                os.write(buffer, 0, r);
                r = is.read(buffer);
            }

            System.out.println("Writing to the file " + Path.of(OUTPUT_DATA.path).getFileName() + " is completed.");

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     * Считать поток символов (char) из файла input_char.txt и записать в файл output_data.txt
     */
    public static void readAndWriteChars() {
        try (Reader reader = new FileReader(INPUT_CHAR.path);
             Writer writer = new FileWriter(OUTPUT_DATA.path)) {
//             Writer writer = new FileWriter(OUTPUT_DATA.path, true)) { // если true, то символы будут записаны в конец файла, а не в начало

            char[] buffer = new char[4096];
            int c = reader.read(buffer);
            while (c != -1) {
                writer.write(buffer, 0, c);
                c = reader.read(buffer);
            }

            System.out.println("Writing to the file " + Path.of(OUTPUT_DATA.path).getFileName() + " is completed.");

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     * Считать из файла поток байтов и преобразовать их в поток символов
     */
    public static void encodeBytesToChars() {
        try (InputStream is = new FileInputStream(INPUT_BYTE.path); // читаем поток байтов
             Reader reader = new InputStreamReader(is, StandardCharsets.UTF_8); // байты преобразовываем в поток символов с заданной кодировкой
             BufferedReader bufferedReader = new BufferedReader(reader)) { // потоки символов преобразовываем в поток строк с помощью метода readLine()

            String str = bufferedReader.readLine(); // читаем построчно
            while (str != null) {
                System.out.println(str);
                str = bufferedReader.readLine();
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     * ByteArrayInputStream и ByteArrayOutputStream используется при работе с массивами байт.
     * <p>Они часто используются в случаях, когда необходимо выполнить чтение или запись данных в массив байт.
     * Например, они могут использоваться при сериализации объектов, работе с изображениями, передаче данных
     * через сеть, чтении и записи бинарных файлов, создании и разборе XML документов, а также при тестировании.
     */
    public static void byteArrayInputOutputStream() {
        try (ByteArrayInputStream arrayInputStream = new ByteArrayInputStream(new byte[10]);
             ByteArrayOutputStream arrayOutputStream = new ByteArrayOutputStream()) {

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
