package com.javarush.task.task06.task0613;

/* 
Кот и статика
*/

public class Solution {
    public static void main(String[] args) {
       while (Cat.catCount < 10){
           Cat cat = new Cat();
       }
        System.out.println(Cat.catCount);
    }

    public static class Cat {
        public static int catCount;

        public Cat(){
            catCount++;
        }
    }
}