package com.javarush.task.task04.task0409;

/* 
Ближайшее к 10
*/

import java.util.jar.JarOutputStream;

public class Solution {
    public static void main(String[] args) {
        displayClosestToTen(8, 11);
        displayClosestToTen(7, 14);
    }

    public static void displayClosestToTen(int a, int b) {
        // напишите тут ваш код
        System.out.println(abs(a/10));


    }

    public static int abs(int a) {
        if (a < 0) {
            return -a;
        } else {
            return a;
        }
    }
}