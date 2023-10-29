package com.github.demchenkovv.javacore.level10.lecture07.task03;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/* 
Externalizable Person
*/

public class Solution {
    public static class Person implements Externalizable {
        private String firstName;
        private String lastName;
        private int age;
        private Person mother;
        private Person father;
        private List<Person> children;

        public Person() {
        }

        public Person(String firstName, String lastName, int age) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.age = age;
        }

        public void setMother(Person mother) {
            this.mother = mother;
        }

        public void setFather(Person father) {
            this.father = father;
        }

        public void setChildren(List<Person> children) {
            this.children = children;
        }

        @Override
        public void writeExternal(ObjectOutput out) throws IOException {
            out.writeObject(mother);
            out.writeObject(father);
            out.writeObject(firstName);
            out.writeObject(lastName);
            out.writeInt(age);
            out.writeObject(children);
        }

        @Override
        public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
            mother = (Person) in.readObject();
            father = (Person) in.readObject();
            firstName = (String) in.readObject();
            lastName = (String) in.readObject();
            age = in.readInt();
            children = (List) in.readObject();
        }

        @Override
        public String toString() {
            return "Person{" +
                   "firstName='" + firstName + '\'' +
                   ", lastName='" + lastName + '\'' +
                   ", age=" + age +
                   ", mother=" + mother +
                   ", father=" + father +
                   ", children=" + children +
                   '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Person person = (Person) o;

            if (age != person.age) return false;
            if (!Objects.equals(firstName, person.firstName)) return false;
            if (!Objects.equals(lastName, person.lastName)) return false;
            if (!Objects.equals(mother, person.mother)) return false;
            if (!Objects.equals(father, person.father)) return false;
            return Objects.equals(children, person.children);
        }

        @Override
        public int hashCode() {
            int result = firstName != null ? firstName.hashCode() : 0;
            result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
            result = 31 * result + age;
            result = 31 * result + (mother != null ? mother.hashCode() : 0);
            result = 31 * result + (father != null ? father.hashCode() : 0);
            result = 31 * result + (children != null ? children.hashCode() : 0);
            return result;
        }
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Person writePerson = new Person("John", "Rambo", 35);
        writePerson.setMother(new Person("Mother", "M", 55));
        writePerson.setFather(new Person("Father", "F", 65));
        writePerson.setChildren(new ArrayList<>(Arrays.asList(
                new Person("Child1", "Ch1", 15),
                new Person("Child2", "Ch2", 10))));


        File tempFile = File.createTempFile("task2013", ".tmp");
        writePerson.writeExternal(new ObjectOutputStream(new FileOutputStream(tempFile)));

        Person readPerson = new Person();
        readPerson.readExternal(new ObjectInputStream(new FileInputStream(tempFile)));

        System.out.println(writePerson);
        System.out.println("============================");
        System.out.println(readPerson);

        System.out.printf("\nwritePerson equals readPerson: %b\n",
                writePerson.equals(readPerson));
    }
}
