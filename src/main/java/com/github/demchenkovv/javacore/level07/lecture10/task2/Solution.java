package com.github.demchenkovv.javacore.level07.lecture10.task2;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/*
CRUD 2
*/

public class Solution {
    public static volatile List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static SimpleDateFormat inputDateFormat = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH); // 23/02/2000
    public static SimpleDateFormat outputDateFormat = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH); // 23-Feb-2000

    public static void main(String[] args) throws ParseException {
        if (args.length == 0) {
            throw new RuntimeException("String[] args == 0. Работа без параметров невозможна.");
        }

        Person person;
        Date birthDate;
        switch (args[0]) {
            case "-c":
                synchronized (allPeople) {
                    for (int i = 1; i < args.length; i += 3) {
                        birthDate = inputDateFormat.parse(args[i + 2]);
                        if (args[i + 1].equals("м")) {
                            person = Person.createMale(args[i], birthDate);
                        } else
                            person = Person.createFemale(args[i], birthDate);
                        allPeople.add(person);
                        System.out.println(allPeople.indexOf(person));
                    }
                }
                break;
            case "-u":
                synchronized (allPeople) {
                    for (int i = 1; i < args.length; i += 4) {
                        birthDate = inputDateFormat.parse(args[i + 3]);
                        person = allPeople.get(Integer.parseInt(args[i]));
                        person.setName(args[i + 1]);
                        person.setSex(args[i + 2].equals("м") ? Sex.MALE : Sex.FEMALE);
                        person.setBirthDate(birthDate);
                    }
                }
                break;
            case "-d":
                synchronized (allPeople) {
                    for (int i = 1; i < args.length; i++) {
                        person = allPeople.get(Integer.parseInt(args[i]));
                        person.setName(null);
                        person.setSex(null);
                        person.setBirthDate(null);
                    }
                }
                break;
            case "-i":
                synchronized (allPeople) {
                    for (int i = 1; i < args.length; i++) {
                        person = allPeople.get(Integer.parseInt(args[i]));
                        System.out.printf("%s %s %s\n", person.getName(), person.getSex() == Sex.MALE ? "м" : "ж",
                                outputDateFormat.format(person.getBirthDate()));
                    }
                }
                break;
            default:
                synchronized (allPeople) {
                    System.out.println("Введен неверный параметр");
                }
                break;
        }
    }
}