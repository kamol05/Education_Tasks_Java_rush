package com.javarush.task.task07.task0724;

/* 
Семейная перепись
*/

public class Solution {
    public static void main(String[] args) {
        // напишите тут ваш код
        Human grandfa1 = new Human("ded1m",true,6);
        Human grangfa2 = new Human("ded2m",true,60);
        Human grandma1 = new Human("ded1f",false,60);
        Human grangma2 = new Human("ded2f",false,60);
        Human fa = new Human("pa",true,40,grandfa1,grandma1);
        Human ma = new Human("ma",false,38,grangfa2,grangma2);
        Human son = new Human("son",true,28,fa,ma);
        Human dau = new Human("dau",false,24,fa,ma);
        Human dau2 = new Human("dau2",false,15,fa,ma);
        System.out.println(grandfa1.toString());
        System.out.println(grandma1.toString());
        System.out.println(grangfa2.toString());
        System.out.println(grangma2.toString());
        System.out.println(fa.toString());
        System.out.println(ma.toString());
        System.out.println(son.toString());
        System.out.println(dau.toString());
        System.out.println(dau2.toString());
    }

    public static class Human {

        public Human(String name,boolean sex,int age, Human father,Human mother)
        {
            this.name = name;
            this.sex = sex;
            this.age = age;
            this.father = father;
            this.mother = mother;
        }
        public Human(String name,boolean sex,int age)
        {
            this.name = name;
            this.sex = sex;
            this.age = age;
            this.father = father;
            this.mother = mother;
        }
        // напишите тут ваш код
        String name;
        boolean sex;
        int age;
        Human father;
        Human mother;

        public String toString() {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            if (this.father != null) {
                text += ", отец: " + this.father.name;
            }

            if (this.mother != null) {
                text += ", мать: " + this.mother.name;
            }
            return text;
        }
    }
}