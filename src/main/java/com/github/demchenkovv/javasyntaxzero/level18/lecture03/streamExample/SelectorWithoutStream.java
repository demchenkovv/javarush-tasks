package com.github.demchenkovv.javasyntaxzero.level18.lecture03.streamExample;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Код в методе main, не использующий стримы для решения этой задачи.
 */

public class SelectorWithoutStream {
    private static List<Owner> owners;

    public static void main(String[] args) {
        initData();

        List<String> findNames = new ArrayList<>();
        List<Cat> findCats = new ArrayList<>();
        for (Owner owner : owners) {
            for (Animal pet : owner.getPets()) {
                if (Cat.class.equals(pet.getClass()) && Color.FOXY == pet.getColor()) {
                    findCats.add((Cat) pet);
                }
            }
        }

        Collections.sort(findCats, new Comparator<Cat>() {
            public int compare(Cat o1, Cat o2) {
                return o2.getAge() - o1.getAge();
            }
        });

        for (Cat cat : findCats) {
            findNames.add(cat.getName());
        }

        findNames.forEach(System.out::println);
    }

    /**
     * Наполнение данными
     */
    private static void initData() {
        final Owner owner1 = new Owner("Олег Малашков");
        owner1.getPets().addAll(List.of(
                new Cat("Барон", Color.BLACK, 3),
                new Cat("Султан", Color.DARK_GREY, 4),
                new Dog("Эльза", Color.WHITE, 0)
        ));

        final Owner owner2 = new Owner("Дмитрий Васильков");
        owner2.getPets().addAll(List.of(
                new Cat("Рыжик", Color.FOXY, 7),
                new Cat("Барсик", Color.FOXY, 5),
                new Parrot("Адмирал", Color.BLUE, 3)
        ));

        final Owner owner3 = new Owner("Наталия Криж");
        owner3.getPets().addAll(List.of(
                new Dog("Арнольд", Color.FOXY, 3),
                new Pig("Пылесос", Color.LIGHT_GREY, 8)
        ));

        final Owner owner4 = new Owner("Павел Мурахов");
        owner4.getPets().addAll(List.of(
                new Snake("Удав", Color.DARK_GREY, 2)
        ));

        final Owner owner5 = new Owner("Антон Федоренко");
        owner5.getPets().addAll(List.of(
                new Cat("Фишер", Color.BLACK, 16),
                new Cat("Зорро", Color.FOXY, 14),
                new Cat("Марго", Color.WHITE, 3),
                new Cat("Забияка", Color.DARK_GREY, 1)
        ));

        owners = List.of(owner1, owner2, owner3, owner4, owner5);
    }
}