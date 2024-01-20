package com.github.demchenkovv.collections.level03.lecture10.XmlSaxExample;

public class Employee {
    private String name;
    private String job;

    public Employee(String name, String job) {
        this.name = name;
        this.job = job;
    }

    public String getName() {
        return name;
    }

    public String getJob() {
        return job;
    }

    @Override
    public String toString() {
        return String.format("Имя сотрудника: %s, должность: %s", name, job);
    }
}