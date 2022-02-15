package com.javarush.task.task35.task3510;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* 
Вход воспрещен!
*/

public class House <T> {
    private boolean b = true;

    private List<T> residents = new ArrayList();

    public void enter(T resident) {

        Class c = residents.size() > 0 ? residents.get(0).getClass() : null;
        if (b){
            c = resident.getClass();
            b = false;
        }
        if ( resident.getClass().equals(c) | c.isAssignableFrom(resident.getClass()) | resident.getClass().isAssignableFrom(c)){
            residents.add(resident);
        }
    }

    public void leave(T resident) {
        residents.remove(resident);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("В доме находятся:\n");
        for (Object resident : residents) {
            builder.append(resident.toString()).append("\n");
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        Dog bruno = new Dog("Bruno");
        Puppy larsik = new Puppy("Larsik");

        Cat barsik = new Cat("Barsik");
        Kitten keksik = new Kitten("Keksik");

        House<Dog> dogHouse = new House<>();
        dogHouse.enter(larsik);
        dogHouse.enter(bruno);
        dogHouse.enter(barsik);
        System.out.println(dogHouse.toString());

        House catHouse = new House<>();
        catHouse.enter(keksik);
        catHouse.enter(barsik);
        catHouse.enter(bruno);
        System.out.println(catHouse.toString());
    }
}
