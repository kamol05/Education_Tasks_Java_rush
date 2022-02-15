package com.javarush.task.task05.task0509;

/* 
Создать класс Friend
*/

public class Friend {
    String name;
    int age;
    char sex;

    public void intialize(String name){
        this.name = name;
    }
    public void intialize(String name, int age){
        this.name = name;
        this.age = age;
    }
    public void intialize(String name,int age, char sex){
        this.name = name;
        this.age = age;
        this.sex = sex;
    }

    public static void main(String[] args) {

    }
}
