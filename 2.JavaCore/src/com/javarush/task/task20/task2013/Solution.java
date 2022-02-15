package com.javarush.task.task20.task2013;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/* 
Externalizable Person
*/

public class Solution {
    public static class Person implements Externalizable{
        private String firstName;
        private String lastName;
        private int age;
        private Person mother;
        private Person father;
        private List<Person> children;

        public Person(String firstName, String lastName, int age) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.age = age;
        }

        public Person() {
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
            out.writeObject(firstName);
            out.writeObject(mother);
            out.writeObject(lastName);
            out.writeObject(father);
            out.writeObject(age);
            out.writeObject(children);
        }

        @Override
        public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
            firstName = (String) in.readObject();
            mother = (Person) in.readObject();
            lastName = (String) in.readObject();
            father = (Person) in.readObject();
            age = (int) in.readObject();
            children = (List<Person>) in.readObject();
        }
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Person p = new Person("d","d",5);
        p.setFather(new Person("b","b",5));
        p.setMother(new Person("o","o",5));
        Person child1 = new Person("1","1",1);
        Person child2 = new Person("1","1",1);
        ArrayList<Person> child = new ArrayList<>();
        child.add(child1);
        child.add(child2);
        p.setChildren((child));

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(baos);
        p.writeExternal(oos);

        ObjectInputStream ois = new ObjectInputStream(new ByteArrayInputStream(baos.toByteArray()));
        Person p1 = new Person();
        p1.readExternal(ois);

        System.out.println(p.equals(p1));
    }
}
