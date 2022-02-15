package com.javarush.task.task06.task0614;

/*
Статические коты
*/

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Cat {
    public static ArrayList<Cat> cats = new ArrayList<>();


    public Cat() {
    }

    public static void main(String[] args) {
        cats.add(new Cat());
        printCats();
    }

    public static void printCats() {
        for (Cat e : cats){
            System.out.println(e);
        }
    }
}
