package com.javarush.task.task05.task0502;

/* 
Реализовать метод fight
*/

public class Cat {
    public int age;
    public int weight;
    public int strength;

    public Cat() {
    }

    public boolean fight(Cat anotherCat) {
        int t = 0;
        int k = 0;
        if (this.age > anotherCat.age) {
            t++;
        } else {
            k++;
        }
        if (this.weight > anotherCat.weight){t++;} else { k++; }
        if (this.strength > anotherCat.strength){t++;} else {k++;}

        return t > k;
    }

    public static void main(String[] args) {
        Cat c = new Cat();
        Cat cc = new Cat();

        c.age = 1;
        c.strength = 1;
        c.weight = 1;

        cc.age = 11;
        cc.strength = 11;
        cc.weight = 11;

        System.out.println(c.fight(c));

    }
}
