package com.javarush.task.task12.task1229;

/* 
Родитель класса CTO
*/

public class Solution {

    public static void main(String[] args) {
        CTO cto = new CTO();
        System.out.println(cto);
    }

    public static interface Businessman {
        public void workHard();
    }

    public abstract static class One {
        public void workHard() {
            System.out.println("");
        }
    }

    public static class CTO extends One implements Businessman {

    }
}
