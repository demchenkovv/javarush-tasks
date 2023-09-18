package com.github.demchenkovv.javasyntaxzero.level11.lecture05.task1;

/*
Почувствуй себя деканом
*/

import java.util.ArrayList;
import java.util.List;

public class UniversityGroup {
    public List<String> students;

    public UniversityGroup() {
        students = new ArrayList<>();
        students.add("Сергей Фрединский");
        students.add("Виталий Правдивый");
        students.add("Максим Козыменко");
        students.add("Наталия Андрющенко");
        students.add("Ира Величенко");
        students.add("Николай Соболев");
        students.add("Снежана Слободенюк");
    }

    // Вариант 1 (создать копию списка copy, итерироваться по копии copy, удалять из исходника students)
    public void exclude(String excludedStudent) {
        List<String> copy = new ArrayList<>(students);
        for (String student : copy) {
            if (student.equals(excludedStudent)) {
                students.remove(student);
            }
        }
    }

    // Вариант 2 (через лямбда-выражение)
//    public void exclude(String excludedStudent) {
//        ArrayList<String> list = new ArrayList<>();
//        Collections.copy(students, list); // (List<? super T> dest, List<? extends T> src) --> (куда, откуда)
//        list.removeIf( x-> x.equals(excludedStudent) );
//    }

    // Вариант 3 через итератор (здесь не показан)

    public static void main(String[] args) {
        UniversityGroup universityGroup = new UniversityGroup();
        universityGroup.exclude("Виталий Правдивый");
        universityGroup.students.forEach(System.out::println);
    }
}


