package com.github.demchenkovv.javacore.level09.lecture03.task4;

/*
И еще один адаптер
*/

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws IOException {
        PersonScannerAdapter adapter = new PersonScannerAdapter(new Scanner("D:\\input.txt"));
    }

    public static class PersonScannerAdapter implements PersonScanner {
        private final Scanner fileScanner;

        public PersonScannerAdapter(Scanner fileScanner) {
            this.fileScanner = fileScanner;
        }

        @Override
        public Person read() throws IOException {
            Person person;
            String[] splitted = this.fileScanner.nextLine().split(" ", 4);
            SimpleDateFormat format = new SimpleDateFormat("dd MM yyyy");
            Date birthDate;
            try {
                birthDate = format.parse(splitted[3]);
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }
            person = new Person(splitted[1], splitted[2], splitted[0], birthDate);
            return person;
        }

        @Override
        public void close() throws IOException {
            this.fileScanner.close();
        }
    }
}
