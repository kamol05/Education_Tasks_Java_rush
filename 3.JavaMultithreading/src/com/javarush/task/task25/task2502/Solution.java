package com.javarush.task.task25.task2502;

import java.util.*;

/* 
Машину на СТО не повезем!
*/

public class Solution {
    public static enum Wheel {
        FRONT_LEFT,
        FRONT_RIGHT,
        BACK_LEFT,
        BACK_RIGHT
    }

    public static class Car {
        protected List<Wheel> wheels;

        public Car() {
            Set<com.javarush.task.task25.task2502.Solution.Wheel> wheelSet = new HashSet<>(4);
            String[] wheelNamesFromDb = loadWheelNamesFromDB();
            if (wheelNamesFromDb.length != 4) throw new IllegalArgumentException();
            for (String wheelName : wheelNamesFromDb) {
                wheelSet.add(com.javarush.task.task25.task2502.Solution.Wheel.valueOf(wheelName));
            }
            if (wheelSet.size() != 4) throw new IllegalArgumentException();
            wheels = new ArrayList<>(wheelSet);
        }

        protected String[] loadWheelNamesFromDB() {
            //this method returns mock data
            return new String[]{"sssuka","FRONT_LEFT", "FRONT_RIGHT", "BACK_LEFT", "BACK_RIGHT"};
        }
    }

    public static void main(String[] args) {
        Car car = new Car();
        for (Wheel w : car.wheels){
            System.out.println(w.toString());
        }
    }
}
