package com.github.demchenkovv.multithreading.level05.lecture16.task2909.human;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;

public class University {
    private List<Student> students = new ArrayList<>();
    private String name;
    private int age;

    public University(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Student getStudentWithAverageGrade(double averageGrade) {
        String studentNotFound = "University#getStudentWithAverageGrade: Студент с таким средним баллом не найден.";
        return students.stream().filter(student -> student.getAverageGrade() == averageGrade).findFirst()
                .orElseThrow(() -> new NoSuchElementException(studentNotFound));
    }

    public Student getStudentWithMaxAverageGrade() {
        return students.stream().max(Comparator.comparingDouble(Student::getAverageGrade)).get();
    }

    public Student getStudentWithMinAverageGrade() {
        return students.stream().min(Comparator.comparingDouble(Student::getAverageGrade)).get();
    }

    public void expel(Student student) {
        students.remove(student);
    }
}