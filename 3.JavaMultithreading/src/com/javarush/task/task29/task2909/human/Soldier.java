package com.javarush.task.task29.task2909.human;

public class Soldier extends Human {
    @Override
    public void setBloodGroup(int code) {
        super.setBloodGroup(code);
    }

    @Override
    public int getBloodGroup() {
        return super.getBloodGroup();
    }

    public Soldier(String name, int age) {
        super(name, age);
    }

    @Override
    public int getAge() {
        return super.getAge();
    }

    @Override
    public void setAge(int age) {
        super.setAge(age);
    }

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public void setName(String name) {
        super.setName(name);
    }


    @Override
    public void live() {
        fight();
    }


    public void fight() {

    }

    @Override
    public int getId() {
        return super.getId();
    }

    @Override
    public void setId(int id) {
        super.setId(id);
    }

    @Override
    public void printSize() {
        super.printSize();
    }
}
