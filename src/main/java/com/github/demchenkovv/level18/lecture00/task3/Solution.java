package com.github.demchenkovv.level18.lecture00.task3;

import java.util.ArrayList;
import java.util.Collections;

public class Solution {
    public static ArrayList<JavaRushMentor> mentors = new ArrayList<>();

    public static void main(String[] args) {
        Collections.addAll(mentors,
                new JavaRushMentor("Джон Бобров"),
                new JavaRushMentor("Риша"),
                new JavaRushMentor("Эллеонора Керри"),
                new JavaRushMentor("Ханс Нудлс"),
                new JavaRushMentor("Ким"),
                new JavaRushMentor("Хулио Сиеста"),
                new JavaRushMentor("Диего"),
                new JavaRushMentor("Лага Билаабо")
        );

        Collections.sort(mentors, new NameComparator());

        for (JavaRushMentor mentor : mentors) {
            System.out.println(mentor);
        }
    }
}
