package com.github.demchenkovv.collections.level03.lecture10.XmlDomExample1.model;

public class Member extends Human {
    private String position;

    public Member(String name, String position) {
        super(name);
        this.position = position;
    }

    public String getPosition() {
        return position;
    }

    @Override
    public String toString() {
        return String.format("Сотрудник %s, должность %s", super.getName(), position);
    }
}
