package com.github.demchenkovv.collections.level03.lecture10.XmlDomExample1.model;

public class Student extends Human {
    private String course;
    private String specialization;

    public Student(String name, String course, String specialization) {
        super(name);
        this.course = course;
        this.specialization = specialization;
    }

    public String getCourse() {
        return course;
    }

    public String getSpecialization() {
        return specialization;
    }

    @Override
    public String toString() {
        return String.format("Студент %s с %s курса учится на %s", super.getName(), course, specialization);
    }
}
