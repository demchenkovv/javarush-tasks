package com.github.demchenkovv.javasyntaxzero.other.tryCatchDemo;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Блоков catch может быть несколько.
 * Если код в блоке try может выбросить не один, а несколько видов исключений, для каждого из них можно написать свой блок catch.
 * В этом примере мы написали два блока catch. Если в блоке try произойдет FileNotFoundException, будет выполнен первый блок catch.
 * Если произойдет ArithmeticException, выполнится второй.
 * Блоков catch ты можешь написать хоть 50. Но, конечно, лучше не писать код, который может выбросить 50 разных видов ошибок :)
 * Блок finally — выполнит обязательную часть кода; ту часть, которая должна быть выполнена независимо от обстоятельств.
 * Например, в нем часто освобождают какие-то используемые программой ресурсы.
 */
public class Example2 {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = null;

        try {
            reader = new BufferedReader(new FileReader("C:\\Users\\Username\\Desktop\\test.txt"));
            System.out.println(366 / 0);
            String firstString = reader.readLine();
            System.out.println(firstString);
        } catch (FileNotFoundException e) {
            System.out.println("Ошибка! Файл не найден!");

        } catch (ArithmeticException e) {
            System.out.println("Ошибка! Деление на 0!");
        } finally {
            System.out.println("А вот и блок finally!");
            if (reader != null) {
                reader.close();
            }
        }
    }
}
