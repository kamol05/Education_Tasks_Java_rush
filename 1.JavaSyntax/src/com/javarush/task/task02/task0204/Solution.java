package com.javarush.task.task02.task0204;

/* 
О семейных отношениях
*/

public class Solution {
    public static void main(String[] args) {
        //напишите тут ваш код
        Man man = new Man();
        Woman woman = new Woman();

        man.wife = woman;
        woman.husband = man;

        System.out.println(man.wife.name + " " + woman.husband.name);
    }

    public static class Man {
        public int age;
        public int height;
        public Woman wife;
        public String name = "stewart";
    }

    public static class Woman {
        public int age;
        public int height;
        public Man husband;
        public String name = "lily";
    }
}
