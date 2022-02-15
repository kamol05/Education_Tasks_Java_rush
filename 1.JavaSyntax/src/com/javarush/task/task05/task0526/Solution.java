package com.javarush.task.task05.task0526;

/* 
Мужчина и женщина
*/

public class Solution {
    public static void main(String[] args) {
        Man man1 = new Man("serg",25,"ff");
        System.out.println(man1.toString());
        Woman wan1 = new Woman("serg",25,"ff");
        System.out.println(wan1.toString());

    }

    public static class Man {
        public String name;
        public int age;
        public String address;

        public Man (String name,int age, String address){
            this.address = address;
            this.age = age;
            this.name = name;
        }

        @Override
        public String toString() {
            return name + " " + age + " " + address;
        }
    }
    public static class Woman {
        public String name;
        public int age;
        public String address;

        public Woman (String name,int age, String address){
            this.address = address;
            this.age = age;
            this.name = name;
        }

        @Override
        public String toString() {
            return name + " " + age + " " + address;
        }
    }
}
