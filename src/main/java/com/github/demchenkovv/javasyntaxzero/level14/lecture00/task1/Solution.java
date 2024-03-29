package com.github.demchenkovv.javasyntaxzero.level14.lecture00.task1;

/*
Поработай обработчиком
*/

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {

    public static final String INPUT_NAME = "\nВведите имя: ";
    public static final String INPUT_AGE = "Введите возраст пользователя '%s': ";

    public static final String CANNOT_BE_NULL = "Имя не может быть null.";
    public static final String CANNOT_BE_EMPTY = "Имя не может быть пустым.";
    public static final String CANNOT_CONTAIN_DIGIT = "Имя не может содержать цифры.";
    public static final String CANNOT_BE_NEGATIVE = "Возраст не может быть меньше 0.";
    public static final String CANNOT_BE_TOO_BIG = "Возраст не может быть больше 150.";
    public static final String UNKNOWN_ERROR = "Неизвестная ошибка.";

    public static final String FOUND = "\nПользователь '%s' найден под индексом %d.\n";
    public static final String NOT_FOUND = "\nПользователь '%s' не найден.\n";

    static List<User> users = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            addUser(new User());
        }

        User userToSearch = new User();
        userToSearch.setName("Рафаэль");

        findUserIndex(userToSearch);
    }

    static void addUser(User user) {
        System.out.print(INPUT_NAME);
        String name = scanner.nextLine();

        System.out.printf(INPUT_AGE, name);
        int age = Integer.parseInt(scanner.nextLine());

        //напишите тут ваш код
        int statusSetName = user.setName(name);
        if (statusSetName != 0) {
            if (statusSetName == -1) {
                System.out.println(CANNOT_BE_NULL);
            } else if (statusSetName == -2) {
                System.out.println(CANNOT_BE_EMPTY);
            } else if (statusSetName == -3) {
                System.out.println(CANNOT_CONTAIN_DIGIT);
            } else {
                System.out.println(UNKNOWN_ERROR);
            }
        }

//        // Через switch case
//        switch (user.setName(name)) {
//            case 0 -> {
//            }
//            case -1 -> System.out.println(CANNOT_BE_NULL);
//            case -2 -> System.out.println(CANNOT_BE_EMPTY);
//            case -3 -> System.out.println(CANNOT_CONTAIN_DIGIT);
//            default -> System.out.println(UNKNOWN_ERROR);
//        }

        int statusSetAge = user.setAge(age);
        if (statusSetAge != 0) {
            if (statusSetAge == -1) {
                System.out.println(CANNOT_BE_NEGATIVE);
            } else if (statusSetAge == -2) {
                System.out.println(CANNOT_BE_TOO_BIG);
            } else {
                System.out.println(UNKNOWN_ERROR);
            }
        }

        users.add(user);
    }

    static void findUserIndex(User user) {
        //напишите тут ваш код
        if (users.indexOf(user) != -1) {
            System.out.printf(FOUND, user.getName(), users.indexOf(user));
        } else System.out.printf(NOT_FOUND, user.getName());
    }
}