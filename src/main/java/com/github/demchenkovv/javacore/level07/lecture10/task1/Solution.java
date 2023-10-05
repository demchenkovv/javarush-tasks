package com.github.demchenkovv.javacore.level07.lecture10.task1;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/*
CRUD
*/

public class Solution {
    public static List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static SimpleDateFormat inputDate = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH); // 23/02/2000
    public static SimpleDateFormat outputDate = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH); // 23-Feb-2000

    public static void main(String[] args) {
        if (args.length == 0) {
            throw new RuntimeException("String[] args == 0. Работа без параметров невозможна.");
        }

        switch (args[0]) {
            case "-c" -> argsCparam(args);
            case "-r" -> argsRparam(args);
            case "-u" -> argsUparam(args);
            case "-d" -> argsDparam(args);
            default -> System.out.println("Введен неверный параметр");
        }
    }


    private static void argsCparam(String[] args) {
        Person person;
        try {
            if (args[2].equals("м"))
                person = Person.createMale(args[1], inputDate.parse(args[3]));
            else
                person = Person.createFemale(args[1], inputDate.parse(args[3]));

            allPeople.add(person);
            System.out.println(allPeople.indexOf(person));
        } catch (ParseException ex) {
            ex.printStackTrace();
        }
    }

    private static void argsRparam(String[] args) {
        try {
            Person person = allPeople.get(Integer.parseInt(args[1]));
            System.out.printf("%s %s %s", person.getName(), person.getSex().getSexTitle(),
                    outputDate.format(person.getBirthDate()));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private static void argsUparam(String[] args) {
        try {
            Person updatePerson = allPeople.get(Integer.parseInt(args[1]));
            updatePerson.setName(args[2]);
            updatePerson.setSex(args[3].equals("м") ? Sex.MALE : Sex.FEMALE);
            updatePerson.setBirthDate(inputDate.parse(args[4]));
        } catch (ParseException ex) {
            ex.printStackTrace();
        }
    }

    private static boolean argsDparam(String[] args) {
        try {
            Person person = allPeople.get(Integer.parseInt(args[1]));
            person.setName(null);
            person.setSex(null);
            person.setBirthDate(null);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }
}