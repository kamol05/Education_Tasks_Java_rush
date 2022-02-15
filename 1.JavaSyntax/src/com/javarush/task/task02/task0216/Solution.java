package com.javarush.task.task02.task0216;

/* 
Минимум трёх чисел
*/

public class Solution {
    public static int min(int a, int b, int c) {
        //напишите тут ваш код
        int g = a > b ? b : a;
        int z = b > c ? c : b;
        return g < z ? g : z;


    }

    public static void main(String[] args) {
        System.out.println(min(1, 2, 3));
        System.out.println(min(-1, -2, -3));
        System.out.println(min(3, 5, 3));
        System.out.println(min(5, 5, 10));
    }
}
