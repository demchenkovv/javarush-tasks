package com.github.demchenkovv.collections.level03.lecture10.XmlDomExample1.model;

public class Professor extends Human {
    private String experience;
    private String discipline;

    public Professor(String name, String experience, String discipline) {
        super(name);
        this.experience = experience;
        this.discipline = discipline;
    }

    public String getExperience() {
        return experience;
    }

    public String getDiscipline() {
        return discipline;
    }

    @Override
    public String toString() {
        return String.format("Профессор %s с опытом %s преподает %s", super.getName(), experience, discipline);
    }
}
