package com.github.demchenkovv.level18.lecture00.task2;

import java.util.Comparator;

/*
Сортировка по возрасту
*/

public class AgeComparator
        implements Comparator<Student> {

    @Override
    public int compare(Student student1, Student student2) {
        if (student1.getAge() > student2.getAge())
            return 1;
        else if(student1.getAge() < student2.getAge())
            return -1;
        else
            return 0;
    }
}

/*
В классе Solution есть статическое поле students, которое заполняется студентами
(объектами типа Student) в методе main().
У студента (класс Student) есть имя (поле name) и возраст (поле age). Нужно отсортировать
в программе студентов по возрасту в убывающем порядке (от старшего к младшему).
Для этого используется метод Collections.sort(ArrayList<Student>, Comparator<Student>),
в который передается список студентов students и компаратор сортировки по убыванию возраста.

Твоя задача — реализовать этот компаратор. Для этого в классе AgeComparator нужно
имплементировать интерфейс Comparator<Student> и реализовать
метод int compare(Student student1, Student student2), который возвращает
числовое значение со следующими условиями:

отрицательное число, если возраст студента student1 больше возраста студента student2;
положительное число, если возраст студента student1 меньше возраста студента student2;
0, если возраст студентов student1 и student2 одинаковый.
Метод main() не принимает участие в тестировании.

Требования:
•	В классе AgeComparator нужно реализовать интерфейс Comparator<Student>.
•	В классе AgeComparator нужно создать публичный метод int compare(Student, Student).
•	Метод compare(Student, Student) нужно реализовать согласно условию.
 */